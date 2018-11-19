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

}
