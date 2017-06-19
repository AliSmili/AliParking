package Models;

import java.util.Collections;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Models.Vehiculo;
import Models.comparaVehiculos;
import Models.listaVehiculosParking;
 class controlVehiculos {
	
	private static comparaVehiculos<Vehiculo> comp;
	public static listaVehiculosParking<Vehiculo> listaVehiculos = new listaVehiculosParking<Vehiculo>(comp );
		
		
	
	public static boolean BuscarMatricula(String matricula){
		Vehiculo veh = ObtenerMatricula(matricula);
		
		if(veh == null){
			return false;
		}else{
			return true;
		}
	}
	
	public static Vehiculo ObtenerMatricula(String matricula){
		Vehiculo veh = null;
		
		for(Vehiculo i: listaVehiculos){
			if(i.getMatricula().equals(matricula)){
				veh = i;
			}
		}
		
		return veh;
	}
		public static boolean Buscar(long horaEntrada){
			Vehiculo veh = Obtener(horaEntrada);
			
			if(veh == null){
				return false;
			}else{
				return true;
			}
		}
		
		
		public static Vehiculo Obtener(long horaEntrada){
			Vehiculo veh = null;
			
			for(Vehiculo i: listaVehiculos){
				if(i.getHoraEntrada()==horaEntrada){
					veh = i;
				}
			}
			
			return veh;
		}
		
		/**
		 Aniadimos el vehiculo si la hora de entrada no coincide en nuestra lista
		 */
		public static void Aniadir(String matricula,long horaEntrada, long horaSalida, double pago){
			if(Buscar(horaEntrada)) throw new RuntimeException("No se puede añadir el vehículo porque ya hay uno con la misma hora de entrada");
			
			listaVehiculos.add(new Vehiculo(matricula,horaEntrada,horaSalida, pago));
			Collections.sort(listaVehiculos, comp);
		}

}
