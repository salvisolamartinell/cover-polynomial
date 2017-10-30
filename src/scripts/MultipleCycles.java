package scripts;

import digraph.Digraph;

public class MultipleCycles {
	public static void main(String[] args) {
		int n = 6;
		Digraph d_1 = new Digraph(n);
		d_1.addArc(0, 1);
		d_1.addArc(1, 2);
		d_1.addArc(2, 0);
		d_1.addArc(3, 4);
		d_1.addArc(4, 5);
		d_1.addArc(5, 3);
		
		d_1.print();

		System.out.println();
		
		Digraph d_2 = new Digraph(n);
		d_2.addArc(0, 1);
		d_2.addArc(1, 2);
		d_2.addArc(2, 3);
		d_2.addArc(3, 0);
		
		d_2.addArc(4, 5);
		d_2.addArc(5, 4);
		d_2.print();
		
		d_1.pathCycleCovers().print();
		System.out.println();
		d_2.pathCycleCovers().print();
	}
}
