/**
 * This class is for completion in Practical 3iii
 * The Node class is supplied for you
*/
public class NodeQueue<E> implements QueueADT<E> {
    // references to the head and tail of
    // the linked list
    protected Node<E> head, tail;
    // number of elements in the queue
    protected int size;

    /** constructs an empty queue
    */
    public NodeQueue() {
       head = null;
       tail = null;
       size = 0;
    }

   // Complete the method bodies below. Take care
   // that exceptions to the correct types are thrown by
   // your methods as specified in the method comments.

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void enqueue(E elem) {
        // create and link in a new node at tail
        Node<E> newNode = new Node<E>(elem, null);
        if (tail != null) {
            tail.setNext(newNode);
        }
        tail = newNode;
        if (isEmpty()) {
            head = newNode;
            head.setNext(tail);
        }
        size++;
    }

    /**
     @throws EmptyQueueException
    */
    public E front() {
        if (!isEmpty()) return head.getElement();
        throw new EmptyQueueException ("Queue Empty");
    }

    /**
     @throws EmptyQueueException
    */
    public E dequeue() {
        if (isEmpty()
        ) throw new EmptyQueueException ("Queue Empty");
        E element = head.getElement();
        Node<E> temp = head.getNext();
        head = temp;
        size --;
        return element;
    }
  }
