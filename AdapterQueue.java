import java.util.List;
import java.util.ArrayList;
/**
 * This class is for completion in Practical 3iv
*/
public class AdapterQueue<E> implements QueueADT<E>{

   protected ArrayList<E> aList;
   // Note: in above, interface List could instead replace ArrayList
   // but no need to alter the above in this exercise

   public AdapterQueue(){
       aList = new ArrayList<E>();
   }

   // Complete the method bodies below using the adapter pattern,
   // by calling appropriate methods on the field aList. Take care
   // that exceptions of the correct types are thrown by your methods,
   // as specified in the method comments.

   public void enqueue(E element) {
        aList.add(element);
   }

   /**
     @throws EmptyQueueException
   */
   public E dequeue(){
        try {
            return aList.remove(0);
        } catch (Exception e) {
            throw new EmptyQueueException ("Queue Empty");
        }
   }

   /**
     @throws EmptyQueueException
   */
   public E front(){
       try {
           return aList.get(0);
       } catch (Exception e) {
           throw new EmptyQueueException ("Queue Empty");
       }

   }

   public int size() {
        return aList.size();
   }

   public boolean isEmpty() {
        return aList.isEmpty();
   }
}