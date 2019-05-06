package model;

import java.util.ArrayList;

public class TypeOfService{
//Constant
public final static String service1 = "Lavado de perros";
public final static String service2 = "Lavado de mascotas a domicilio";
public final static String service3 = "corte de uñas";
public final static String service4 = "Profilaxia dental";
public final static String service5 = "Aplicacion de vacunas";

public final static double washPets = 20000;
public final static double washPetsDelivery = 30000;
public final static double cutNails = 8000;
public final static double dentistProfi = 12000;
public final static double vacunnesAplication = 45000;

//Atributes
private String service;
private double cost;
private String dateThatItDoIt;
private int identifyPetId;
private int identifyClientId;

//Relation
private Pet petsWithTypeOfService;

/**
 *Description this constructor initializate the variables
*@param service String the service
*@param cost double cost of the service
*@param dateThatItDoIt String date in was made
*@param identifyPetId int id of the pet
*@param identifyClientId int id of the client
*@param petsWithTypeOfService Pet the pet
*/
public TypeOfService(String service, double cost ,String dateThatItDoIt,int identifyPetId,int identifyClientId, Pet petsWithTypeOfService){

this.service = service;
this.cost = cost;
this.dateThatItDoIt = dateThatItDoIt;
this.identifyPetId = identifyPetId;
this.identifyClientId = identifyClientId;
this.petsWithTypeOfService = petsWithTypeOfService;


}

/**
*Description this method get the service
*@return String the service
*/
public String getService(){
  return service;
}
/**
*Description this method set the service
*@param service String el service
*/
public void setService(String service){
  this.service = service;
}
/**
*Description this method get the cost of the service
*@return double the cost of the service
*/
public double getCost(){
  return cost;
}
/**
*Description this method set the cost of the service
*@param cost double the cost of the service
*/
public void setCost(double cost){
  this.cost = cost;
}
/**
*Description this method get the date that th service was do it
*@return String the date that th service was do it
*/
public String getDateThatItDoIt(){
  return dateThatItDoIt;
}
/**
*Description this method set the date that th service was do it
*@param dateThatItDoIt String the date that th service was do it
*/
public void setDateThatItDoIt(String dateThatItDoIt){
  this.dateThatItDoIt = dateThatItDoIt;
}
/**
*Description this method get the id of the pet
*@return int la identificacion de la mascota
*/
public int getIdentifyPetId(){
  return identifyPetId;
}
/**
*Description this method set the id of the pet
*@param identifyPetId int the id of the pet
*/
public void setIdentifyPetId(int identifyPetId){
  this.identifyPetId = identifyPetId;
}
/**
*Description this method get the id of the client
*@return int  the id of the client
*/
public int getIdentifyClientId(){
  return identifyClientId;
}
/**
*Description this method set the id of the client
*@param identifyClientId int the id of the client
*/
public void setIdentifyClientId(int identifyClientId){
  this.identifyClientId = identifyClientId;
}
/**
*Description this method get the arraylist of the pets
*@return Pet the arraylist of the pets
*/
public Pet getPetsWithTypeOfService(){
  return petsWithTypeOfService;
}
/**
*Description this method set the of the arraylist of the pets
*@param petsWithTypeOfService Pet the arraylist of the pets
*/
public void setPetsWithTypeOfService(Pet petsWithTypeOfService){
	this.petsWithTypeOfService = petsWithTypeOfService;

}

/**
*Description this method get the information of the service
*@return String information of the service
*/
public String serviceInformation(){
String msj = "";

msj = "El servicio es:" + service;
msj = "Su costo es:" + cost;
msj = "Su fecha de entra es:" + dateThatItDoIt;
msj = "Su identificacion es:" + identifyPetId;
msj = "La cedula del cliente es:" + identifyClientId;

return msj;
}

}
