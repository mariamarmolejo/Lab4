package model;
import java.util.ArrayList;

public class ClinicalHistory{

//Constant

private final static boolean STATE_OPEN = true;
private final static boolean STATE_CLOSE = false;

//Atributes
private String petInfo;
private String ownerInfo;
private String symptom;
private String diagnostic;
private boolean state;


//Relations
private ArrayList<Medicament> medicaments;
private HistorialDated date1;
private HistorialDated date2;
private Pet petsAll;

//Constructor

/**
*Description this constructor initialize the variables
*@param petInfo String name of the pet
*@param ownerInfo String name of the client
*@param symptom String symptom of the pet
*@param diagnostic String diagnostic of the pet
*@param state boolean status of the pet
*@param date1 HistorialDated initial date
*@param date2 HistorialDated final date
*@param petsAll Pet all pets in the register
*/
public ClinicalHistory(String petInfo, String ownerInfo,String symptom, String diagnostic, boolean state, HistorialDated date1, HistorialDated date2,Pet petsAll){

this.symptom = symptom;
this.diagnostic = diagnostic;
this.state = state;
this.date1 = date1;
this.date2 = date2;
this.petInfo = petInfo;
this.ownerInfo = ownerInfo;
medicaments = new ArrayList<Medicament>();
}

/**
*Description this method get the name of the pet
*@return String the name of the pet
*/
public String getPetInfo(){
  return petInfo;
}

/**
*Descriptionthis method set the name of the pet
*@param petInfo String the name of the pet
*/
public void setPetInfo(String petInfo){
  this.petInfo = petInfo;
}

/**
*Description this method get the name of the client
*@return String the name of the client
*/
public String getOwnerInfo(){
  return ownerInfo;
}

/**
*Description this method set the the name of the client
*@param ownerInfo String the name of the client
*/
public void setOwnerInfo( String ownerInfo){
  this.ownerInfo = ownerInfo;
}

/**
*Description this method get the symptom of the pet
*@return String the symptom of the pet
*/
public String getSymptom(){
  return symptom;
}

/**
*Description this method set the symptom of the pet
*@param symptom String el sintoma de la mascota
*/
public void setSymptom(String symptom){
  this.symptom = symptom;
}

/**
*Description this method get the diagnostic of the pet
*@return String the diagnostic of the pet
*/
public String getDiagnostic(){
  return diagnostic;
}

/**
*Description this method set the diagnostic of the pet
*@param diagnostic String the diagnostic of the pet
*/
public void setDiagnostic(String diagnostic){
  this.diagnostic = diagnostic;
}

/**
*Description this method get the status of the pet
*@return boolean the status of the pet
*/
public boolean getState(){
  return state;
}

/**
*Description this method set the status of the pet
*@param state boolean the status of the pet
*/
public void setState(boolean state){
  this.state = state;
}

/**
*Description this method get the history 1 of the pet
*@return HistorialDated history of the pet
*/
public HistorialDated getDate1(){
  return date1;
}

/**
*Description this method set the history 1 of the pet
*@param date1 HistorialDated history of the pet
*/
public void setDate1(HistorialDated date1){
  this.date1 = date1;
}

/**
*Description this method get the history 2 of the pet
*@return HistorialDated history of the pet
*/
public HistorialDated getDate2(){
  return date2;
}

/**
*Description this method set the history 2 of the pet
*@param date2 HistorialDated history of the pet
*/
public void setDate2(HistorialDated date2){
  this.date2 = date2;
}

/**
*Description this method get the medicaments
*@return ArrayList arraylist of the medicaments
*/
public ArrayList<Medicament> getMedicaments(){
 return medicaments;
}

/**
*Description this method set the medicaments
*@param medicaments ArrayList arraylist of the medicaments
*/
public void setMedicaments(ArrayList<Medicament> medicaments){
 this.medicaments = medicaments;
}

/**
*Description this method gets all the pets
*@return Pet pets
*/
public Pet getPetsAll(){
  return petsAll;
}

/**
*Description this method set all the pets
*@param petsAll Pet pets
*/
public void setPetsAll(Pet petsAll){
  this.petsAll = petsAll;
}

/**
*Description this method get the initial date
*@return String intial date
*/
public String inicialDate1(){
String msj = "";

msj += date1.getDay() +"\n" + date1.getMonth() +"\n"+ date1.getYear();

return msj;
}

/**
*Description this method obtains the final date
*@return String the final date
*/
public String finalDate2(){
  String msj = "";

  msj += date2.getDay() + "/" + date2.getMonth() + "/" + date2.getYear();

  return msj;
}

/**
*Description this method obtains information of the clinical history
*@return String information of the clinical history
*/
public String infoAnimalHistory(){
  String msj = "";

  msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
  msj += "El nombre del dueño es:" + ownerInfo;
  msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
  msj += "El nombre del pet es:" + petInfo;
  msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
  msj += "El sintomas es:" + symptom;
  msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
  msj += "El diagnostico es:" + diagnostic;
  msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
  msj += "La fecha inicial es:" + inicialDate1();
  msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
  msj += "La fecha de Salida posible es:"  + finalDate2();
  msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
    for(int i = 0; i< medicaments.size(); i++){
  msj += medicaments.get(i).showInfoMedica();
}
  return msj;

}

/**
*Description this method obtains the information of the clinical history
*@return String  information of the clinical history
*/
public String infoAnimalHistoryHospi(){
  String msj = "";

  msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
  msj += "El nombre del dueño es:" + ownerInfo;
  msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
  msj += "El nombre del pet es:" + petInfo;
  msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
  msj += "El sintomas es:" + symptom;
  msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
  msj += "El diagnostico es:" + diagnostic;
  msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
  msj += "La fecha inicial es:" + inicialDate1();
  msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
  msj += "La fecha de Salida es:"  + finalDate2();
  msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
    for(int i = 0; i< medicaments.size(); i++){
  msj += medicaments.get(i).showInfoMedica();
}
  return msj;

}

/**
*Description this method add the medicaments
*@param medic Medicament the medicament
*/
public void addMedicaments(Medicament medic){

  medicaments.add(medic);

}

/**
*Description this method give the days of hospitalization
*@param actualDay int actual day
*@param actualMonth int actual month
*@param  actualYear int actual year
*@return int the days of hospitalization
*/
public int daysInHospitalization(int actualDay, int actualMonth, int actualYear){
int i =0;

i += date1.getFrecuencyOfTheMedicament(actualDay, actualYear, actualYear);

return i;
}

/**
*Description this method obtains the cost of the medicaments
*@return double the cost of the medicaments
*/
public double medicamentCosts(){
  double doseXcost = 0.0;

for(int i = 0; i < medicaments.size(); i++){
doseXcost += medicaments.get(i).calculatedDose();

}
 return doseXcost;
}


/**
*Description This method allows to add new notes to the possible diagnostic during the hospitalization at the patient stories.
*pre: The patient clinic story must be not null.
*post: New notes were added to the possible diagnostic in the patient clinic story.
*@param notes String The notes of possible diagnostic. This param must be not null.
*/
public void addNotes(String notes){

setDiagnostic(notes + getDiagnostic());

}

/**
*Description This method allows to add a new symptom presented during the hospitalization at the patient stories.
*pre: The patient clinic story must be not null.
*post: A new symptom were added to the patient clinic story.
*@param symptomPet String The new symptom presented. This param must be not null.
*/
public void addNewSymptomFinally(String symptomPet){

setSymptom(symptomPet + getSymptom());

}


}
