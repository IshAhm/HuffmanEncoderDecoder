package main;

public class InternalHuffmanNode implements HuffmanNode {
	private HuffmanNode right;
	private HuffmanNode left;
	private int frequency;
	private boolean leaf = false;
	private int height;
	
	public InternalHuffmanNode(HuffmanNode right, HuffmanNode left) {
		this.right = right;
		this.left = left;
	}
	
	//new constructor to include height
	public InternalHuffmanNode(HuffmanNode right, HuffmanNode left, int height) {
		this.right = right;
		this.left = left;
		int max;
		if(right.height() > left.height())
			max = right.height();
		else
			max=left.height();
		this.height = max + 1;
	}
	
	@Override
	public int count() {
		if(!this.isLeaf()) {
			return (this.right.count() + this.left.count());
		} else {
			return this.frequency;
		}
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	@Override
	public int symbol() {
		if(!leaf) {
			throw new IllegalArgumentException("Nah, can't");
		} else { 
			return 0;
		}
	}

	@Override
	public int height() {
		/*
		int theHeight = 1;
		if(right.isLeaf() && left.isLeaf()) {
			return theHeight;
		} else if(right.isLeaf() && !left.isLeaf()) {
			theHeight = left.height() + theHeight;
		} else if(!right.isLeaf() && left.isLeaf()) {
			theHeight = right.height() + theHeight;
		} else if(!right.isLeaf() && !left.isLeaf()) {
			int greaterH;
			if(right.height() > left.height())
				greaterH = right.height();
			else 
				greaterH = left.height();
			theHeight = theHeight + greaterH;
		}
		return theHeight;
		*/
		return this.height;
	}

	@Override
	public boolean isFull() {
		 if( left == null || right == null) {
			return false;
		} else if(left.isFull() && right.isFull()) {
			return true;
		} 
		return false;
	}	

	@Override
	public boolean insertSymbol(int length, int symbol) {
		LeafHuffmanNode leaf = new LeafHuffmanNode();
		leaf.setSymbol(symbol);
		HuffmanNode child = new InternalHuffmanNode(null, null);
		if(length == 1) {
			if(this.left() == null) {
				this.setLeft(leaf);
				return true;
			}
			if(this.right() == null) {
				this.setRight(leaf);
				return true;
			}
		}
		if(left == null) {
			this.setLeft(child);
			length--;
			this.left().insertSymbol(length, symbol);
			
		} else if(!left.isFull()) {
			length--;
			this.left().insertSymbol(length, symbol);
		} else if(right == null) {
			this.setRight(child);
			length--;
			this.right().insertSymbol(length, symbol);
		} else if (!right.isFull()) {
			length--;
			this.right().insertSymbol(length, symbol);
		} else {
			return false;
		}
		return true;
	}

	@Override
	public HuffmanNode left() {
		return this.left;
	}
	
	//my methods
	public void setLeft(HuffmanNode leftChild) {
		this.left = leftChild ;
	}
	
	public void setRight(HuffmanNode rightChild) {
		this.right = rightChild ;
	}

	@Override
	public HuffmanNode right() {
		return this.right;
	}

	@Override
	public void printPostorder() {
	
		if(left().isLeaf()) {
			System.out.println(left().symbol() + " " + left().count());
			
		}
		if(right().isLeaf()) {
			System.out.println(right().symbol() + " " + right().count());
			
		}
		left().printPostorder();
		right().printPostorder();
	}

	

}
