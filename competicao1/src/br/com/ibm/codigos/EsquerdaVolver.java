package br.com.ibm.codigos;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class EsquerdaVolver {
 
	public static void main(String[] args) throws IOException {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String sc;
			int aux = 0;
	    	char result = 0;
	    	int start = 1;
	    	int count; 
			while ((sc = br.readLine()) != null) {
				int contadorComandos = Integer.parseInt(sc);
				if (contadorComandos == 0) {
					return;
				}
				count = contadorComandos;

				String command = br.readLine();
				
			    while(count>0) {

					if(start == 1 || result == 'N') {
						if(command.charAt(aux) == 'E') {
							result = 'O';
						}
						else {
							result = 'L';
							}
						aux++;
						start--;
					}else if(result == 'O'){
						if(command.charAt(aux) == 'E') {
							result = 'S';
						}
						else {
							result = 'N';
							}
							aux++;
						
					}else if(result == 'L') {
						if(command.charAt(aux) == 'E') {
							result = 'N';
						}
						else {
							result = 'S';
						}
						aux++;
					}else{
						if(command.charAt(aux) == 'E') {
							result = 'L';
						}
						else {
							result = 'O';
						}
						aux++;
					}	
					count--;
					start--;
					
			    }	

		        System.out.println(result);
		        aux = 0;
		    	result = 0;
		    	start = 1;
		    	
			}	
		}	
	}
}
