package digraph;

import java.util.Arrays;

/**
 * A wrapper class for the array that contains the number of path-cycle covers of a digraph
 * for every given number of paths and cycles. Two instances of this class are equal
 * if and only if the cover polynomials of the original graphs are equal.
 */
public class PathCycleCovers {
	private final int[][] coefs;

	public PathCycleCovers(int[][] coefs) {
		this.coefs = coefs;
	}
	
	public int[][] getCoefs() {
		return coefs;
	}

	public void print() {
		int n = coefs.length;
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(coefs[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(coefs);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PathCycleCovers other = (PathCycleCovers) obj;
		if (!Arrays.deepEquals(coefs, other.coefs))
			return false;
		return true;
	}
}
