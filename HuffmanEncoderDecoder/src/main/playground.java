package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import io.InputStreamBitSource;
import io.InsufficientBitsLeftException;


public class playground {
	
	public static void main(String[] args) throws InsufficientBitsLeftException, IOException {
		/*
		String input_file_name = "data/compressed.dat";
		
		FileInputStream fis = new FileInputStream(input_file_name);

		InputStreamBitSource bit_source = new InputStreamBitSource(fis);

		List<SymbolWithCodeLength> symbols_with_length = new ArrayList<SymbolWithCodeLength>();
		

		for(int i= 0; i < 256; i++) {
			int code_length = bit_source.next(8);
			symbols_with_length.add(new SymbolWithCodeLength(i, code_length));
			
		}
		Collections.sort(symbols_with_length);
		for(int i = 0; i< 256; i++) {
			SymbolWithCodeLength yeet = symbols_with_length.get(i);
			System.out.println(yeet.value());
			System.out.println(yeet.codeLength());
		}
		*/
		/*
		LeafHuffmanNode test1 = new LeafHuffmanNode();
		test1.setSymbol(3);
		LeafHuffmanNode test2 = new LeafHuffmanNode();
		InternalHuffmanNode yeet = new InternalHuffmanNode(test1, test2);
		LeafHuffmanNode test3 = new LeafHuffmanNode();
		LeafHuffmanNode test4 = new LeafHuffmanNode();
		InternalHuffmanNode yite = new InternalHuffmanNode(test3, test4);
		InternalHuffmanNode yote = new InternalHuffmanNode(yite, yeet);
		System.out.println(yote.isFull());
		*/
		HuffmanNode root = new InternalHuffmanNode(null,null);
		root.insertSymbol(2, 5);
		root.insertSymbol(2, 6);
		root.insertSymbol(3, 0);
		root.insertSymbol(3, 10);
		System.out.println(root.left().left().symbol());
		System.out.println(root.left().right().symbol());
		System.out.println(root.right().left().left().symbol());
		System.out.println(root.right().left().right().symbol());
		
	}
}