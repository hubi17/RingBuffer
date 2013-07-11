/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ringbuffer;

import java.util.EmptyStackException;

/**
 *
 * @author hubi
 */
public class RingBuffer implements IRingBuffer {

    private int[] buffer;
    private int size;
    private int count;
    private int wcount;
    private int rcount;

    /**
     * Initialize RingBuffer
     *
     * @param pSize size of the RingBuffer
     */
    public RingBuffer(int pSize) {

        size = pSize;
        count = 0;
        wcount = 0;
        rcount = 0;
        buffer = new int[size];
    }

    /**
     * Add element to RingBuffer
     *
     * @param i element to be added
     */
    @Override
    public void push(int i) throws RingBufferException {

        if (wcount % size <= rcount % size) {
            buffer[wcount % size] = i;
            count++;
            wcount++;
        } else {

            throw new RingBufferException("Overwriting unread elements");
        }
    }

    /**
     * Remove element from RingBuffer
     *
     * @return Element to be popped
     */
    @Override
    public int pop() throws RingBufferException {

        int vReturn;

        if (count > 0) {

            vReturn = buffer[rcount % size];
            count--;
            rcount++;
        } else {

            throw new RingBufferException("No elements in Buffer");
        }

        return vReturn;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        RingBuffer rb = new RingBuffer(10);

        try {

            rb.push(1);
            System.out.println(rb.pop());
            rb.push(2);
            System.out.println(rb.pop());
            rb.push(3);
            System.out.println(rb.pop());
            rb.push(4);
            System.out.println(rb.pop());
            rb.push(5);
            System.out.println(rb.pop());
            rb.push(6);
            System.out.println(rb.pop());
            rb.push(7);
            System.out.println(rb.pop());
            rb.push(8);
            System.out.println(rb.pop());
            rb.push(9);
            System.out.println(rb.pop());
            rb.push(10);
            System.out.println(rb.pop());
            rb.push(11);
            System.out.println(rb.pop());
            rb.push(12);
            System.out.println(rb.pop());
            rb.push(13);
            rb.push(14);
            rb.push(15);
            rb.push(16);
            System.out.println(rb.pop());
        } catch (RingBufferException e) {

            System.out.println(e.getMessage());
        }
    }
}
