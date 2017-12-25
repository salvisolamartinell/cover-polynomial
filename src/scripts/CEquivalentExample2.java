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
		d_2.addArc(1, 4);
		d_2.print();
		
		d_1.pathCycleCovers().print();
		System.out.println();
		d_2.pathCycleCovers().print();
	}
}
