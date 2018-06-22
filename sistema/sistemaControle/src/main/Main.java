package main;

import back.*;
import conexao.Conexao;


public class Main {

	public static void main(String[] args) {
		Conexao.getInstance(); //pede os dados da conexao antes de rodar
		
	/*	CADASTRO DE PRODUTO	
	 * 
	 * String[] produto = new String[3];
		produto[0] = "HD";
		produto[1] = "HD SAMSUNG 3G";
		produto[2] = "50";
		
		Produto.cadastro(produto);*/
		
	/*	CADASTRO DE USUARIO	*/
		/*
	 	String[] usuario = new String[5];
		usuario[0] = "462.078.148-11";
		usuario[1] = "46.040.675-9";
		usuario[2] = "Matheus Sanchez";
		usuario[3] = "matheus.sanchez@usp.br";
		usuario[4] = "tantufaz";
		
		Usuario.cadastro(usuario);*/
		
		/*	CADASTRO DE USUARIO COM TIPO*/
		 
	/*	
		String[] usuario = new String[5];
		usuario[0] = "123.078.148-11";
		usuario[1] = "46.040.675-9";
		usuario[2] = "Matheus Sanchez";
		usuario[3] = "matheus.sanchez@usp.br";
		usuario[4] = "tantufaz";
		
		Usuario.cadastro(usuario,"A");*/

		
		/*CADASTRO DE REPOSICAO*/
		/*
		String[] reposicao = new String[5];
		reposicao[0] = "3";
		reposicao[1] = "220,50";
		reposicao[2] = "250,75";
		reposicao[3] = "40";
		reposicao[4] = "16/06/2018";
		
		Reposicao.cadastro(reposicao);
		*/	
		
		
		String[] usuario = new String[5];
		usuario[0] = "123.123.148-11";
		usuario[1] = "46.050.675-9";
		usuario[2] = "Pedro Sanchez";
		usuario[3] = "mateus.sanchekz@usp.br";
		usuario[4] = "oi";
		
		
		Usuario.cadastro(usuario,"O");
		//Usuario.cadastro(usuario);
	
		
		//Usuario.cadastro(usuario,"A");
	}
}