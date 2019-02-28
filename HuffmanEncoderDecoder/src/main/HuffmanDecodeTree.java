package main;

import java.io.IOException;
import java.util.List;

import io.InputStreamBitSource;
import io.InsufficientBitsLeftException;

public class HuffmanDecodeTree {

	private HuffmanNode _root;
	
	public HuffmanDecodeTree(List<SymbolWithCodeLength> symbols_with_code_lengths) {

		// Create empty internal root node.
		
		_root = new InternalHuffmanNode(null, null);
		
		// Insert each symbol from list into tree
		for(int i = 0; i < symbols_with_code_lengths.size(); i++){
			SymbolWithCodeLength mem = symbols_with_code_lengths.get(i);
			_root.insertSymbol(mem.codeLength(), mem.value());
		}
		
		// If all went well, your tree should be full
		
		assert _root.isFull();
	}

	public int decode(InputStreamBitSource bit_source) throws IOException, InsufficientBitsLeftException {
		
		// Start at the root
		HuffmanNode n = _root;
		
		while (!n.isLeaf()) {
			// Get next bit and walk either left or right,
			// updating n to be as appropriate
			int nextbit = bit_source.next(1);
			if(nextbit == 0) {
				n = n.left();
			} else {
				n = n.right();
			}
		}
		
		// Return symbol at leaf
		return n.symbol();
	}

}
