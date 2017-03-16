import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    /**
     Doubly linkedlist structure with sentinel nodes.
     */
    private int size;
    private Node<Item> head;
    private Node<Item> tail;
    
    class Node<E> {
        Node<E> next;
        Node<E> prev;
        E data;
        
        public Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    
    // construct an empty deque
    public Deque() {
        size = 0;
        head = new Node<Item>(null);
        tail = new Node<Item>(null);
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
        // set new node next and prev pointers
        node.next = tail;
        node.prev = tail.prev;
        if (size == 0) {
            // rearrange head and tail pointers
            head.next = node;
            tail.prev = node;
        } 
        else {
            // rearrange next and prev pointers of previous node
            // and from tail node
            tail.prev.next = node;
            tail.prev = node;
        }
        size += 1;
    }
    
    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        // save item and delete next node
        Item data = head.next.data;
        head.next.next.prev = head;
        head.next = head.next.next;
        size -= 1;
        return data;
    }
    
    // remove and return the item from the end
    public Item removeLast() {
        if (size == 0) 
            throw new NoSuchElementException();
        
        // save item and delete previous node
        Item data = tail.prev.data;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        size -= 1;
        return data;
    }
    
    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    //  class the implements the Iterator interface
    private class ListIterator implements Iterator<Item> {
        // current node points to the first element in the list
        private Node<Item> current = head.next;

        // @return false if no more elements in list 
        public boolean hasNext() {
            return !(current == tail);
        }

        // throw exception in client calls this operation
        public void remove() {
            throw new UnsupportedOperationException();
        }

        // @return the item "data" of current node
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.data;
            current = current.next;
            return item;
        }
    }
    
    // main for testing
    public static void main(String[] args) {
    }
}