package dados;

public class Viveiro {
	private String nome;
	private Animal[] animais=new Animal[50];
	int quantAnimais=0;
	protected float comprimento;
	protected float largura;
	
	public Viveiro() {
		
	}
	
	public String getNome() {
		return "\t"+nome+"\n\n";
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Animal[] getAnimais() {
		return animais;
	}

	public void setAnimais(Animal animal) {
		if(quantAnimais<=50) {
		this.animais[quantAnimais] = animal;
		quantAnimais++;
		}
	}

	public int getQuantAnimais() {
		return quantAnimais;
	}

	public void setQuantAnimais(int quantAnimais) {
		this.quantAnimais = quantAnimais;
	}


	public float getComprimento() {
		return comprimento;
	}

	
	public void setComprimento(float comprimento) {
		this.comprimento = comprimento;
	}

	
	public float getLargura() {
		return largura;
	}

	
	public void setLargura(float largura) {
		this.largura = largura;
	}
	
	public float areaDisponivel() {
		float areaOcupada=0;
		
		for(int i=0;i<this.quantAnimais;i++) {
			areaOcupada+=this.animais[i].calcularArea();
		}
		
		return this.calcularAreaViveiro()-areaOcupada;
	}
	public float calcularAreaViveiro() {
		return this.largura*this.comprimento;
	}
	
}
