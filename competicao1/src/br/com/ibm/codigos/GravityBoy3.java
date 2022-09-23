package br.com.ibm.codigos;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class GravityBoy3 {
 
	public static void main (String[] args) throws IOException {
		   try(Scanner br = new Scanner(System.in)){
			   int objetivo = 0;
			   int N = br.nextInt();
			   long[] relevoTeto = new long [N];
			   long[] relevoChao = new long [N];
			   for(int h = 0; h<N;h++) {
				   relevoTeto[h] = br.nextLong();
				   System.out.printf("");
				   
			   }
			   for(int h = 0; h<N;h++) {
				   relevoChao[h] = br.nextLong();
				   System.out.printf("");
				   
			   }

			  
			 while (objetivo != N) {
				 if(N == 0 || N==1) {
					 return;
				 }
				 if(relevoTeto == null || relevoChao == null) {
					 return;
				 }
				 int chao = 0; 
				 int teto = 0;
				 int possib = 2; // teto e chao
				 
				 if(relevoChao[0] != 0 && relevoTeto[0] == 0) {
					 chao = 1;
					 possib = 1;}
				 else if(relevoTeto[0] != 0 && relevoChao[0] == 0){
					 teto = 1;
					 possib = 1;
				 }		
				 int j = 0;
				 int local = 0;
				 long[][] relevo = new long[2][N];
				
				 for(int l1 =0; l1<N; l1++) {
					 relevo[0][l1] = relevoTeto[l1];
					 relevo[1][l1] = relevoChao[l1];
				 }			 
				 int mudancasGravidadeResult;
				 if(possib == 2) {
					int mudancasGravidade1 = mudancasGravidade(relevo, j, N, local, 1, 0, possib);
					int mudancasGravidade2= mudancasGravidade(relevo, j, N, local, 0, 1, possib);
					if (mudancasGravidade1<mudancasGravidade2) {
						mudancasGravidadeResult = mudancasGravidade1;
					}else {
						mudancasGravidadeResult = mudancasGravidade2;
					}
				 } 
				 else {
					 mudancasGravidadeResult = mudancasGravidade(relevo, j, N, local, teto, chao, possib);
				 }		 
			objetivo = N; 
			if(objetivo == N) {
				System.out.println(mudancasGravidadeResult);
				
			}
			 }	 
		   }
		}


		public static int mudancasGravidade(long[][] relevo, int j, int N, int local, int teto, int chao, int possib) {
			int mudancasGravidade = 0; 

			while(local != N-2){
				 
				 while(teto == 0 && local != N-2 && j<N) {
					 if(relevo[1][j]==relevo[1][j+1]) {
						 local = j;
						 if(j<N-1) {
						 j++; }
						 else {
							 break;
						 }
						 }
					 else if(relevo[1][j] > relevo[1][j+1] && relevo[1][j+1] != 0) {
						 local = j;
						 if(j<N-1) {
							 j++; }
							 else {
								 break;
							 }
					 
					 }else if(relevo[1][j] < relevo[1][j+1] || relevo[1][j+1] == 0){
						 mudancasGravidade++;
						 chao = 0;
						 teto = 1;
						 local = j;
						 if(local == N-2) {
							 return mudancasGravidade;
						 }
						 break;
				 }
				 }
				 while(chao == 0 && local != N-2 && j<N) {
					 if(relevo[0][j]==relevo[0][j+1]) {
						 local = j;
						 if(j<N-2) {
							 j++; }
							 else {
								 break;
							 }
					}
					 else if(relevo[0][j] > relevo[0][j+1] && relevo[0][j+1] != 0) {
						 local = j;
						 if(j<N-1) {
							 j++; }
							 else {
								 break;
							 }
					 
					 }else if(relevo[0][j] < relevo[0][j+1] || relevo[0][j+1] == 0){
						 mudancasGravidade++;
						 chao = 1;
						 teto = 0;
						 local = j;
						 if(local == N-2) {
							 return mudancasGravidade;
						 }
						 break;
					 }
					 
				 }
				   
		 }
			return mudancasGravidade;
		}
	}

