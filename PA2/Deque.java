import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private int size;
    private Node<Item> head;
    private Node<Item> tail;
    
    class Node<Item> {
        Node<Item> next;
        Node<Item> prev;
        Item data;
        
        public Node(Item data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    // construct an empty deque
    public Deque() {
        size = 0;
        head = new Node<Item>(null);
        head.next = tail;
        tail.prev = head;
    }
    
    // @return true if deque is empty
    public boolean isEmpty() {
        return (head.next == tail) && (tail.prev == head);
    }
    
    // @return the number of elements on the deque
    public int size() {
        return size;
    }
    
    // add the item to the front
    public void addFirst(Item item) {
        Node<Item> node = new Node<Item>(item);
        if (size == 0) {
            // set the pointers of the new node
            node.prev = tail.prev;
            node.next = head.next;
            // rearrange the pointers of head and tail
            head.next = node;
            tail.prev = node;
        } 
        else {
            // set the pointers of the new node
            node.next = head.next;
            node.prev = head;
            // rearrage the pointers of head and head + 1
            head.next.prev = node;
            head.next = node;
        }
        size += 1;
    }
    
    // add the item to the end
    public void addLast(Item item) {
        Node<Item> node = new Node<Item>(item);
        tail.next = node;
        tail = node;
    }
    
    // remove and return the item from the front
    public Item removeFirst() {
        Item data = head.data;
        head = head.next;
        return data;
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