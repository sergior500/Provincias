package com.jacaranda.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.jacaranda.utilities.Provincia;
import com.jacaranda.utilities.ProvinciaException;
import com.jacaranda.utilities.Pueblo;
import com.jacaranda.utilities.PuebloException;

class ProvinciaTest {

	@Test
	void testCrearProvinciaDatos() {
		Provincia pr = new Provincia("sevilla","45");
		assert(pr instanceof Provincia && pr!=null);
		
		/*
		try {
			Provincia pr = new Provincia("Sevilla","11445");
		} catch (Exception e) {
			assert(false);
		}
		assert(true);
		*/
	}
	
	@Test
	void testCrearProvinciaNombreNull() {
		try {
			Provincia pr = new Provincia(null,"11445");
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	@Test
	void testCrearProvinciaCodigoNull() {
		try {
			Provincia pr = new Provincia("Sevilla",null);
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	@Test
	void testCrearProvincia1Caracter() {
		try {
			Provincia pr = new Provincia("Sevilla","6");
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	}
	
	@Test
	void testCrearProvincia3Caracter() {
		try {
			Provincia pr = new Provincia("Sevilla","12467");
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}
	
	}
	
	@Test
	void testAnadirProvinciaListaVacia() {
		Provincia pr = new Provincia("Sevilla","12");

		pr.addPueblo(new Pueblo("Brenes", "24351"));
		assertEquals(pr.numPueblos(), 1);
		
	}
	
	@Test
	void testAnadirProvinciaListaRepetida() {
		try {
			Provincia pr = new Provincia("Sevilla","12");
			pr.addPueblo(new Pueblo("Brenes", "24441"));
			pr.addPueblo(new Pueblo("Brenes", "24451"));
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}

		
	}
	/*
	@Test
	void testAnadirProvinciaListaRepetida() {
		try {
			Provincia pr = new Provincia("Sevilla","63");
			pr.addPueblo(new Pueblo("Brenes", "21"));
			pr.addPueblo(new Pueblo("Brenes", "21"));
			assert(false);
		} catch (ProvinciaException pe) {
			assert(true);
		}

		
	}
	*/
	
	@Test
	void testPuebloRentaNegativa() {
		try {
			Pueblo p1 = new Pueblo("Brenes", "12345", 23, -2.0, 2300.0);
			assert(false);
		} catch (PuebloException pe) {
			assert(true);
		}
		
	}
	@Test
	void testPuebloSuperficieNegativa() {
		try {
			Pueblo p1 = new Pueblo("Brenes", "12345", 23, 20.00, -2.0);
			assert(false);
		} catch (PuebloException pe) {
			assert(true);
		}
		
	}
	
	@Test
	void testPuebloHabitantesNegativos() {
		try {
			Pueblo p1 = new Pueblo("Brenes", "12345", -23, 2.0, 2300.0);
			assert(false);
		} catch (PuebloException pe) {
			assert(true);
		}
		
	}
	

}
