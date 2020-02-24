package cl.awakelab.oscurilandia.models;

import java.util.Date;

import cl.awakelab.oscurilandia.helpers.RandomFecha;

public class Kromi extends Carro {

	private Date fabricacion;
	private String marca;
	
	public Kromi(Ubicacion ubicacion) {
		super(ubicacion);
		this.fabricacion = new RandomFecha().getFecha();
		this.marca = new String("Volvo");
	}
	
	public Date getFabricacion() {
		return fabricacion;
	}

	public void setFabricacion(Date fabricacion) {
		this.fabricacion = fabricacion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		 return "Kromi(ubicacion: " + this.getUbicacion() + 
	                ", ingreso: '" + this.getIngreso() + 
	                "', ocupantes: " + this.getOcupantes() + ")" +
	                "Fecha de fabricacion : " + this.getFabricacion() +
	                "Marca : " + this.getMarca();
		
	}

	@Override
	public String getTipo() {
		
		return "Kromi";
	}

}
