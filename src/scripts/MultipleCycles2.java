package scripts;

import digraph.Digraph;

public class MultipleCycles2 {
	public static void main(String[] args) {
		int n = 1;
		Digraph d_1 = new Digraph(n);
		d_1.addArc(0, 0);
		d_1.pathCycleCovers().print();
		
	}
}
