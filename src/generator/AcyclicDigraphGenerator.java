package generator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.BitSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

import digraph.Digraph;

/**
 * Iterator to generate acyclic digraphs for a given number of vertices
 * reading from txt files such as the ones that can be found in the Acyclic graphs section at
 * <a href="http://users.cecs.anu.edu.au/~bdm/data/digraphs.html" target="_parent">http://users.cecs.anu.edu.au/~bdm/data/digraphs.html</a>.
 * Create such files in the resources folder of this project for this iterator to work.
 */
public class AcyclicDigraphGenerator implements Iterator<Digraph> {

	private final int n;
    private final BufferedReader in;
	private String nextLine;
	private boolean nextLinePrepared = false;
	
	public AcyclicDigraphGenerator(int n) throws FileNotFoundException {
		this.n = n;
		in = new BufferedReader(new FileReader("resources\\dag"+n+".txt"));
	}

	@Override
	public boolean hasNext() {
		prepareNextLine();
		return nextLine != null;
	}

	@Override
	public Digraph next() {
		prepareNextLine();
		if (nextLine == null) throw new NoSuchElementException();
		BitSet adjMatrix = new BitSet(n*n);
		int k = 0;
		for (int i = 0; i < n-1; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (nextLine.charAt(k) == '1') adjMatrix.set(i*n+j);
				++k;
			}
		}
		nextLinePrepared = false;
		return new Digraph(n, adjMatrix);
	}
	
	private void prepareNextLine() {
		if (!nextLinePrepared) {
			try {
				nextLine = in.readLine();
			} catch (IOException e) {
				nextLine = null;
				// TODO Log exceptions
				e.printStackTrace();
			} finally {
				nextLinePrepared = true;
			}
		}
	}

}
