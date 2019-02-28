package main;

public class LeafHuffmanNode implements HuffmanNode {
	private int frequency;
	private boolean leaf = true;
	private boolean full = true;
	private int symbol;
	private int height = 0;
	

	public void setSymbol(int sym) {
		symbol = sym;
	}
	
	@Override
	public int count() {
		return frequency;
	}

	@Override
	public boolean isLeaf() {
		return leaf;
	}

	@Override
	public int symbol() {
		return symbol;
	}

	@Override
	public int height() {
		return height;
	}

	@Override
	public boolean isFull() {
		return true;
	}

	@Override
	public boolean insertSymbol(int length, int symbol) {
		if(leaf) {
			throw new IllegalArgumentException("Nah, can't");
		} else { 
			return false;
		}
	}

	@Override
	public HuffmanNode left() {
		if(leaf) {
			throw new IllegalArgumentException("Nah, can't");
		} else { 
			return null;
		}
	}

	@Override
	public HuffmanNode right() {
		if(leaf) {
			throw new IllegalArgumentException("Nah, can't");
		} else { 
			return null;
		}
	}
	
	//methods I added
	@Override
	public void setLeft(HuffmanNode leftChild) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setRight(HuffmanNode rightChild) {
		// TODO Auto-generated method stub
		
	}

}
