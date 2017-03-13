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
    
    public Deque() {
        size = 0;
        head = new Node<Item>(null);
        head.next = null;
    }
    
    public boolean isEmpty() {
        return true;
    }
    
    public int size() {
        return 0;
    }
    
    public void addFirst(Item item) {
    }
    
    public void addLast(Item item) {
    }
    
    public Item removeFirst() {
        return null;
    }
    
    public Item removeLast() {
        return null;
    }
    
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
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
     
    public static void main(String[] args) {
    }
}