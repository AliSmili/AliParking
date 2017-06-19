package Demo;

import java.awt.EventQueue;

import Models.ParkingApp;

public class Main {

	public static void main(String[] args) {
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ParkingApp window = new ParkingApp();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}


