package co.edu.uptc.model;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

public class ControlModel {

    public ArrayList<Patient> listPatients;
    public ArrayList<Doctor> listDoctors;
    public GeneralSchedule generalSchedule;
    public ArrayList<String> hoursListAppointments;
    public ArrayList<String> specialityList;

    public ControlModel(){
      generalSchedule= new GeneralSchedule();
      createListHourAppontments();
      createSpecialityList();
    }


    private void createSpecialityList() {
        specialityList= new ArrayList<>();
        specialityList.add("ODONTOLOGIA GENERAL");
        specialityList.add("CIRUGIA ORAL Y MAXILOFACIAL");
        specialityList.add("ENDODONCIA");
        specialityList.add("ODONTOLOGIA ESTETICA");
        specialityList.add("PERIODONCIA");
        specialityList.add("ORTODONCIA");
        specialityList.add("PATOLOGIA BUCAL");
    }

    private void createListHourAppontments() {
        hoursListAppointments=  new ArrayList<>();
        hoursListAppointments.add("08:00 A.M");
        hoursListAppointments.add("08:30 A.M");
        hoursListAppointments.add("09:00 A.M");
        hoursListAppointments.add("09:30 A.M");
        hoursListAppointments.add("10:00 A.M");
        hoursListAppointments.add("10:30 A.M");
        hoursListAppointments.add("11:00 A.M");
        hoursListAppointments.add("11:30 A.M");
        hoursListAppointments.add("12:00 P.M");
        hoursListAppointments.add("12:30 P.M");
        hoursListAppointments.add("1:00 P.M");
        hoursListAppointments.add("1:30 P.M");
        hoursListAppointments.add("2:00 P.M");
        hoursListAppointments.add("2:30 P.M");
        hoursListAppointments.add("3:00 P.M");
        hoursListAppointments.add("3:30 P.M");
        hoursListAppointments.add("4:00 P.M");
        hoursListAppointments.add("4:30 P.M");
    }


    public ArrayList<Patient> getListPatients() {
        return listPatients;
    }

    public void setListPatients(ArrayList<Patient> listPatients) {
        this.listPatients = listPatients;
    }

    public ArrayList<Doctor> getListDoctors() {
        return listDoctors;
    }

    public void setListDoctors(ArrayList<Doctor> listDoctors) {
        this.listDoctors = listDoctors;
    }

    public GeneralSchedule getGeneralSchedule() {
        return generalSchedule;
    }

    public void setGeneralSchedule(GeneralSchedule generalSchedule) {
        this.generalSchedule = generalSchedule;
    }

    public String[] searchUser(String idSearch) {
        String exit[] =new String[5];
        for (int index = 0; index < listPatients.size(); index++) {
            if(listPatients.get(index).getIdentification().equals(idSearch)){
                exit[0]=listPatients.get(index).getName();
                exit[1]=listPatients.get(index).getLastName();
                exit[2]=""+listPatients.get(index).getAge();
                exit[3]=listPatients.get(index).getPhone();
                exit[4]=listPatients.get(index).getIdentification();
                index=listPatients.size();
                return exit;
            } 
        }
        return null;
    }

    public Patient searchUserObject(String idSearch) {
        for (int index = 0; index < listPatients.size(); index++) {
            if(listPatients.get(index).getIdentification().equals(idSearch)){
                return listPatients.get(index);
            } 
        }
        return null;
    }

    public String[] searchDoctor(Object idSearch) {
        String exit[] =new String[6];
        for (int index = 0; index < listDoctors.size(); index++) {
            if(listDoctors.get(index).getIdentification().equals(idSearch)){
                exit[0]=listDoctors.get(index).getName();
                exit[1]=listDoctors.get(index).getLastName();
                exit[2]=""+listDoctors.get(index).getAge();
                exit[3]=listDoctors.get(index).getPhone();
                exit[4]=listDoctors.get(index).getIdentification();
                exit[5]=listDoctors.get(index).getSpeciality();
                index=listDoctors.size();
                return exit;
            } 
        }
        return null;
    }

    public ArrayList<Doctor> doctorsSpecialitySearch(String speciality){
        ArrayList<Doctor> doctorSpecialityFilter=new ArrayList<>();
        for (Doctor doctor : listDoctors) {
            if(doctor.getSpeciality().equals(speciality)){
               doctorSpecialityFilter.add(doctor);
            } 
        }
        return doctorSpecialityFilter;
    }

    public ArrayList<String> listHourDisponibility(String doctor, String date){
        ArrayList<String> busyHour= listHourBusy(doctor,date);
        ArrayList<String> hoursDisponibility= hoursListAppointments;
        for (String busyHourIter : busyHour) {
            for (int index = 0; index < hoursListAppointments.size(); index++) {
                if(hoursListAppointments.get(index).equals(busyHourIter)){
                    hoursDisponibility.remove(index);
                }
            }
        }
        return  hoursDisponibility;
    }

    public ArrayList<String> listHourBusy(String doctor, String date){
        String idDoctorSelected= searchDoctorForName(doctor);
        ArrayList<String> busyHour= new ArrayList<>();
        if(idDoctorSelected!=null){
        for (Appointment appointment : generalSchedule.getScheduleAppoint()) {
            if((appointment.getDoctor().getIdentification().equals(idDoctorSelected)) && (dateConvert(appointment.getDateAppoint()).equals(date))){
                System.out.println("OCUPADA"+ appointment.getHour());
                busyHour.add(appointment.getHour());
            }
         }
        }
        return busyHour;
    }

    public String dateConvert(Date date){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        String fechaComoCadena = formato.format(date);
        System.out.println("fecha cadena control"+fechaComoCadena);
        return fechaComoCadena;

    }

    public String searchDoctorForName(String doctor) {
        String[] doctorSelected=doctor.split(" ");
        for (Doctor doctorI : listDoctors) {
            if(doctorI.getName().equals(doctorSelected[0]) && doctorI.getLastName().equals(doctorSelected[1])){
                return doctorI.getIdentification();
            }
        }
        return null;
    }
    
    public Doctor searchDoctorObject(String doctor) {
        String[] doctorSelected=doctor.split(" ");
        for (Doctor doctorI : listDoctors) {
            if(doctorI.getName().equals(doctorSelected[0]) && doctorI.getLastName().equals(doctorSelected[1])){
                return doctorI;
            }
        }
        return null;
    }
    
    public ArrayList<String> getHoursListAppointments() {
        return hoursListAppointments;
    }

    public void setHoursListAppointments(ArrayList<String> hoursListAppointments) {
        this.hoursListAppointments = hoursListAppointments;
    }

    public ArrayList<String> getSpecialityList() {
        return specialityList;
    }

    public void setSpecialityList(ArrayList<String> specialityList) {
        this.specialityList = specialityList;
    }


    public ArrayList<Appointment> searchAppointForUser(String idSearch) {
        ArrayList<Appointment> appointForUser= new ArrayList<>();
        for (Appointment appoin : getGeneralSchedule().scheduleAppoint) {
            if(appoin.getPatient().getIdentification().equals(idSearch)){
                appointForUser.add(appoin);
            }
        }
        return appointForUser;
    }

}
