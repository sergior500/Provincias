package com.jacaranda.utilities;

public abstract class Zona {
	protected String nombre;
	protected String codigo;
	protected int numeroHabitantes;
	protected double rentaPerCapital;
	protected double superficie;
	
	public Zona(String nombre, String codigo, Integer numeroHabitantes, Double rentaPerCapital, Double superficie) {
		this.nombre = nombre;
		this.codigo = codigo;
		setNumeroHabitantes(numeroHabitantes);
		setRentaPerCapital(rentaPerCapital);
		setSuperficie(superficie);
	}
	public Zona(String nombre, String codigo) {
		if (nombre==null || codigo==null || codigo.length()!=numCodigo()) {
			throw new ProvinciaException("No se ha podido crear la provincia");
		}else {
			for (int i = 0; i < codigo.length(); i++) {
				if (!Character.isDigit(codigo.charAt(i))) {
				throw new ProvinciaException("No se ha podido crear la provincia por codigo");

				}
			}
			this.nombre = nombre;
			this.codigo = codigo;
		}		
	}
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Integer getNumeroHabitantes() {
		return numeroHabitantes;
	}


	public void setNumeroHabitantes(Integer numeroHabitantes) {
		if (numeroHabitantes<0) {
			throw new PuebloException("La renta es erronea");
		}else {			
			this.numeroHabitantes = numeroHabitantes;
		}
	}


	public Double getRentaPerCapital() {
		return rentaPerCapital;
	}


	public void setRentaPerCapital(Double rentaPerCapital) {
		if (rentaPerCapital<0) {
			throw new PuebloException("La renta es erronea");
		}else {			
			this.rentaPerCapital = rentaPerCapital;
		}
	}

	
	public Double getSuperficie() {
		return superficie;
	}


	public void setSuperficie(Double superficie) {
		if (superficie<0) {
			throw new PuebloException("La renta es erronea");
		}else {			
			this.superficie = superficie;
		}
	}
	
	public abstract int numCodigo();


}

