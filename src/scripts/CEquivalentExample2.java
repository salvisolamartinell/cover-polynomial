package scripts;

import digraph.Digraph;

/**
 * Provides an example of 2 digraphs, not obtained by inverting the edges, that are C-equivalent
 */
public class CEquivalentExample2 {
	public static void main(String[] args) {
		int n = 5;
		Digraph d_1 = new Digraph(n);
		for (int i = 0; i < n-1; ++i) d_1.addArc(i, i+1);
		d_1.addArc(0, 2);
		d_1.print();

		System.out.println();
		
		Digraph d_2 = new Digraph(n);
		for (int i = 0; i < n-1; ++i) d_2.addArc(i, i+1);
		d_2.addArc(1, 3);
		d_2.print();
		
		int[][] pcc1 = d_1.pathCycleCovers();
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(pcc1[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
		
		int[][] pcc2 = d_2.pathCycleCovers();
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(pcc2[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
