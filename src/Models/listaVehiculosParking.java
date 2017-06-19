package Models;

import java.util.ArrayList;
import java.util.Comparator;

public class listaVehiculosParking <T> extends ArrayList <T>{
	
	private comparaVehiculos<T> miComparador;

	
	public listaVehiculosParking(comparaVehiculos<T> comp){
		
		this.miComparador =  comp;
	
	}

}
