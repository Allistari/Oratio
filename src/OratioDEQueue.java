public class OratioDEQueue<E> {

    private OratioLinkedList<E> stuffQueue = new OratioLinkedList<>();

    public OratioDEQueue() {

    }

    public void addFirst(E item) {
        stuffQueue.add(item, 0);
    }

    public void addLast(E item) {
        stuffQueue.add(item);
    }

    public E pollFirst() {
        return stuffQueue.remove(0);
    }

    public E pollLast() {
        return stuffQueue.remove(stuffQueue.size()-1);
    }

}
