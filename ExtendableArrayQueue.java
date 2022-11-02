import java.util.Arrays;

/**
 * This class is for completion in Practical 3ii
*/
public class ExtendableArrayQueue<E> implements QueueADT<E> {
   protected E[] Q; // Q will refer to the array
   protected int f; // front - array index of element at front of queue
   protected int r; // rear - array index of where next element added will be placed 
   protected int N;  // array capacity

   /**
    * Constructor for objects of class ExtendableArrayQueue.
    * In practical 3ii no change need be made to this constructor.
    * With this constructor a queue can initially hold up to 
    * 3 (i.e.N-1) items when using the approach described in lectures.
    */
   public ExtendableArrayQueue() {
      N = 4;
      Q = (E[]) new Object[N];
      f = 0;
      r = 0;
   }
   
   // Complete the method bodies below and add any further methods if 
   // appropriate. Many of the method bodies can be the same as in Q3i
   
   public void enqueue(E element) {
      if (size() == N - 1) {
         E[] temp = (E[]) new Object[Q.length + 1];
         System.arraycopy(Q, f, temp, 0, Q.length - f);
         System.arraycopy(Q, 0, temp, Q.length - f, f);
         Q = temp;
         f = 0;
         r = N - 1;
         N++;
      }
      Q[r] = element;
      r = (r + 1) % N;

   }
   
   /**
     @throws EmptyQueueException
   */
   public E dequeue() {
      if (isEmpty()) throw new EmptyQueueException("Queue Empty");
      E e = Q[f];
      Q[f] = null;
      f = (f + 1) % N;
      return e;
   }

   /**
     @throws EmptyQueueException
   */
   public E front() {
      if (!isEmpty()) return Q[f];
      throw new EmptyQueueException("Queue Empty");
   }

   public int size() {
      return (N - f + r) % N;
   }

   public boolean isEmpty() {
      return (f == r);
   }
}
