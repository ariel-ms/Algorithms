import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
// import java.util.Iterator;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        int k = Integer.parseInt(args[0]);
        String word;
        while (!StdIn.isEmpty()) {
            word = StdIn.readString();
            // StdOut.println(word);
            queue.enqueue(word);
        }
        // System.out.println(queue.size());
        for (int i = 0; i < k; i++) {
            StdOut.println(queue.dequeue());
            // System.out.println(queue.size());
        }
        // Iterator test
        /** Iterator<String> it = queue.iterator();
        while (it.hasNext()) {
           //  System.out.print(it.next());
            StdOut.print(it.next());
        } */
    }
}