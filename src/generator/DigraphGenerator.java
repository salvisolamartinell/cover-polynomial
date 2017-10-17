package generator;

import java.util.Iterator;

public class DigraphGenerator implements Iterator<Long> {

	private final int dimension;
	private long bitmap = 0L;
	private int pos = 0;
	private boolean hasNext = true;
	
	public DigraphGenerator(int dimension) {
		super();
		this.dimension = dimension;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long next() {
		Long nextBitmap = bitmap;
		
		return nextBitmap;
	}

}
