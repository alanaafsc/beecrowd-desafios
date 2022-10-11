package br.com.ibm.codigos;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.math.*;

/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class JogoDePalavras {
    public static void main (String[] args) throws IOException {
     int conta = 1;
    try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
      String casoGeral;
      String stop = "*";
      while ((casoGeral = br.readLine()) != stop) {
        if (casoGeral == null || casoGeral.charAt(0) == '*') {
          return;
        }
        //armazenar strings possiveis:
        Vector<String> stringsPossiveis = new Vector<>();
        int possibilidades = casoGeral.length(); //qntd de strings possiveis
        while(possibilidades > 0) {
            int end = 1;
            String fim = casoGeral.substring(0,end);
            String novoInicio = casoGeral.substring(end);
            String newString = novoInicio + fim;
            if(stringsPossiveis.contains(newString)) {
              break;
            }else {
              stringsPossiveis.add(newString);
              casoGeral = newString;
            }
          possibilidades--;
        }
        // Cria o array
        int tamanhoArray = casoGeral.length();
        String[] arrayNomes = new String[tamanhoArray];
        // copia os elementos do Vector para o array
        stringsPossiveis.copyInto(arrayNomes);
        
        String maior;
        String menor;
        String auxMaior;
        String auxMenor;
        
        if(tamanhoArray == 2) {
        	maior = arrayNomes[0];
        	menor = arrayNomes[1];
            auxMaior = maior;
            auxMenor = menor;
        	if(maior.compareTo(menor)>0) {
        		maior = auxMaior;
        		menor = auxMenor;
        	}else {
        		maior = auxMenor;
        		menor = auxMaior;
        		
        	}
        }else {
        	maior = arrayNomes[0];
        	menor = arrayNomes[tamanhoArray-1];
	        for(int i = 0; i<tamanhoArray; i++) {
	          for(int j = 0; j<tamanhoArray; j++) {
	          String compararString1 = arrayNomes[i];
	          String compararString2 = arrayNomes[j];
	          if(compararString1.compareTo(compararString2) > 0) {
	            if(compararString1.compareTo(maior) > 0) {
	            	maior = compararString1; }
	            if(compararString2.compareTo(menor) <0) {
	            	menor = compararString2;
	            }
	            
	          }else if(compararString1.compareTo(compararString2) < 0){
	            if(menor.compareTo(compararString1) > 0) {
	            	menor = compararString1;
	            	if(compararString2.compareTo(maior) > 0) {
	            		maior = compararString2;
	            	}
	            }
	            
	          }
	        }
	        } }
        //casos:
        System.out.printf("Caso %d: %s %s%n", conta, menor, maior);
        conta++;
      }
  }
}
}
