package scripts;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import digraph.Digraph;
import digraph.PathCycleCovers;
import generator.AcyclicDigraphGenerator;

public class DAGs {
	public static void main(String[] args) {
		
		Map<PathCycleCovers, Set<Digraph>> pccMap = new HashMap<>();
		try {
			AcyclicDigraphGenerator generator = new AcyclicDigraphGenerator(5);
			while (generator.hasNext()) {
				Digraph d = generator.next();
				PathCycleCovers pcc = d.pathCycleCovers();
				pccMap.computeIfAbsent(pcc, k -> new HashSet<>()).add(d);
			}
		} catch (FileNotFoundException e) {
			// TODO Log exceptions
			e.printStackTrace();
		}
		
		Map<Integer, Integer> groupSizes = new TreeMap<>();
		
		pccMap.forEach((k,v) -> {
			groupSizes.putIfAbsent(v.size(), 0);
			groupSizes.put(v.size(), groupSizes.get(v.size()) + 1);
//			System.out.println("Quantitat: " + v.size());
//			v.forEach(g -> {
//				g.printAdjMatrix();
//				System.out.println("----");
//				
//				//g.print();
//				
//			});
//			System.out.println();
		});
		System.out.println("Resum:");
		groupSizes.forEach((k,v) -> {
			System.out.println(""+k+":\t"+v);
		});
	}
}
