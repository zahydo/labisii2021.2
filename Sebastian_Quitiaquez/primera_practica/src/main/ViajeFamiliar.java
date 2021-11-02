package main;

import java.util.Date;

public class ViajeFamiliar extends Viaje {
	public ViajeFamiliar(String origen, String destino, int costo, Date fechaSalida, Date fechaLlegada, int i) {
		super(origen, destino, costo, fechaSalida, fechaLlegada);
		this.familia=i;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Cantidad de integrantes de la familia
	 */
	private int familia;

//Constructor getters and setters
	
	@Override
	public String descripcion() {
		return "Viaje para disfrutar con toda tu familia";
	}

	public int getFamilia() {
		return familia;
	}

	public void setFamilia(int familia) {
		this.familia = familia;
	}

	@Override
	public String cualquierMetodo2() {
		return "Método implementado en la clase hija viaje familiar";
	}
}
