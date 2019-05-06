package model;
import java.util.ArrayList;

public class Client{

//Atributes
private String nameClient;
private int identify;
private String address;
private String cellPhone;

//Relations
private ArrayList<Pet> pets;

/**
*Description this constructor initialize the variables
*@param nameClient String name of the client
*@param identify int id of the client
*@param address String addres of the client
*@param cellPhone String phone of the client
*/
public Client(String nameClient,int identify, String address , String cellPhone){

this.nameClient = nameClient;
this.identify = identify;
this.address= address;
this.cellPhone = cellPhone;
pets = new ArrayList<Pet>();

}

/**
*Description this method get the name of the client
*@return String the name of the client
*/
public String getNameClient(){
		return nameClient;
}

/**
*Description this method set the name of the client
*@param nameClient String the name of the client
*/
public void setNameClient(String nameClient){
this.nameClient = nameClient;
}

/**
*Description this method get the id of the client
*@return int the id of the client
*/
public int getIdentify(){

		return identify;
	}

/**
*Description this method set the id of the client
*@param identify int the id of the client
*/
public void setIdentify(int identify){
	this.identify = identify;
	}

/**
*Description this method get the address of the client
*@return String  the address of the client
*/
public String getAddress(){

	return address;

}

/**
*Description this method set the address of the client
*@param address String the address of the client
*/
public void setAddress(String address){

	this.address = address;

}

/**
*Description this method get the cellphone of the client
*@return String the cellphone of the client
*/
public String getCellPhone(){
return cellPhone;
}

/**
*Description this method set the cellphone of the client
*@param cellPhone String the cellphone of the client
*/
public void setCellPhone(String cellPhone){

this.cellPhone = cellPhone;

}

/**
*Description this method get the arraylist of the pets
*@return ArrayList arraylist of the pets
*/
public ArrayList<Pet> getPets(){
	 return pets;
 }

/**
*Description this method set the number of the room
*@param pets ArrayList number of the room
*/
public void setPets(ArrayList<Pet> pets){
	 this.pets = pets;
 }

/**
*Descriptioneste this method add the arraylist of pets
*@param clientsPets ArrayList new arraylist of pets
*/
public void addPet(ArrayList<Pet> clientsPets){
pets = clientsPets;
 }

 /**
**Description this method show the information of the client
*@return String information of the client
 */
public String infoClient(){
String msj = "";
msj += "----------------------------------------------------------------------------------------------------------------------------  \n";
msj += "Mi nombre es:" + nameClient + "\n";
msj += "----------------------------------------------------------------------------------------------------------------------------  \n";
msj += "Mi identificacion es:" + identify+ "\n";
msj += "----------------------------------------------------------------------------------------------------------------------------  \n";
msj += "Mi direccion es:" + address + "\n";
msj += "----------------------------------------------------------------------------------------------------------------------------- \n";
msj += "Mi numero es:" + cellPhone + "\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";

int j = 0;
for(int i = 0; i<pets.size(); i++){
	++j;
msj += "Pet"+ j + "";
msj += pets.get(i).showInfoPet();
}
return msj;
}

/**
*Description this method find the pet
*@param petName String name of the pet
*@return String the pet founded
*/
public Pet findPet(String petName){

	Pet pp = null;
	boolean found = false;

	for(int i = 0; i<pets.size() && !found; i++){

		if(pets.get(i).getNamePet().equals(petName)){
			pp = pets.get(i);
			found = true;
		}

	}

	return pp;
}

/**
*Description this method denotes if a pet can be hospitalizated
*@param namePe String name of the pet
*@param newMedRec ClinicalHistory clinical history of the pet
*@param medic Medicament medicament
*/
public void startHospita(String namePe, ClinicalHistory newMedRec, Medicament medic){
boolean petts = false;

for(int i = 0; i < pets.size() && !petts; i++)
if(pets.get(i).getNamePet().equals(namePe)){
  petts = true;

	pets.get(i).addMedRec(newMedRec,medic);

	}
}

/**
*Descriptionthis method shows information of the hospitalization
*@return String information of the hospitalization
*/
public String showInfoHospi(){
String msj = "";

for(int i = 0; i < pets.size(); i++){

msj += pets.get(i).showHospitalization();

}

return msj;

}


}
