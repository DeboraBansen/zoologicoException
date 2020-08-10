package principal;

import java.util.Scanner;

import Exception.EspacoIndisponivelException;
import dados.*;
import negocio.*;

public class Interface {
	public static Zoologico zoologico=new Zoologico();
	public static Scanner s=new Scanner(System.in);
	public static String nome=new String();
	
	public static void  main(String [] args) {
		int op=-1;
		
		while(op!=0) {
			op=menu();
			switch (op) {
				case 0: 
					break;
				case 1:
					cadastrarViveiro();
					break;
				case 2:
					cadastrarAnimal();
					break;
				case 3:
					mostrarViveiros();
					break;
				case 4:
					mostrarAnimais();
					break;
				case 5:
					alocarAnimal();
					break;
				default:
					break;
			}
		}
		
	}
	
	public static int menu() {
		System.out.println("Escolha uma das opçoes abaixo:");
		System.out.println("0 - Sair");
		System.out.println("1 - Cadastrar Viveiro");
		System.out.println("2 - Cadastrar Animal");
		System.out.println("3 - Mostrar Viveiros");
		System.out.println("4 - Mostrar Animais");
		System.out.println("5 - Alocar Animal");
		int op=s.nextInt();
		
		return op;
	}
	
	
	public static void cadastrarViveiro() {
		Viveiro viveiro=new Viveiro();
		
		System.out.println("Cadastrar aquario?\n1 -SIM\n0-Nao");
		int n=s.nextInt();
		if(n==1) {
			Aquario aquario=new Aquario();
			
			System.out.println("Qual a altura do aquario?");
			aquario.setAltura(s.nextFloat());
			
			System.out.println("Qual a temperatura do aquario?");
			aquario.setTemperatura(s.nextFloat());
			
			System.out.println("Qual o nome do aquario?");
			aquario.setNome(s.next());
			
			nome=s.nextLine();
			
			System.out.println("Qual o comprimento do aquario?");
			aquario.setComprimento(s.nextFloat());
			
			System.out.println("Qual a largura do aquario?");
			aquario.setLargura(s.nextFloat());
			
			zoologico.cadastrarViveiro(aquario);
			
		}else {
			System.out.println("Qual o nome do viveiro?");
			viveiro.setNome(s.next());
			
			nome=s.nextLine();
			
			System.out.println("Qual o comprimento do viveiro?");
			viveiro.setComprimento(s.nextFloat());
			
			System.out.println("Qual a largura do viveiro?");
			viveiro.setLargura(s.nextFloat());
			
			zoologico.cadastrarViveiro(viveiro);
		}
	}
	
	public static void cadastrarAnimal() {
		Animal animal=new Animal();
		
		System.out.println("Cadastrar peixe?\n1 -SIM\n0-Nao");
		int n=s.nextInt();
		if(n==1) {
			Peixe peixe=new Peixe();
			
			System.out.println("Qual a temperatura ideal?");
			peixe.setTemperaturaIdeal(s.nextFloat());
			
			System.out.println("Qual o nome ?");
			peixe.setNome(s.next());
			nome=s.nextLine();
			
			System.out.println("Qual a cor ?");
			peixe.setCor(s.next());
			nome=s.nextLine();
			
			System.out.println("Qual a especie ?");
			peixe.setEspecie(s.next());
			nome=s.nextLine();
			
			System.out.println("Qual a idade ?");
			peixe.setIdade(s.nextInt());
			
			System.out.println("Qual a largura ?");
			peixe.setLargura(s.nextFloat());
			
			System.out.println("Qual o comprimento?");
			peixe.setComprimento(s.nextFloat());
			
			System.out.println("Qual a altura?");
			peixe.setAltura(s.nextFloat());
			
			zoologico.cadastrarAnimais(peixe);;
			
		}else {
			System.out.println("Qual o nome ?");
			animal.setNome(s.next());
			nome=s.nextLine();
			
			System.out.println("Qual a cor ?");
			animal.setCor(s.next());
			nome=s.nextLine();
			
			System.out.println("Qual a especie ?");
			animal.setEspecie(s.next());
			nome=s.nextLine();
			
			System.out.println("Qual a idade ?");
			animal.setIdade(s.nextInt());
			
			System.out.println("Qual a largura ?");
			animal.setLargura(s.nextFloat());
			
			System.out.println("Qual o comprimento?");
			animal.setComprimento(s.nextFloat());
			
			System.out.println("Qual a altura?");
			animal.setAltura(s.nextFloat());
			
			zoologico.cadastrarAnimais(animal);
		}
	}
	
	public static void mostrarViveiros() {
		zoologico.mostrarViveiros();
	}
	
	public static void mostrarAnimais() {
		zoologico.mostrarAnimais();
	}

	public static void alocarAnimal() {
		System.out.println("Escolha o numero do animal que deseja alocar :\n ");
		mostrarAnimais();
		int a=s.nextInt();
		
		System.out.println("Escolha o numero do viveiro em que deseja alocar o animal:\n");
		mostrarViveiros();
		int b=s.nextInt();
		
		try {
			zoologico.alocarAnimal(zoologico.getAnimais(a),zoologico.getViveiros(b));
		} catch (EspacoIndisponivelException e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	
	
	
	
	
}
