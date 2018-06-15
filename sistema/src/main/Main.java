package main;


import conexao.Conexao;

public class Main {

	public static void main(String[] args) {
		Conexao.getInstance(); //pede os dados da conexao antes de rodar
		System.out.println("Conexao estabelecida");
	}
}