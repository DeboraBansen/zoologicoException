package negocio;
import Exception.EspacoIndisponivelException;
import  dados.*;

public class Zoologico {
	private Animal [] animais=new Animal[100];
	private int quantAnimais=0;
	private Viveiro [] viveiros=new Viveiro[30];
	private int quantViveiros=0;
	
	public Zoologico() {
		
	}
	
	public Animal getAnimais(int n) {
		return animais[n];
	}

	public void setAnimais(Animal[] animais) {
		this.animais = animais;
	}

	public Viveiro getViveiros(int n) {
		return viveiros[n];
	}

	public void setViveiros(Viveiro[] viveiros) {
		this.viveiros = viveiros;
	}

	public int getQuantAnimais() {
		return quantAnimais;
	}

	public void setQuantAnimais(int quantAnimais) {
		this.quantAnimais = quantAnimais;
	}

	public int getQuantViveiros() {
		return quantViveiros;
	}

	public void setQuantViveiros(int quantViveiros) {
		this.quantViveiros = quantViveiros;
	}


	public void cadastrarViveiro(Viveiro viveiro) {
		if(quantViveiros<30) {
			this.viveiros[quantViveiros]=viveiro;
			quantViveiros++;
			}
	}
	
	public void cadastrarAnimais(Animal animal) {
		if(quantAnimais<100) {
			this.animais[quantAnimais] = animal;
			quantAnimais++;
			}
	}
	
	public void mostrarViveiros() {
		for(int i=0;i<quantViveiros;i++) {
			System.out.println("\t viveiro "+i+": " +viveiros[i].getNome());
		}
	}
	
	public void mostrarAnimais() {
		for(int i=0;i<quantAnimais;i++) {
			System.out.println("\t animal "+i+": "+animais[i].toString());
		}
	}
	
	public void alocarAnimal(Animal animal,Viveiro viveiro) throws EspacoIndisponivelException{
		if(animal instanceof Peixe) {
			if(viveiro instanceof Aquario) {
				if(((Aquario) viveiro).volumeDisponivel()>=(((Peixe) animal).calculaVolume()*0.7)) {
					if(((Aquario) viveiro).getTemperatura()<(((Peixe) animal).getTemperaturaIdeal()+3) && ((Aquario) viveiro).getTemperatura()>(((Peixe) animal).getTemperaturaIdeal()-3)) {
						((Aquario) viveiro).setPeixes((Peixe)animal);
						System.out.println("Alocado com Sucesso!");
					}else {
						
						EspacoIndisponivelException erro=new EspacoIndisponivelException("temperatura inadequada ao animal");
						throw erro;
					}
				}
			}else {
				EspacoIndisponivelException erro=new EspacoIndisponivelException("Viveiro inadequado ao animal");
				throw erro;
			}
		}else {
			if(viveiro instanceof Aquario) {
				EspacoIndisponivelException erro=new EspacoIndisponivelException("Viveiro inadequado ao animal");
				throw erro;
			}else {
				if(viveiro.areaDisponivel()>=((animal.calcularArea())*0.7)){
					viveiro.setAnimais(animal);
					System.out.println("Alocado com Sucesso!");
				}else {
					EspacoIndisponivelException erro=new EspacoIndisponivelException("Espaço inadequado ao animal");
					throw erro;
				}
			}
		}
	}
	
	
	
}
