package scripts;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import digraph.Digraph;
import digraph.PathCycleCovers;
import generator.AcyclicDigraphGenerator;

public class DAGs {
	public static void main(String[] args) {
		
		Map<PathCycleCovers, Set<Digraph>> pccMap = new HashMap<>();
		try {
			AcyclicDigraphGenerator generator = new AcyclicDigraphGenerator(4);
			while (generator.hasNext()) {
				Digraph d = generator.next();
				PathCycleCovers pcc = d.pathCycleCovers();
				pccMap.computeIfAbsent(pcc, k -> new HashSet<>()).add(d);
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Log exceptions
			e.printStackTrace();
		}
		
		pccMap.forEach((k,v) -> {
			System.out.println("Quantitat: " + v.size());
			System.out.println("Representant: ");
			v.forEach(g -> {
				g.printAdjMatrix();
				System.out.println("----");
				
			});
			System.out.println();
		});
	}
}
