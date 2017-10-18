package scripts;

import digraph.Digraph;

public class MultipleCycles2 {
	public static void main(String[] args) {
		int n = 1;
		Digraph d_1 = new Digraph(n);
		d_1.addArc(0, 0);
		printCovers(d_1.pathCycleCovers(),1);
		
	}
	
	private static void printCovers(int[][] cpcovers, int n) {
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(cpcovers[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
