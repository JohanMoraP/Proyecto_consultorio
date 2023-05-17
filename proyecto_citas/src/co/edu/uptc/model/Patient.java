package co.edu.uptc.model;

public class Patient extends Person {
   
	
	public Patient() {
		
	}
	
	public Patient(String name, String lastName, int age, String phone,String identification) {
		// TODO Auto-generated constructor stub
		this.setName(name);
		this.setLastName(lastName);
		this.setAge(age);
		this.setPhone(phone);
		this.setIdentification(identification);
	}
	
}
