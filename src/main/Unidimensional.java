package main;

import digraph.Digraph;

public class Unidimensional {
	public static void main(String[] args) {
		int n = 4;
		Digraph d_1 = new Digraph(n);
		d_1.addArc(0, 1);
		d_1.addArc(1, 2);
		d_1.print();

		System.out.println();
		
		Digraph d_2 = new Digraph(n);
		d_2.addArc(0, 1);
		d_2.addArc(3, 2);
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
