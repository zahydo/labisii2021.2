package negocio;

import java.util.Date;

public abstract class Viaje {
	protected String origen;
	protected String destino;
	protected int costo;
	protected Date fechaSalida;
	protected Date fechaLlegada;
	
	// Constructores, getters y setters
	public Viaje() {
	}
	public Viaje(String origen, String destino, int costo, Date fechaSalida, Date fechaLlegada) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.costo = costo;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
	}
	
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Date getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	
	public abstract String descripcion();
	
	public String cualquierMetodo() {
		return "Cualquier m�todo implementado en la clase base";
	}
	public String cualquierMetodo2() {
		return "Cualquier m�todo2 implementado en la clase base";
	}
}