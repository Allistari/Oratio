/**
 * OratioDEQueue
 * A custom double ended queue
 * @author Eric Ke
 * Created: 2018-11-16
 * Last Modified: 2018-11-21
 */
public class OratioDEQueue<T> {

    private OratioLinkedList<T> stuffQueue;

    /**
     * creates a new double ended queue
     */
    public OratioDEQueue() {
        stuffQueue = new OratioLinkedList<T>();
    }

    /**
     * adds an item to the front of the queue
     * @param item the object to be added
     */
    public void addFirst(T item) {
        stuffQueue.add(item, 0);
    }

    /**
     * adds an item to the back of the queue
     * @param item the object to be added
     */
    public void addLast(T item) {
        stuffQueue.add(item);
    }

    /**
     * polls from front of queue
     * @return the object from the front of the queue
     */
    public T pollFirst() {
        return stuffQueue.remove(0);
    }

    /**
     * polls from back of queue
     * @return the object from the back of the queue
     */
    public T pollLast() {
        return stuffQueue.remove(stuffQueue.size()-1);
    }

    /**
     * gets the size of the queue
     * @return the size of the queue
     */
    public int size() {
        return stuffQueue.size();
    }

    /**
     * determines if the queue is empty
     * @return whether the queue is empty or not
     */
    public boolean isEmpty() {
        if (stuffQueue.size() < 1) {
            return true;
        } else {
            return false;
        }
    }

}
