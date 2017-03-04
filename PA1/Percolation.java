import edu.princeton.cs.algs4.WeightedQuickUnionUF;
    
public class Percolation {
    
	/**
	Algorithms, Part 1
	Programming Assignment: Percolation
	This class represents a percolation model.
	The model uses an n-by-n grid of sites, where each site is eaither open or closed.
	A full site is defined to be a site that can be connected to the top row by a chain of
	open sites.
	The model percolates if there is a full site in the bottom row.
	**/

    // private int gridSize;
    private int len;
    private int openSites;
    private int[][] grid;
    private WeightedQuickUnionUF sets;
    private WeightedQuickUnionUF lset;
    
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        len = n;
        // gridSize = n*n;
        openSites = 0;
        grid = new int[n][n];
        int upper = n*(n-1);
        
        sets = new WeightedQuickUnionUF((n*n) + 2);
        lset = new WeightedQuickUnionUF((n*n) + 2);
        
        for (int i = 0; i < n; i++) {
            sets.union(n*n, i);
            lset.union(n*n, i);
            
            sets.union((n*n)+1, upper);
            upper++;
        }
        
        /** for (int i = n*(n-1); i <= (n*n)-1; i++) {
            sets.union((n*n)+1, i);
        } **/
    }
    
    public void open(int row, int col) {
        checkException(row, col);
        int p = toOneD(row, col);
        // System.out.println(p);
        row -= 1;
        col -= 1;
        int q;
        
        if (grid[row][col] != 1) {
            grid[row][col] = 1;
            openSites++;
            
            // arriba
            if (row - 1 >= 0) {
                if (grid[row - 1][col] == 1) {
                    q = toOneD((row+1) - 1, (col+1));
                    sets.union(p, q);
                    lset.union(p, q);
                }
            }
            
            // abajo
            if (row + 1 < len) {
                if (grid[row + 1][col] == 1) {
                    q = toOneD((row+1) + 1, (col+1));
                    sets.union(p, q);
                    lset.union(p, q);
                }
            }
            
            // derecha
            if (col + 1 < len) {
                if (grid[row][col + 1] == 1) {
                    q = toOneD((row+1), (col+1) + 1);
                    sets.union(p, q);
                    lset.union(p, q);
                }
            }
            
            // izquierda
            if (col - 1 >= 0) {
                if (grid[row][col - 1] == 1) {
                    q = toOneD((row+1), (col+1) - 1);
                    sets.union(p, q);
                    lset.union(p, q);
                } 
            }
                
            /** if (grid[row][col + 1] == 1) {
                q = toOneD(row, col + 1);
                sets.union(p, q);
            } else if (grid[row][col - 1] == 1) {
                q = toOneD(row, col - 1);
                sets.union(p, q);
            } else if (grid[row - 1][col] == 1) {
                q = toOneD(row - 1, col);
                sets.union(p, q);
            } else if (grid[row + 1][col] == 1) {
                q = toOneD(row + 1, col);
                sets.union(p, q);
            } **/
        }
    }
    
    private int toOneD(int row, int col) {
        int oneD = ((row - 1) * len) + (col - 1); 
        return oneD;
    }
    
    public boolean isOpen(int row, int col) {
        checkException(row, col);
        row -= 1;
        col -= 1;
        if (grid[row][col] == 1)
            return true;
        return false;
    }
    
    public boolean isFull(int row, int col) {
        checkException(row, col);
        if (grid[row - 1][col - 1] == 0) {
            return false;
        }
        int p = toOneD(row, col);
        return lset.connected(p, (len*len));
    }
    
    /** private int root(int row, int col) {
        int p = toOneD(row, col);
        //System.out.println(p);
        return sets.find(p);
    } **/
    
    public int numberOfOpenSites() {
        return openSites;
    }
    
    public boolean percolates() {
        if (len == 1 && grid[0][0] == 0)
            return false;
        return sets.connected((len*len), (len*len) + 1);
    }
    
    private void checkException(int row, int col) {
        if ((row < 1 || row > len) || (col < 1 || col > len)) {
            throw new IndexOutOfBoundsException();
        }
    }

    public static void main(String[] args) {
        /** Percolation test = new Percolation(1);
        test.open(1,1);
        System.out.println(test.isFull(1,1));
        System.out.println(test.percolates()); **/
        /** test.open(1, 4);
        test.open(1, 4);
        System.out.println(test.numberOfOpenSites()); **/
        /** test.open(3, 4);
        test.open(4, 4);
        // test.open(5, 4);
        // System.out.println(test.root(1, 4));
        // System.out.println(test.root(3, 4));
        System.out.println(test.isOpen(2, 4));
        System.out.println(test.isFull(3, 4));
        System.out.println(test.percolates());
        System.out.println(test.numberOfOpenSites()); **/
    }
    
}
     