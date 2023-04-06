package com.caresoft.clinicapp;

public class Physician extends User implements HIPPAComplianceUser {

	public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub 4-digits
		if(pin<1000 || pin >9999 ) {
			return false;
		}
		this.pin = pin;
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub vs given id
		if(this.id == confirmedAuthID) {
			return true;
		}
		return false;
	}

}
