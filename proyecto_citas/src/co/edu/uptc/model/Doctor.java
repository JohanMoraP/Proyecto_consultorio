package co.edu.uptc.model;

public class Doctor extends Person {

	private String speciality;

	public Doctor() {

	}

	public Doctor(String name, String lastName, int age, String phone,String identification,String speciality) {
		this.setName(name);
		this.setLastName(lastName);
		this.setAge(age);
		this.setPhone(phone);
		this.setIdentification(identification);
		this.speciality=speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getSpeciality() {
		return speciality;
	}

}
