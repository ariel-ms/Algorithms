import java.util.Iterator;
import java.util.NoSuchElementException;
// import java.util.Scanner;

public class Deque<Item> implements Iterable<Item> {
    /**
     Doubly linkedlist structure with sentinel nodes.
     */
    private int size;
    private Node<Item> head;
    private Node<Item> tail;
    
    private class Node<E> {
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
        if (checkNull(item)) throw new NullPointerException();
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
        if (checkNull(item)) throw new NullPointerException();
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
    
    // @return true if item is equal to null
    private boolean checkNull(Item item) {
        return item == null;
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
        // Test Deque using addLast
        // Input: 5,7,3,2,1
        // Output:
        // Add last: 5,7,3,2,1
        // Add firt: 1,2,3,7,5
        
        // Scanner sc = new Scanner(System.in);
        int[] input = {5, 7, 3, 2, 1};
        Deque<Integer> dt = new Deque<Integer>();
        // Is empty: true
        System.out.println("Is empty: " + dt.isEmpty());
        for (int n : input) {
            // int n = sc.nextInt();
            dt.addLast(n);
        }
        // remove first: 7,3,2,1
        dt.removeFirst();
        // remove last: 7,3,2
        dt.removeLast();
        // size: 3
        System.out.println("size: "+dt.size());
        // add last 10: 7,3,2,10
        dt.addLast(10);
        // add first 0: 0,7,3,2,10
        dt.addFirst(0);
        // size: 5
        System.out.println("size: "+dt.size());
        for (int element : dt) {
            System.out.print(element + " ");
        }
        // sc.close();
    }
}