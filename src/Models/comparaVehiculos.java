package Models;

import java.util.Comparator;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class comparaVehiculos<T> implements Comparator<T>{
	private Vehiculo v1, v2;

	public comparaVehiculos(){
		
	}
	/**
	 * ORDENACION DE MAYOR A MENOR SEGUN FECHA DE ENTRADA
	 */
	  public int compare(Object v1, Object v2){
	      long fecha1 = ((Vehiculo) v1).getHoraEntrada( );
	      long fecha2 = ((Vehiculo) v2).getHoraEntrada() ;
	      if(fecha1>fecha2){
	          return -1;
	       }else if(fecha1<fecha2){
	          return 1;
	       }else{
	          return 0;
	       }
	    }
	  
	

}
