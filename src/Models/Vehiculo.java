package Models;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Vehiculo {
	
	private String matricula;
	protected long horaEntrada;
	protected long horaSalida;
	protected double pago;
	public Vehiculo(String matricula, long horaEntrada, long horaSalida, double pago) {
		this.matricula = matricula;
		this.horaEntrada = horaEntrada;
		this.horaSalida = horaSalida;
		this.pago = pago;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public long getHoraEntrada() {
		return horaEntrada;
	}
	public void setHoraEntrada(long horaEntrada) {
		this.horaEntrada = horaEntrada;
	}
	public long getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(long horaSalida) {
		this.horaSalida = horaSalida;
	}
	public double getPago() {
		return pago;
	}
	public void setPago(double pago) {
		this.pago = pago;
	}
	
	

}
