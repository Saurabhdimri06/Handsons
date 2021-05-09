package org.example;

public enum Doctor {
	
	john("Ishan John"),
	vickram("john vickram"),
	vijay("Joesph Vijay"),
	dulquer("dulquer salman");

	private String doctorName;
	
	public String getDoctorName() {
		return doctorName;
	}
	
	private Doctor(String doctorName) {
		this.doctorName = doctorName;
	}

}
