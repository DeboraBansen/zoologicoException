package dados;

public class Aquario extends Viveiro{
	private float altura;
	private float temperatura;
	private Peixe [] peixes=new Peixe[100];
	private int quantPeixe=0;
	
	public Aquario() {
		super();
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public Peixe[] getPeixes() {
		return peixes;
	}

	public void setPeixes(Peixe peixe) {
		if(quantPeixe<100) {
		this.peixes[quantPeixe] = peixe;
		quantPeixe++;
		}
	}

	public int getQuantPeixe() {
		return quantPeixe;
	}

	public void setQuantPeixe(int quantPeixe) {
		this.quantPeixe = quantPeixe;
	}
	
	public float volumeDisponivel() {
		
		float areaOcupada=0;
		
		for(int i=0;i<quantPeixe;i++) {
			areaOcupada+=this.peixes[i].calculaVolume();
		}
		
		return volumeAquario()-areaOcupada;
	}
	
	public float volumeAquario() {
		return ((this.largura*this.comprimento*this.largura)/3);
	}
	
}

