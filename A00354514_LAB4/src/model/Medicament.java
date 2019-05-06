package model;

public class Medicament{

//Atributes

private String nameOfMedicament;
private double dose;
private double totalDose;
private int frecuency;

//Relation
private HistorialDated  med1;

//Constructor
/**
*Description this constructor initializate the variables
*@param  nameOfMedicament String dose
*@param  dose double name of the medicament
*@param  totalDose double total dose
*@param  frecuency int frecuency
*/
public Medicament(String nameOfMedicament, double dose, double totalDose, int frecuency){

this.nameOfMedicament = nameOfMedicament;
this.dose = dose;
this.totalDose = totalDose;
this.frecuency = frecuency;
}

/**
*Description this method get the the name of the medicament
*@return String the name of the medicament
*/
public String getNameOfMedicament(){
  return nameOfMedicament;
}

/**
*Description this method set the name of the medicament
*@param nameOfMedicament String the name of the medicament
*/
public void setNameOfMedicament(String nameOfMedicament){
  this.nameOfMedicament = nameOfMedicament;
}

/**
*Description this method get the dose of the medicament
*@return double the dose of the medicament
*/
public double getDose(){
  return dose;
}

/**
*Description this method set the dose of the medicament
*@param dose double the dose of the medicament
*/
public void setDose(double dose){
  this.dose = dose;
}

/**
*Description this method get the total dose of the medicament
*@return double the total dose of the medicament
*/
public double getTotalDose(){
  return totalDose;
}

/**
*Description this method set the of the medicament
*@param totalDose int the total dose of the medicament
*/
public void setTotalDose(double totalDose){
  this.totalDose = totalDose;
}

/**
*Description this method get the frecuency of the doses of the medicament
*@return int  the frecuency of the doses of the medicament
*/
public int getFrecuency(){
  return frecuency;
}

/**
*Description this method set the frecuency of the doses of the medicament
*@param frecuency int the frecuency of the doses of the medicament
*/
public void setFrecuency(int frecuency){
  this.frecuency = frecuency;
}

/**
*Description this method shows the information of the medicaments
*@return String the information of the medicaments
*/
public String showInfoMedica(){
String msj = "";

msj += "El medicamento es:" + nameOfMedicament;
msj += "La dosis es:" + dose;
msj += "Total de dosis" + calculatedDose();
msj += "La frecuencia es" + frecuency;

return msj;

}

/**
*Description this method calculate the dose
*@return double the correct dose
*/
public double calculatedDose(){
double doseXcost = 0.0;

doseXcost += dose * totalDose;

return doseXcost;



}


}