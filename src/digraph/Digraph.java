package digraph;

import java.util.BitSet;

/**
 * Enumerated digraph
 */
public class Digraph {
	private final int n;
	BitSet adjMatrix;
	public Digraph (int n) {
		this.n = n;
		adjMatrix = new BitSet(n*n);
	}
	
	public Digraph (int n, BitSet adjMatrix) {
		this.n = n;
		this.adjMatrix = adjMatrix;
	}
	
	public void addArc(int u, int v) {
		if (u > n || v > n || u < 0 || v < 0) throw new IllegalArgumentException();
		adjMatrix.set(u*n + v);
	}
	
	public Digraph getCanonicIsomorphism() {
		int[] permutation = new int[n];
		for (int i = 0; i < n; ++i) permutation[i] = i;
		BitSet canonicAdjMatrix = adjMatrix;
		
		int[] c = new int[n];
		int k = 0;
		while (k < n) {
			if(c[k]<k) {
				if (k%2==0) {
					int aux = permutation[0];
					permutation[0] = permutation[k];
					permutation[k] = aux;
				} else {
					int aux = permutation[c[k]];
					permutation[c[k]] = permutation[k];
					permutation[k] = aux;
				}
				BitSet permutatedAdjMatrix = new BitSet(n*n);
				for (int i = 0; i < n; ++i) {
					for (int j = 0; j < n; ++j) {
						if (adjMatrix.get(i*n+j)) permutatedAdjMatrix.set(permutation[i]*n+permutation[j]);
					}
				}
				if(permutatedAdjMatrix.toString().compareTo(canonicAdjMatrix.toString())>0) {
					canonicAdjMatrix = permutatedAdjMatrix;
				}
	            ++c[k];
	            k = 0;
			} else {
				c[k] = 0;
				++k;
			}
		}
		return new Digraph(n, canonicAdjMatrix);
	}
	
	public int[][] pathCycleCovers() {
		int[][] coefs = new int[n+1][n+1];
		if (adjMatrix.isEmpty()) {
			coefs[n][0] = 1;
		} else {
			int arc = adjMatrix.previousSetBit(n*n - 1);
			int u = arc/n;
			int v = arc%n;
			int[][] delCoefs = deletion(u,v).pathCycleCovers();
			int[][] conCoefs = contraction(u,v).pathCycleCovers();
			for (int i = 0; i <= n; ++i) {
				for (int j = 0; j <= n; j++) {
					coefs[i][j] += delCoefs[i][j];
					if (i<n && j < n) {
						if (u != v && i < n) {
							if (j < n) coefs[i][j] += conCoefs[i][j];
						} else {
							if (j > 0) coefs[i][j] += conCoefs[i][j-1];
						}
					}
				}
			}
			
		}
		return coefs;
	}

	private Digraph deletion(int u, int v) {
		BitSet delAdjMatrix = (BitSet) adjMatrix.clone();
		delAdjMatrix.clear(u*n + v);
		Digraph d_del = new Digraph(n, delAdjMatrix);
		return d_del;
	}
	
	public Digraph contraction(int u, int v) {
		BitSet conAdjMatrix = new BitSet((n-1)*(n-1));
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i == u || j == v);
				else  {
					if (adjMatrix.get(i*n + j)) conAdjMatrix.set(newVertex(u,v,i)*(n-1) + newVertex(u,v,j));
				}
			}
		}
		Digraph d_con = new Digraph(n-1, conAdjMatrix);
		return d_con;
	}
	
	private static int newVertex(int u, int v, int i) {
		if (i < v) return i;
		if (i > v) return i - 1;
		if (u < v) return u;
		if (u > v) return u - 1;
		throw new RuntimeException();
	}
	
	public void print() {
		System.out.println("digraph D {");
		for (int i = 0; i < n; ++i) {
			System.out.println(" "+'"'+i+'"');
			for (int j = 0; j < n; ++j) {
				if (adjMatrix.get(i*n + j)) System.out.println(" "+'"'+i+'"'+" -> "+'"'+j+'"');
			}
		}
		System.out.println("}");
	}
}
