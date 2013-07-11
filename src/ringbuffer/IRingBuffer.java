/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ringbuffer;

/**
 *
 * @author hubi
 */
public interface IRingBuffer {
    
    public int pop();
    public void push(int i);
}
