package main;

import digraph.Digraph;

public class Main {
	public static void main(String[] args) {
		int n = 5;
		Digraph d_1 = new Digraph(n);
		for (int i = 0; i < n-1; ++i) d_1.addArc(i, i+1);
		d_1.addArc(0, 2);
		d_1.addArc(2, 4);
		d_1.print();

		System.out.println();
		
		Digraph d_2 = new Digraph(n);
		for (int i = 0; i < n-1; ++i) d_2.addArc(i, i+1);
		d_2.addArc(0, 2);
		d_2.addArc(2, 4);
		d_2.addArc(3, 3);
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
	
	public static void mainu(String[] args) {
		int n = 3;
		Digraph d = new Digraph(n);
		d.addArc(0, 1);
		d.addArc(1, 2);
		d.addArc(1, 1);
		d.print();
		Digraph d_2 = d.contraction(1, 1);
		d_2.print();
//		int[][] pcc = d.pathCycleCovers();
//		for (int i = 0; i <= n; i++) {
//			for (int j = 0; j <= n; j++) {
//				System.out.print(pcc[i][j] + "\t");
//			}
//			System.out.println();
//		}
//		d.contraction(1, 2).print();
	}
}
