package digraph;

import java.util.Arrays;

public class CoverPolynomial {

	private final int[][] coefs;
	
	public CoverPolynomial(int[][] coefs) {
		this.coefs = coefs;
	}
	
	public void print() {
		System.out.print("Cover polynomial coefs:");
		int size = coefs.length;
		for (int i = 0; i <= size; i++) {
			for (int j = 0; j <= size; j++) {
				System.out.print(coefs[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 37;
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
		CoverPolynomial other = (CoverPolynomial) obj;
		if (!Arrays.deepEquals(coefs, other.coefs))
			return false;
		return true;
	}
}
