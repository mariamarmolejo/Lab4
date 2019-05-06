
package model;

public class Room{

//Atributes

private boolean avaible;
private int numbOfRoom;

//Relation

private Pet petRoom;

/**
*Description this constructor initializate the variables
*@param avaible boolean the avaliable of the room
*@param numbOfRoom int the number of the room
*@param petRoom Pet the pet in the room
*/
public Room(boolean avaible, int numbOfRoom, Pet petRoom){
  this.avaible = avaible;
  this.numbOfRoom = numbOfRoom;
  this.petRoom = petRoom;
}

/**
*Description this method get the avaliable of the room
*@return boolean the avaliable of the room
*/
public boolean getAvaible(){
  return avaible;
}

/**
*Description this method set the avaliable of the room
*@param avaible boolean the avaliable of the room
*/
public void setAvaible(boolean avaible){
  this.avaible = avaible;
}

/**
*Description this method get the number of the room
*@return int the number of the room
*/
public int getnumbOFRoom(){
  return numbOfRoom;
}

/**
*Description this method set the number of the room
*@param numbOfRoom int the number of the room
*/
public void seNumbOfRoom(int numbOfRoom){
  this.numbOfRoom = numbOfRoom;
}
/**
*Description this method get the pet of the room
*@return Pet the pet of the room
*/
public Pet getPetRoom(){
  return petRoom;
}

/**
*Description this method set the pet of the room
*@param petRoom Pet the pet of the room
*/
public void setPetRoom(Pet petRoom){
  this.petRoom = petRoom;
}

/**
*Description this method show the information of the room hopitalizated
*@return String the information of the room hopitalizated
*/
public String showInfoRoomPetHospit(){
String msj = "";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "Si esta ocupado: \n 1. TRUE y si no 2. FALSE si esta ocupado:"+ "" + avaible + "\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "El numero del cuarto es:" + numbOfRoom + "\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "La informacin del animalito es:" + petRoom.showInfoPet() + "\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "Si tiene hospitalziacion:" + petRoom.showInfoPetHospit() + "\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
return msj;

}

/**
*Description this method calculate the cost of the hospitalization
*@param typeAnimal String  type of pet
*@param weight double weigth of pet
*@param actualDay int actual day
*@param actualMonth int actual month
*@param actualYear int actual year
*@return String the cost of the hospitalization
*/
public String  costOfhospi(String typeAnimal, double weight,int actualDay, int actualMonth, int actualYear){
String total ="";

total += petRoom.costOfHospitalizate(typeAnimal, weight, actualDay, actualMonth, actualYear);

return total;
}

/**
*Description this method add medicaments to the pet
*@param medicamentForVeterinary String name of the medicament
*@param doseForVeterinary double dose of the medicament
*@param costForVeterinary double cost of the medicament
*@param frecForVeterinary int frecuency of the medicament
*@return String the medicaments added
*/
public String addMedicamentsToPet(String medicamentForVeterinary, double doseForVeterinary, double costForVeterinary, int frecForVeterinary){

String msj = "Se agrego";

msj += petRoom.addPetToHistoryCLinical(medicamentForVeterinary,doseForVeterinary,costForVeterinary,frecForVeterinary);

return msj;


}

/**
*Description this method notes to the pet
*@param notes String the notes
*/
public void addNotesToPet(String notes){

  petRoom.addNotesToHospitalizationFatality(notes);
}

/**
*Description this method add symptom to the clinic history
*@param symptomPet String new symptom
*/
public void addNotesToSympTom(String symptomPet){

  petRoom.addNewSymptomHistory(symptomPet);

}

}
