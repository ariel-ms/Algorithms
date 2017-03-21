import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<String>();
        int k = Integer.parseInt(args[0]);
        while (StdIn.hasNextChar()) {
            String word = StdIn.readString();
            // StdOut.print(word);
            queue.enqueue(word);
        }
        
        Iterator<String> it = queue.iterator();
        while (it.hasNext()) {
           //  System.out.print(it.next());
            StdOut.print(it.next());
        }
    }
}