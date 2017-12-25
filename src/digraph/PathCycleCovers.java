package digraph;

import java.util.Arrays;

/**
 * A class for the array that contains the number of path-cycle covers of a digraph
 * for every given number of paths and cycles. Also used to compute the coefficients
 * of the cover polynomial. Two instances of this class are equal if and only if
 * the cover polynomials of the original graphs are equal.
 * Warning: ints used, may overflow for big digraphs (many edges)
 */
public class PathCycleCovers {
	
	private static final int[][] signedStirlingFirstKind = {
		{1},
		{0,1},
		{0,-1,1},
		{0,2,-3,1},
		{0,-6,11,-6,1},
		{0,24,-50,35,-10,1},
		{0,-120,274,-225,85,-15,1},
		{0,720,-1764,1624,-735,175,-21,1},
		{0,-5040,13068,-13132,6769,-1960,322,-28,1},
		{0,40320,-109584,118124,-67284,22449,-4536,546,-36,1}
	};
	
	private final int[][] coefs;

	public PathCycleCovers(int[][] coefs) {
		this.coefs = coefs;
	}
	
	public int[][] getCoefs() {
		return coefs;
	}

	public void print() {
		System.out.println("Path-cycle covers coefs:");
		int size = coefs.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(coefs[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public CoverPolynomial getCoverPolynomial() {
		int size = coefs.length;
		int[][] coverPolCoefs = new int[size][size];
		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				for (int k = i; k < size; ++k) {
					coverPolCoefs[i][j] += signedStirlingFirstKind[k][i]*coefs[k][j];
				}
			}
		}
		return new CoverPolynomial(coverPolCoefs);
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
