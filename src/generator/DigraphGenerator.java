package generator;

import java.util.BitSet;
import java.util.Iterator;

/**
 * @TODO by vertices, edges or reading from file?
 * Iterator to generate digraphs
 */
public class DigraphGenerator implements Iterator<BitSet> {

	private BitSet bitset = new BitSet();
	private boolean hasNext = true;
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return hasNext;
	}

	@Override
	public BitSet next() {
		BitSet nextBitSet = bitset;
		
		return nextBitSet;
	}

}
