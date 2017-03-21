import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] array;
    private int size;
    // construct an empty randomized queue
    public RandomizedQueue() {
        array = (Item[]) new Object[1];
        size = 0;
    }
    
    // @return true if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // @return the number of items on the queue
    public int size() {
        return size;
    }
    
    // add the item to the queue
    public void enqueue(Item item) {
        if (item == null) throw new NullPointerException();
        if (size == array.length) resize(size * 2); 
        array[size++] = item;
    }
    
    private void resize(int capacity) {
        Item[] tempArr = (Item[]) new Object[capacity];
        for (int i = 0; i < array.length; i++) {
            tempArr[i] = array[i];
        }
        array = tempArr;
    }
    // remove and return a random item
    public Item dequeue() {
        if (size == 0) throw new NoSuchElementException();
        knuthShuffle();
        // int index = StdRandom.uniform(size + 1);
        Item item = array[--size];
        array[size] = null;
        // size--;
        if (size > 0 && size == array.length / 4) resize(array.length / 2);
        return item;
    }
    
    // return (but do not remove) a random item
    public Item sample() {
        if (size == 0) throw new NoSuchElementException();
        knuthShuffle();
        // int index = StdRandom.uniform(size + 1);
        return array[size - 1];
    }

    // Knuth shuffle - generates uniformly random permutaion
    private void knuthShuffle() {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int rand = StdRandom.uniform(i + 1);
            exch(i, rand);
        }
    }

    // interchanges the keys of the provided indexes
    private void exch(int i, int j) {
        Item temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // return an idependent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    
    // class that implements the Iterator interface
    private class ListIterator implements Iterator<Item> {
        private int n = size;
        public boolean hasNext() {
            return n > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return array[--n];
        }
    }
    
    // main to test
    public static void main(String[] args) {
    }
    
}