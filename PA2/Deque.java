import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private int size;
    private Node<Item> head;
    
    class Node<Item> {
        Node<Item> next;
        Item data;
        
        public Node(Item data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // construct an empty deque
    public Deque() {
        size = 0;
        head = new Node<Item>(null);
        head.next = null;
    }
    
    // @return true if deque is empty
    public boolean isEmpty() {
        return true;
    }
    
    // @return the number of elements on the deque
    public int size() {
        return size;
    }
    
    // add the item to the front
    public void addFirst(Item item) {
    }
    
    // add the item to the end
    public void addLast(Item item) {
    }
    
    // remove and return the item from the front
    public Item removeFirst() {
        return null;
    }
    
    // remove and return the item from the end
    public Item removeLast() {
        return null;
    }
    
    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    //  class the implements the Iterator interface
    private class ListIterator implements Iterator<Item> {
        public boolean hasNext() {
            return false;
        }
        public void remove() {
        }
        public Item next() {
            return null;
        }
    }
    
    // main for testing
    public static void main(String[] args) {
    }
}