package co.edu.uptc.model;

import java.util.ArrayList;

public class ControlModel {

    public ArrayList<Patient> listPatients;
    public ArrayList<Doctor> listDoctors;
    public GeneralSchedule generalSchedule;

    public ControlModel(){

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

    
    
}
