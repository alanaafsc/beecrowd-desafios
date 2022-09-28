package br.com.ibm.codigos;

import java.io.IOException;

public class MaiorPalindromoTest {
	public static void main (String[] args) throws IOException {
		 int tamanhoMaxPalindromo = Integer.MIN_VALUE;

		 String numberString = "4334"; 
		 boolean palindromo = isPalindromo(numberString);
		 System.out.print(palindromo);
		 }
	
	private static boolean isPalindromo(String pedaco) {
		return pedaco.equals(new StringBuilder(pedaco).reverse().toString());
	}
}
