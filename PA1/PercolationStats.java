import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
// import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
Algorithms, Part 1
Programming Assignment: Percolation
This class performs computational experiments using the Percolation class.
*/


// Perform trials experiments on an n-by-n grid
public class PercolationStats {
    // private Percolation grid;
    // private double[] data;
    private double stddev;
    private double mean;
    private int t;

    public PercolationStats(int n, int trials) { 
        if (n <= 0 || trials <= 0)  {
            throw new IllegalArgumentException();
        }
        double[] data = new double[trials];
        int siteRow, siteCol;
        t = trials;
        for (int i = 0; i < trials; i++) {
            // StdRandom.setSeed((long) i);
            Percolation grid = new Percolation(n);
            while (!grid.percolates()) {
                /** do{
                  siteRow = StdRandom.uniform(1, n+1);
                  siteCol = StdRandom.uniform(1, n+1);
                  }while(grid.isOpen(siteRow, siteCol)); */
                
                siteRow = StdRandom.uniform(1, n+1);
                siteCol = StdRandom.uniform(1, n+1);
                // System.out.println(siteRow +" " +siteCol);
                grid.open(siteRow, siteCol);
            }
            // System.out.println(grid.numberOfOpenSites());
            data[i] = (double) grid.numberOfOpenSites() / (n*n); 
        }
        mean = StdStats.mean(data);
        stddev = StdStats.stddev(data);
    }
    
    // @return mean of percolation threshold
    public double mean() {
        return mean;
    }

    // @return standard deviation of percolation threshold
    public double stddev() {
        if (t == 1)
            return Double.NaN;
        return stddev;
    }
    
    // @return low endpoint of 95% confidence interval
    public double confidenceLo() {
        return (mean - ((1.96*stddev)/Math.sqrt(t)));
    }
    
    // @return high endpoint of 95% confidence interval
    public double confidenceHi() {
        return (mean + ((1.96*stddev)/Math.sqrt(t)));
    }
    
    public static void main(String[] args) { 
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        /** int n = 200;
        int trials = 100; **/ 
        PercolationStats stats = new PercolationStats(n, trials);
        
        StdOut.printf("mean = %f\n", stats.mean());
        StdOut.printf("stddev = %f\n", stats.stddev());
        StdOut.printf("95%% confidence interval = %f, %f\n", stats.confidenceLo(), stats.confidenceHi()); 
    }
    
}
