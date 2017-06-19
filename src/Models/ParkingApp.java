package Models;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class ParkingApp {

	public JFrame frame;
	private JTextField txtMatricula;
	private JTextField txtHoraEntrada;
	private JTextField txtHoraSalida;
	private JTextField txtImporte;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JButton btnSalida;
	private JButton btnEntrada;
	private JLabel lblCambio;
	private JLabel lblTotal;
	private JButton btnPagar;
	private String matricula;
	private Date date1;
	private Date date2;
	private boolean esCorrecto = true;
	private double importe;
	private double caja = 0;
	private double total = 0;
	private JTextPane txtTotalCaja;
	private long h1, h2, intervalo;
	private JButton btnNuevo;
	private JButton btnSalir;
	private DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
	private final double tarifa = 0.06;
	private double cambio = 0;
	private long fexa1;
	private long fexa2;

	/**
	 * Create the application.
	 */
	public ParkingApp() {
		initialize();
		label_1.setVisible(false);

		txtHoraEntrada.setVisible(false);

		label_2.setVisible(false);

		txtHoraSalida.setVisible(false);

		btnPagar.setVisible(false);

		label_5.setVisible(false);

		label_3.setVisible(false);

		txtImporte.setVisible(false);

		label_4.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 734, 661);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("PARKING APP");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(303, 11, 166, 30);
		frame.getContentPane().add(label);

		JButton btnEntrada = new JButton("ENTRADA VEHICULO");
		btnEntrada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/**
				 * Registramos la hora de entrada del vehiculo
				 */
				date1 = new Date();
				fexa1 = date1.getTime();

				// System.out.println("Hora: "+hourFormat.format(date));

				matricula = txtMatricula.getText();
				Vehiculo veh = new Vehiculo(txtMatricula.getText(), fexa1, 0, 0);
				// txtHoraEntrada.setText("" + fexa1);
				txtHoraEntrada.setText(hourFormat.format(date1));

				/**
				 * Añadimos el vehiculo a la lista
				 */

				if (matricula != null && !matricula.equals("")) {

					if (!controlVehiculos.BuscarMatricula(matricula)) {

						controlVehiculos.Aniadir(txtMatricula.getText(), fexa1, fexa2, 0);
						// txtFechaEntrada.
						JOptionPane.showMessageDialog(null, "Se ha registrado el vehículo con exito ! ");
					} else {
						JOptionPane.showMessageDialog(null, "El vehículo con esta matrícula ya esta en el parking ! ");
					}

				} else {
					JOptionPane.showMessageDialog(null,
							"Hay que introducir una matricula para registrar el vehículo! ");
				}
			}
		});
		btnEntrada.setBounds(21, 58, 210, 118);
		frame.getContentPane().add(btnEntrada);

		btnSalida = new JButton("SALIDA VEHICULO");
		btnSalida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/**
				 * habilitamos los botones y los labels correspondientes
				 */

				label_1.setVisible(true);

				txtMatricula.setEnabled(true);

				txtHoraEntrada.setVisible(true);

				label_2.setVisible(true);

				txtHoraSalida.setVisible(true);

				btnPagar.setVisible(true);

				label_5.setVisible(true);

				label_3.setVisible(true);

				txtImporte.setVisible(true);

				label_4.setVisible(true);

				btnEntrada.setEnabled(false);

				date2 = new Date();
				fexa2 = date2.getTime();
				txtHoraEntrada.setText(hourFormat.format(date2));

				if (controlVehiculos.BuscarMatricula(txtMatricula.getText())) {
					controlVehiculos.ObtenerMatricula(txtMatricula.getText()).setHoraSalida(fexa2);
				}

				txtHoraSalida.setText(hourFormat.format(date2));

			}
		});
		btnSalida.setBounds(259, 58, 210, 118);
		frame.getContentPane().add(btnSalida);

		JButton btnCaja = new JButton("CAJA DEL DÍA");
		btnCaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// controlVehiculos.listaVehiculos
				for (Vehiculo v : controlVehiculos.listaVehiculos) {
					caja += total;
				}
				txtTotalCaja.setText("" + caja);

			}
		});
		btnCaja.setBounds(497, 58, 210, 118);
		frame.getContentPane().add(btnCaja);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(213, 226, 256, 42);
		frame.getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);

		JLabel lblMatricula = new JLabel("MATRICULA");
		lblMatricula.setBounds(21, 226, 97, 42);
		frame.getContentPane().add(lblMatricula);

		txtHoraEntrada = new JTextField();
		txtHoraEntrada.setColumns(10);
		txtHoraEntrada.setBounds(213, 308, 256, 42);
		frame.getContentPane().add(txtHoraEntrada);

		txtHoraSalida = new JTextField();
		txtHoraSalida.setColumns(10);
		txtHoraSalida.setBounds(213, 400, 256, 42);
		frame.getContentPane().add(txtHoraSalida);

		label_1 = new JLabel("HORA DE ENTRADA");
		label_1.setBounds(21, 308, 114, 42);
		frame.getContentPane().add(label_1);

		label_2 = new JLabel("HORA DE SALIDA");
		label_2.setBounds(21, 400, 97, 42);
		frame.getContentPane().add(label_2);

		btnPagar = new JButton("Pagar y salir del Parking");

		try {
			btnPagar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					/**
					 * logica detras de este boton
					 */

					if (txtMatricula.getText() == null || txtMatricula.getText().equals("")) {

						JOptionPane.showMessageDialog(null, "Matricula no establecida! ");
						esCorrecto = false;
					}

					if (txtImporte.getText() == null || txtImporte.getText().equals("")) {

						JOptionPane.showMessageDialog(null, "Importe  no establecido! ");
						esCorrecto = false;
					}

					lblTotal.setVisible(true);
					total = 0;

					try {
						/*
						 * h1 = Long.parseLong(txtHoraEntrada.getText()); h2 =
						 * Long.parseLong(txtHoraSalida.getText()); intervalo =
						 * h2 - h1;
						 */
						intervalo = fexa2 - fexa1;
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Error del calculo diferencial de las fechas! ");
					}

					total = (((double) intervalo / 1000) / 60) * tarifa;

					cambio = tarifa - importe;

					date2 = new Date();
					if (!controlVehiculos.BuscarMatricula(txtMatricula.getText())) {

						JOptionPane.showMessageDialog(null, "Este vehículo no se encuentra en el parking ! ");
					} else {
						if (txtHoraEntrada.getText() == null || txtHoraEntrada.getText().equals("")
								|| txtImporte.getText() == null || txtImporte.getText().equals("")
								|| txtHoraSalida.getText() == null || txtHoraSalida.getText().equals("")) {
							JOptionPane.showMessageDialog(null,
									"ERROR , Hay que introducir los campos necesarios (Hora entrada,Hora salida,  importe del cliente ! ");
						} else {
							importe = Double.parseDouble(txtImporte.getText());

							if (importe < tarifa || importe == 0) {
								JOptionPane.showMessageDialog(null, "EL IMPORTE ES INSUFICIENTE! ");
							} else {

								lblCambio.setText("" + cambio);
								lblTotal.setText("" + total);
								controlVehiculos.ObtenerMatricula(matricula)
										.setHoraSalida(fexa2);
								controlVehiculos.ObtenerMatricula(matricula)
										.setPago(Double.parseDouble(txtImporte.getText()));
								JOptionPane.showMessageDialog(null, "SE HAN INSERTADO LOS DATOS CON EXITO! ");
							}

						}
					}
				}
			});

		} catch (Exception e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

		btnPagar.setBounds(214, 453, 210, 80);
		frame.getContentPane().add(btnPagar);

		txtImporte = new JTextField();
		txtImporte.setColumns(10);
		txtImporte.setBounds(494, 400, 181, 42);
		frame.getContentPane().add(txtImporte);

		label_3 = new JLabel("IMPORTE ENTREGADO");
		label_3.setBounds(510, 347, 154, 42);
		frame.getContentPane().add(label_3);

		label_4 = new JLabel("Cambio");
		label_4.setBounds(504, 446, 154, 30);
		frame.getContentPane().add(label_4);

		lblCambio = new JLabel("");
		lblCambio.setBounds(504, 486, 154, 42);
		frame.getContentPane().add(lblCambio);

		label_5 = new JLabel("TOTAL A PAGAR");
		label_5.setBounds(510, 198, 154, 42);
		frame.getContentPane().add(label_5);

		lblTotal = new JLabel("");
		lblTotal.setBounds(510, 252, 154, 42);
		frame.getContentPane().add(lblTotal);

		txtTotalCaja = new JTextPane();
		txtTotalCaja.setBounds(21, 498, 119, 35);
		frame.getContentPane().add(txtTotalCaja);

		JLabel lblCajaTotal = new JLabel("Total Caja");
		lblCajaTotal.setBounds(21, 454, 97, 22);
		frame.getContentPane().add(lblCajaTotal);

		btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnEntrada.setEnabled(true);

				label_1.setVisible(false);

				txtHoraEntrada.setVisible(false);

				label_2.setVisible(false);

				txtHoraSalida.setVisible(false);

				btnPagar.setVisible(false);

				label_5.setVisible(false);

				label_3.setVisible(false);

				txtImporte.setVisible(false);

				label_4.setVisible(false);
				txtMatricula.setText("");
				txtImporte.setText("");
				txtHoraEntrada.setText("");
				txtHoraSalida.setText("");
				lblTotal.setText("");

			}

		});
		btnNuevo.setBounds(49, 549, 210, 62);
		frame.getContentPane().add(btnNuevo);

		btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(465, 549, 210, 62);
		frame.getContentPane().add(btnSalir);
	}

}
