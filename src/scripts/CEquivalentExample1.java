package scripts;

import digraph.Digraph;

/**
 * Provides an example of 2 digraphs, obtained by inverting the edges, that are C-equivalent
 */
public class CEquivalentExample1 {
	public static void main(String[] args) {
		int n = 3;
		Digraph d_1 = new Digraph(n);
		d_1.addArc(0, 1);
		d_1.addArc(2, 1);
		d_1.print();

		System.out.println();
		
		Digraph d_2 = new Digraph(n);
		d_2.addArc(1, 0);
		d_2.addArc(1, 2);
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
