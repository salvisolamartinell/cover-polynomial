package scripts;

import java.io.FileNotFoundException;

import digraph.Digraph;
import generator.AcyclicDigraphGenerator;

public class DAGs {
	public static void main(String[] args) {
		try {
			AcyclicDigraphGenerator generator = new AcyclicDigraphGenerator(3);
			while (generator.hasNext()) {
				Digraph d = generator.next();
				d.printAdjMatrix();
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Log exceptions
			e.printStackTrace();
		}
		
	}
}
