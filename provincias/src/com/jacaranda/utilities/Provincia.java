package com.jacaranda.utilities;

import java.util.ArrayList;
import java.util.List;

public class Provincia extends Zona{


	private List<Pueblo> listaPueblos= new ArrayList<Pueblo>();
	public static final int LONGCOD = 2;
	
	public Provincia(String nombre, String codigo) {
		super(nombre,codigo);
		}		
	
	private boolean existePueblo(String nombrePueblo) {
		Pueblo p1= null;
		
		for (int i = 0; i <listaPueblos.size() && p1==null; i++) {
			if (listaPueblos.get(i).getNombre().equals(nombrePueblo)) {
				p1=listaPueblos.get(i);
	
			}
		}
		
		return p1!=null;
	}

	
	public boolean addPueblo(Pueblo pu) {
		boolean resultado=false;
		//!this.listaPueblos.contains(pu) 
		if (existePueblo(pu.getNombre())) {
			throw new ProvinciaException("Error,no se ha podido añadir el pueblo");
		}else {
			this.listaPueblos.add(pu);
			setRentaPerCapital(rentaPerCapital+pu.getRentaPerCapital());
			setNumeroHabitantes(numeroHabitantes+pu.getNumeroHabitantes());
			setSuperficie(superficie+pu.getSuperficie());
			resultado=true;
		}
		
		return resultado;
	}
	public Integer numPueblos () {
		return this.listaPueblos.size();
	}
	public String listadoNombrePueblos () {
	
		StringBuilder sb = new StringBuilder();
		for (Pueblo i : listaPueblos) {
			sb.append(i.getNombre()+"\n");
		}
		
		return sb.toString();
	}
	
	public String listadoPueblos () {
		
		StringBuilder sb = new StringBuilder();
		for (Pueblo i : listaPueblos) {
			sb.append(i+"\n");
		}
		
		return sb.toString();
	}
	
	public boolean delPueblo (String nombre) {
		boolean res=false;
		if (existePueblo(nombre)) {
			for (Pueblo i : listaPueblos) {
				if (nombre.equals(i.getNombre())) {
					setRentaPerCapital(rentaPerCapital-i.getRentaPerCapital());
					this.listaPueblos.remove(nombre);
					res=true;
				}
			}
		}
		return res; 
	}



	public String getInformacionPueblo(String nombre) {
		StringBuilder sb =  new StringBuilder();
		
		if (existePueblo(nombre)) {
			for (Pueblo pueblo : listaPueblos) {
				if (nombre.equals(pueblo.getNombre())) {
					sb.append(pueblo);
				}
			}
		}
		
		return sb.toString();
	}

	@Override
	public int numCodigo() {
		return LONGCOD;
	}
	
	
	
}
