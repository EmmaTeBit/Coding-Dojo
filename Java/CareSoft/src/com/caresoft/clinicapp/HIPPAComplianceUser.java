package com.caresoft.clinicapp;

public interface HIPPAComplianceUser {

	    abstract boolean assignPin(int pin);
	    abstract boolean accessAuthorized(Integer confirmedAuthID);
	

}
