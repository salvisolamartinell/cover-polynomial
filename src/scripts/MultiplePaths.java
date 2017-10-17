package scripts;

import digraph.Digraph;

public class MultiplePaths {
	public static void main(String[] args) {
		int n = 6;
		Digraph d_1 = new Digraph(n);
		d_1.addArc(0, 1);
		d_1.addArc(1, 2);
		d_1.addArc(2, 3);
		d_1.addArc(3, 4);
		d_1.addArc(4, 0);
		
		d_1.addArc(5, 5);
		
		d_1.print();

		System.out.println();
		
		Digraph d_2 = new Digraph(n);
		d_2.addArc(0, 1);
		d_2.addArc(1, 2);
		d_2.addArc(2, 0);
		
		d_2.addArc(3, 4);
		d_2.addArc(4, 5);
		d_2.addArc(5, 3);
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
