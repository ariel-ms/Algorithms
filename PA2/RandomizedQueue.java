import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    
    // construct an empty randomized queue
    public RandomizedQueue() {
    }
    
    // @return true if the queue is empty
    public boolean isEmpty() {
        return false;
    }
    
    // @return the number of items on the queue
    public int size() {
        return 0;
    }
    
    // add the item to the queue
    public void enqueue(Item item) {
    }
    
    // remove and return a random queue
    public Item dequeue() {
        return null;
    }
    
    // return (but do not remove) a random item
    public Item sample() {
        return null;
    }
    
    // return an idependent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    // class that implements the Iterator interface
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
    
    // main to test
    public static void main(String[] args) {
    }
    
}