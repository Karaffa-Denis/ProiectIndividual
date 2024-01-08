package main;

import java.util.ArrayList;
import java.util.Arrays;

public class Car {
	String marca;
	String model;
	int an;
	Combustibil comb;
	int km;
	ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(10000, 35000, 55000, 40000, 90000, 15000, 365, 365));
	
	public Car(String marca, String model, int an, Combustibil comb, int km) {
		super();
		this.marca = marca;
		this.model = model;
		this.an = an;
		this.comb = comb;
		this.km = km;
	}
	
	public String getmarca() {
		return marca;
	}
	public void setmarca(String marca) {
		this.marca = marca;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getAn() {
		return an;
	}
	
	public void setAn(int an) {
		this.an = an;
	}
	public Combustibil getComb() {
		return comb;
	}
	public void setComb(Combustibil comb) {
		this.comb = comb;
	}
	
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public String toString() {
		return this.marca +" " + this.model;
	}

	public ArrayList<Integer> getArr() {
		return arr;
	}

	public void setArr(ArrayList<Integer> arr) {
		this.arr = arr;
	}
	
	public void setServiceVar(int index, int newNr) {
		this.arr.set(index, newNr);
	}
	
	
	
	
}
