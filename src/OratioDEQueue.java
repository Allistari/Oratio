/**
 * OratioDEQueue
 * A custom double ended queue
 * @author Eric Ke
 * Created: 2018-11-16
 * Last Modified: 2018-11-21
 */

public class OratioDEQueue<T> {

    private OratioLinkedList<T> stuffQueue = new OratioLinkedList<>();

    public OratioDEQueue() {

    }

    public void addFirst(T item) {
        stuffQueue.add(item, 0);
    }

    public void addLast(T item) {
        stuffQueue.add(item);
    }

    public T pollFirst() {
        return stuffQueue.remove(0);
    }

    public T pollLast() {
        return stuffQueue.remove(stuffQueue.size()-1);
    }

    public int size() {
        return stuffQueue.size();
    }

    public boolean isEmpty() {
        if (stuffQueue.size() < 1) {
            return true;
        } else {
            return false;
        }
    }

}
