package scripts;

import digraph.Digraph;

public class AcyclicTournaments {
	public static void main(String[] args) {
	
		for (int n = 0; n < 10; ++n) {
			Digraph acyclicTournament = new Digraph(n);
			for (int i = 0; i < n; ++i) {
				for (int j = i + 1; j < n; ++j) {
					acyclicTournament.addArc(i, j);
				}
			}
			acyclicTournament.pathCycleCovers().getCoverPolynomial().print();
		}
	}
}
