package dados;


public class Peixe extends Animal {
	private float temperaturaIdeal;
	
	public Peixe() {
		super();
	}

	public float getTemperaturaIdeal() {
		return temperaturaIdeal;
	}

	public void setTemperaturaIdeal(float temperaturaIdeal) {
		this.temperaturaIdeal = temperaturaIdeal;
	}
	
	public float calculaVolume() {
		return ((super.calcularArea()*this.altura)/3);
	}
}
