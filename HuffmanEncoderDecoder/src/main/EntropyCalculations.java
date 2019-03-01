package main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

import io.InputStreamBitSource;
import io.InsufficientBitsLeftException;

public class EntropyCalculations {
	public static void main(String[] args) throws InsufficientBitsLeftException, IOException {
		String input_file_name = "data/uncompressed.txt";
		String input_file_name2 = "data/compressed.dat";
		String input_file_name3 = "data/uncompressed.txt";
		
		FileInputStream fis = new FileInputStream(input_file_name);
		FileInputStream fis2 = new FileInputStream(input_file_name2);
		FileInputStream fis3 = new FileInputStream(input_file_name3);
		
		double[] symbol_counts = new double[256];
		int num_symbols = 0;
		int c;
		while((c = fis.read()) != -1) {
			symbol_counts[c]++;
			num_symbols++;
		}
		fis.close();
		//theoretical entropy of text file
		//we add a very small number in order to avoid NaN, since log(0) is undefined. These numbers are so small
		//tey're essentially zero
		for(int i = 0; i<256; i++) {
			symbol_counts[i] = symbol_counts[i]/num_symbols;
			symbol_counts[i] = symbol_counts[i] + .00000000000000001;
		}
		double theoEntropy = 0;
		for(int i =0; i<256; i++) {
			theoEntropy = theoEntropy + (-1)*(symbol_counts[i])*(log(symbol_counts[i])/log(2));
		}
		System.out.println("Theoretical Entropy of Raw Text File: " + theoEntropy);
		
		//compressed entropy achieved by compressed.dat
		List<SymbolWithCodeLength> symbols_with_length = new ArrayList<SymbolWithCodeLength>();
		InputStreamBitSource bit_source = new InputStreamBitSource(fis2);

		for(int i= 0; i < 256; i++) {
			int code_length = bit_source.next(8);
			symbols_with_length.add(new SymbolWithCodeLength(i, code_length));
			
		}
		double compEntropy = 0;
		for(int i =0; i <256; i++) {
			compEntropy = compEntropy + symbol_counts[i]*(symbols_with_length.get(i).codeLength());
		}
		System.out.println("Compressed Entropy of provided compressed file: " + compEntropy);
		
		//compressed entropy achieved by my encoder of the raw text file
		int[] symCounts = new int[256];
		int numSymbols = 0;
		
		int d;
		while((d = fis3.read()) != -1) {
			symCounts[d]++;
			numSymbols++;
		}
		fis3.close();
		int[] symbols = new int[256];
		for (int i=0; i<256; i++) {
			symbols[i] = i;
		}
		
		
		HuffmanEncoder encoder = new HuffmanEncoder(symbols, symCounts);
		
		double myCompEntropy = 0;
		for(int i = 0; i<256; i++) {
			myCompEntropy = myCompEntropy + symbol_counts[i]*(encoder.getCode(i).length());
		}
		System.out.println("Compressed Entropy of my compressed file: " + myCompEntropy);
	}	
	
	
}
