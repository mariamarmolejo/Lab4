
package model;

import java.util.ArrayList;

public class Veterinary{

//COnstantes

public static final int NUMBEROFROOM = 8 ;

//Atributes

private String name;

//Relation
private Room[] miniRoom;
private ArrayList<Client> clients;
private ArrayList<TypeOfService> typeOfServiceVeterinary;

/**
* Description This constructor let to initializaze the variables
* @param name String name of the veterinary
*/
public Veterinary(String name){
this.name = name;
miniRoom = new Room[NUMBEROFROOM];
clients = new ArrayList<Client>();
typeOfServiceVeterinary = new ArrayList<TypeOfService>();

}

/**
* Description this method get the name of the veterinary
* @return String return the name of the veterinary
*/
public String getName(){
return name;
}

/**
* Description this method set the name of the veterinary
* @param name String name of the veterinary
*/
public void setName(String name){
this.name = name;
}

/**
*Description this method get the minirooms
*@return miniRoom return the miniroom
*/
public Room[] getMiniRoom(){
  return miniRoom;
}

/**
* Description this method set the minirooms
* @param miniRoom Room the miniroom
*/
public void setMiniRoom( Room[] miniRoom){
  this.miniRoom = miniRoom;
}

/**
* Description this method get the arraylist clients
* @return ArrayList Client return clients
*/
public ArrayList<Client> getClients(){
  return clients;
}

/**
*Description this method set the arraylist clients
*@param clients ArrayList the arraylist of clientes
*/
public void setClients( ArrayList<Client> clients){
  this.clients = clients;
}

/**
*Description this method get the type of service
*@return ArrayList the type of service
*/
public ArrayList<TypeOfService> gettypeOfServiceVeterinary(){
		return typeOfServiceVeterinary;
	}

/**
*Description this method make the type of service
*@param typeOfServiceVeterinary ArrayList type of service
**/
public void setTypeOfServiceVeterinary(ArrayList<TypeOfService> typeOfServiceVeterinary){
		this.typeOfServiceVeterinary = typeOfServiceVeterinary;
	}

/**
*Description this method add the type of service
*@param m typeOfService the type of service
*@param p Pet the pet
*/
public void addServiceWithPet(TypeOfService m , Pet p){

typeOfServiceVeterinary.add(m);
typeOfServiceVeterinary.get((typeOfServiceVeterinary.size()-1)).setPetsWithTypeOfService(p);
}

/**
*Description this method create the minirooms
*@param miniRoom1  Room minicuarto 1
*@param miniRoom2  Room minicuarto 2
*@param miniRoom3  Room minicuarto 3
*@param miniRoom4  Room minicuarto 4
*@param miniRoom5  Room minicuarto 5
*@param miniRoom6  Room minicuarto 6
*@param miniRoom7  Room minicuarto 7
*@param miniRoom8  Room minicuarto 8
*/
public void addMiniRoom(Room miniRoom1, Room miniRoom2,Room miniRoom3 , Room miniRoom4, Room miniRoom5, Room miniRoom6,Room miniRoom7,Room miniRoom8){
  miniRoom[0] = miniRoom1;
  miniRoom[1] = miniRoom2;
  miniRoom[2] = miniRoom3;
  miniRoom[3] = miniRoom4;
  miniRoom[4] = miniRoom5;
  miniRoom[5] = miniRoom6;
  miniRoom[6] = miniRoom7;
  miniRoom[7] = miniRoom8;
}

/**
*Description this method evaluates if exists the same clients
*pre: clients != null
*@param client Client the client
*@return String if the client is unique
*/
public String addClient2(Client client){
 String msj = "Se guardo exitosamente el cliente";
 boolean decide = true;
 int acum = 0;
for(int c = 0; c< clients.size() && decide == true; c++){
  if(client == clients.get(c)){
    msj = "no pueden haber dos clientes repetidos";
    decide = false;
  }else{
    acum++;
  }
}
if(acum == clients.size()){
  clients.add(client);
}

return msj;
}

/**
*Description This method allows to update the basic data of a veterinary client, these data include, address and phone number.
*pre: The client was created before.
*post: The address and /or phone number of the client is updated.
*@param addresClientToVeterinary int The new address of the client. This param could be empty.
*@param phoneClientToVeterinary String The new phone number of the client. This param could be empty.
*@param idClientToVeterinary the identify client
*@return String un mensaje
*/

public String actualizePhoneAndAddressOfCLient(int idClientToVeterinary , String addresClientToVeterinary , String phoneClientToVeterinary){

   String msj = "No se pudo actualizar porque no existe o no se encontro";
boolean f = false;

for(int o = 0; o < clients.size() && !f; o++){
  Client k = clients.get(o);
if(idClientToVeterinary == k.getIdentify()){

  k.setAddress(addresClientToVeterinary);
  k.setCellPhone(phoneClientToVeterinary);
  f = true;

  }
}

    if(f){
      msj = "Se actualizo su identidad del cliente";
    }

return msj;
}


/**
*Description this method add a client with their pets
*@param client Client the client
*@param clientsPets ArrayList arraylist of pets of the client
*/
public void addClient(Client client, ArrayList<Pet> clientsPets){

  clients.add(client);
  clients.get((clients.size()-1)).addPet(clientsPets);

}

/**
*Description this method evaluates if a pet can be added to a miniroom
*pre: minirooms !=null
*@param current Pet the pet to be evaluated
*@return String if can be added or not
*/
  public String addPetToAvailableRoom (Pet current){

    String msg = "";
    boolean found = false;

    for(int i =0; i< miniRoom.length && !found; i++){

      if(miniRoom[i].getAvaible()){
        found = true;
        miniRoom[i].setPetRoom(current);
        miniRoom[i].setAvaible(false);

        msg = "Se agrego exitosamente a "+current.getNamePet()+" en el cuarto " + (i+1);
      }
    }
    if(!found){
      msg = "No se pudo hospitalizar porque no se encontro un cuarto vacio.";
    }

    return msg;
  }
/**
*Description this method show the information of the clients
*pre: clients != null
*@return String  information of the clients
*/
public String showClients(){
  String msj = "";
  msj += clients.size();
   for(int i = 0 ; i<clients.size(); i++){
     msj +=  (i+1) + clients.get(i).infoClient();
  }
  return msj;

}
/**
*Description this method evaluates if a pet can be hospitalize
*pre: clients != null
*@param petName String id of client
*@param clientId int name of pet
*@return hospitalize the pet
*/
public String hospitalize(int clientId, String petName){

  String msg = "";
  Pet p = null;
  for(int i =0; i<clients.size() && p==null; i++){
    if(clients.get(i).getIdentify() == clientId){
        p = clients.get(i).findPet(petName);
        if(p==null){
          msg = "El cliente no tiene una mascota con ese nombre";
        }
    }
  }
 if(p!=null){
  msg = addPetToAvailableRoom(p);
 }

  return msg;
}
/**
*Description this method show th information of the client
*@param id int client id
*@return String information of the client
*/
  public String infoPet1(int id){
  String msj = "";
  boolean  race = false;

   for(int i = 0 ; i<clients.size() && !race; i++){
    if(id == clients.get(i).getIdentify()){

     msj = i + clients.get(i).infoClient();
     race = true;

   }else {
     msj = "No se contro un usario con ese id";
   }


    }
      return msj;
  }

/**
*Description this method show the information of the room
*pre: minirooms != null
*post: message if cqan be showed
*@return String un mensaje
*/
public String showRoom(){
String msj = "";

for(int i = 0 ; i < miniRoom.length; i++){
if(miniRoom[i] !=null){
 msj += miniRoom[i].showInfoRoomPetHospit();
}else {
  msj += "No se encontro ningun cuarto";
}

}
    return msj;
}

/**
*Description this method finish the hospitaliza of a pet in a miniroom
*pre: el minicuarto != null
*post: get out the pet of the miniroom
*@param petNames Pet name of the pet
*@return String message if the pet is out
*/
public String darAlta(Pet petNames){
 boolean recorrido = false;
 String msj = "";
    for(int i = 0; i < miniRoom.length && !recorrido; i++){
      if(!miniRoom[i].getAvaible()){
        if(miniRoom[i].getPetRoom().equals(petNames)){
          miniRoom[i].setPetRoom(null);
          recorrido= true;
          miniRoom[i].setAvaible(true);
          msj = "Se saco el animalito del cuarto";
        }
      }else{
        msj = "No se encontro su animal hospitalizado";
      }
    }
    return msj;
  }

/**
*Description this method find a pet and his client
*pre: clientes != null
*@param nameClie String name of the client
*@param idClie int id of the client
*@param namePe String name of the pet
*@return the pet if was founded
*/
public Pet findPett(String nameClie, int idClie, String  namePe){

		boolean theStop = false;
    Pet relationshipOfPet = null;

		for(int i= 0;i < clients.size() && !theStop;i++){
			if (!clients.get(i).getNameClient().equals(nameClie) && clients.get(i).getIdentify() == idClie){
        relationshipOfPet = clients.get(i).findPet(namePe);

				theStop = true;
			}
		}

		return relationshipOfPet;

	}
/**
*Description this method hospitalize a pet
*@param nameClie String name of the client
*@param idClie int id of the client
*@param namePe String name of the pet
*@param newMedRec ClinicalHistory the clinical history of the pet
*@param medic Medicament the medicament of the pet
*/
		public void hospitalizeVet(String nameClie, int idClie , String namePe, ClinicalHistory newMedRec, Medicament medic){
		boolean theStop = false;

		for(int i = 0;i < clients.size() && !theStop;i++){
			if(clients.get(i).getNameClient().equals(nameClie) && clients.get(i).getIdentify() == idClie){

				theStop = true;
				clients.get(i).startHospita(namePe, newMedRec, medic);


			}else{
        Pet petRelation = clients.get(i).findPet(namePe);

      }

		}
	}
/**
*Description this method show the clinic histories
*pre: ClinicalHistory != null
*pre: Client != null
*@return show the clinic histories
*/
public String showClinicalHistories(){

String clinical = "";


for(int i = 0; i < clients.size(); i++){

  clinical += clients.get(i).showInfoHospi();

  }
  return clinical;
}
/**
* Description this method search if a pet can be hospitalizated
* pre: clientes != null
* pre: pets != null
* @param idClientt int the id of a client
* @param  nampe String name of pet
* @return String message if can o not be hospitalizated
*/
public String findToHospitalize(int idClientt, String nampe){
  String msg = "";
  Pet p = null;
  for(int i =0; i<clients.size() && p==null; i++){
    if(idClientt == clients.get(i).getIdentify()){
        p = clients.get(i).findPet(nampe);
        if(p==null){
          msg = "El cliente no tiene una mascota con ese nombre";
        }
      }
  }
 if(p!=null){
  msg = darAlta(p);
 }

  return msg;
}

/**
*Description this method looks the cost of the hospitalization
*@param typeAnimal String type of pet
*@param weight double weigth of pet
*@param actualDay int  actual day
*@param actualMonth int actual month
*@param actualYear int actual year
*@return cost of the hospitalization
*/
public String costOfhospis(String typeAnimal, double weight,int actualDay, int actualMonth, int actualYear){
String msj = "";

for(int i = 0; i < miniRoom.length ;i++){

msj = miniRoom[i].costOfhospi(typeAnimal, weight, actualDay, actualMonth, actualMonth);

}

return msj;

}

/**
*Description This method allows to add new medicines that were prescription during the hospitalization at the patient stories.
*pre: The patient clinic story must be not null.
*post: New medicines were added to the patient clinic story.
*@param clientForVeterinary int the identify of client
*@param namePetLupe String the namePet
*@param medicamentForVeterinary String The medicine name. This param must be not null.
*@param doseForVeterinary double  The medicine dose, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned. This param must be not null.
*@param costForVeterinary double  The medicine cost by each dose. This param could be empty.
*@param frecForVeterinary int  The frequency of medicine application. This param could be empty.
*@return String  A message that indiques if medicine was added to the patient clinic story
*/

public String addMediceToHospitalization(int clientForVeterinary,String namePetLupe,String medicamentForVeterinary, double doseForVeterinary, double  costForVeterinary, int frecForVeterinary){
String msj = "";
boolean f = false;
for(int i = 0; i < miniRoom.length && !f; i++){
  if(miniRoom[i] != null){
    if(miniRoom[i].getPetRoom().getCli1().getIdentify() == clientForVeterinary){
    if(miniRoom[i].getPetRoom().getNamePet().equals(namePetLupe)){
      msj = "Se agrego el medicamento" + miniRoom[i].addMedicamentsToPet(medicamentForVeterinary,doseForVeterinary,costForVeterinary,frecForVeterinary);
      f = true;
    }
  }
}
}
return msj;
}

/**
*Description This method allows to add new notes to the possible diagnostic during the hospitalization at the patient stories.
*pre: The patient clinic story must be not null.
*post: New notes were added to the possible diagnostic in the patient clinic story.
*@param notes String The notes of possible diagnostic. This param must be not null.
*@param clientIdentify int the identify client
*@param nameClientPe String the name of the pet
*/

public void addNotesToHospitalization(int clientIdentify, String nameClientPe, String notes){

boolean perro = false;

for(int i = 0; i < miniRoom.length && perro == false; i++){
  if(miniRoom[i] != null){
    if(miniRoom[i].getPetRoom().getCli1().getIdentify() == clientIdentify){
    if(miniRoom[i].getPetRoom().getNamePet().equals(nameClientPe)){
      miniRoom[i].addNotesToPet(notes);
      perro = true;
    }
    }
  }
  }
}

/**
*Description This method allows to add a new symptom presented during the hospitalization at the patient stories.
*pre: The patient clinic story must be not null.
*post: A new symptom were added to the patient clinic story.
*@param symptomPet String The new symptom presented. This param must be not null.
*@param clientToPet String the name of client  
*@param petNameToPet String the name of Pet
*/

public void addNewSymptom(int clientToPet, String petNameToPet,String symptomPet){

boolean stop = false;
for(int i = 0; i < miniRoom.length && !stop ; i++){
  if(miniRoom[i] != null){
    if(miniRoom[i].getPetRoom().getCli1().getIdentify() == clientToPet){
    if(miniRoom[i].getPetRoom().getNamePet().equals(petNameToPet)){
      miniRoom[i].addNotesToSympTom(symptomPet);
      stop = true;
  }
}
}
}
}

/**
*Description this method calculate the 1 service
*pre: tipoDeServicio !=null
*post: the cost of the service 1
*@return int cost of the service
*/
public double calculatedService1(){
  double m = 0.0;

for(int k = 0; k < typeOfServiceVeterinary.size(); k++){
TypeOfService services = typeOfServiceVeterinary.get(k);

if(services.getService().equals(TypeOfService.service1)){
  m += TypeOfService.washPets;
}

}
return m;
}

/**
*Description this method calculate the 2 service
*pre: tipoDeServicio !=null
*post: the cost of the service 2
*@return int cost of the service
*/
public double calculatedService2(){
double m = 0.0;

for(int k = 0; k < typeOfServiceVeterinary.size(); k++){
TypeOfService services = typeOfServiceVeterinary.get(k);

if(services.getService().equals(TypeOfService.service2)){
  m += TypeOfService.washPetsDelivery;
}
}
  return m;
}
/**
*Description this method calculate the 3 service
*pre: tipoDeServicio !=null
*post: the cost of the service 3
*@return int cost of the service
*/
public double calculatedService3(){
double m = 0.0;

for(int k = 0; k < typeOfServiceVeterinary.size();k++){
TypeOfService services = typeOfServiceVeterinary.get(k);

if(services.getService().equals(TypeOfService.service3)){
m += TypeOfService.cutNails;
}

}
return m;
}
/**
*Description this method calculate the 4 service
*pre: tipoDeServicio !=null
*post: the cost of the service 4
*@return int cost of the service
*/
public double calculatedService4(){
double m = 0.0;

for(int k = 0; k < typeOfServiceVeterinary.size(); k++){
  TypeOfService services = typeOfServiceVeterinary.get(k);
  if(services.getService().equals(TypeOfService.service4)){
    m += TypeOfService.dentistProfi;
  }
}

return m;
}

/**
*Description this method calculate the 5 service
*pre: tipoDeServicio !=null
*post: the cost of the service 5
*@return int cost of the service
*/
public double calculatedService5(){
double m = 0.0;

for(int k = 0; k < typeOfServiceVeterinary.size(); k++){
TypeOfService services = typeOfServiceVeterinary.get(k);

if(services.getService().equals(TypeOfService.service5)){
  m += TypeOfService.vacunnesAplication;
}
}
  return m;
}

/**
* Description this method calculate how many times appareance the 1 service
*pre: tipoDeServicio !=null
*post: times that a 1 service appareance
*@return int times that a service appareance
*/
public int calculatedCostForServiceAparrance(){
	int k  = 0;

for(int i = 0; i < typeOfServiceVeterinary.size(); i++){
TypeOfService services = typeOfServiceVeterinary.get(k);
	if(services.getService().equals(TypeOfService.service1)){
			k++;
	}
}
return k;
}

/**
* Description this method calculate how many times appareance the 2 service
*pre: tipoDeServicio !=null
*post: times that a 2 service appareance
*@return int times that a service appareance
*/
public int calculatedCosForServicesAparrance2(){
int k = 0;

for(int i = 0; i < typeOfServiceVeterinary.size(); i++){
TypeOfService services = typeOfServiceVeterinary.get(k);
	if(services.getService().equals(TypeOfService.service2)){
			k++;
	}
}
return k;
}

/**
* Description this method calculate how many times appareance the 3 service
*pre: tipoDeServicio !=null
*post: times that a 3 service appareance
*@return int times that a service appareance
*/
public int calculatedCosForServicesAparrance3(){
int k= 0;

for(int i = 0; i < typeOfServiceVeterinary.size(); i++){
TypeOfService services = typeOfServiceVeterinary.get(k);
  if(services.getService().equals(TypeOfService.service3)){
  			k++;
  	}
  }
  return k;
}

/**
/**
* Description this method calculate how many times appareance the 4 service
*pre: tipoDeServicio !=null
*post: times that a 4 service appareance
*@return int times that a service appareance
*/
public int calculatedCosForServicesAparrance4(){

int k = 0;

for(int i = 0; i < typeOfServiceVeterinary.size(); i++){
TypeOfService services = typeOfServiceVeterinary.get(k);
  if(services.getService().equals(TypeOfService.service4)){
  			k++;
  	}
  }
  return k;
}

/**
* Description this method calculate how many times appareance the 5 service
*pre: tipoDeServicio !=null
*post: times that a 5 service appareance
*@return int times that a service appareance
*/
public int calculatedCosForServicesAparrance5(){
int k =0;

for(int i = 0; i < typeOfServiceVeterinary.size(); i++){
TypeOfService services = typeOfServiceVeterinary.get(k);
  if(services.getService().equals(TypeOfService.service5)){
  			k++;
  	}
  }
  return k;
}



/**
*Description this method calculate the promvalue of all services
*@return double the promvalue of all services
*/
public double promediateCostOfServices(){
double costTotal = 0.0;

costTotal += (calculatedService1() + calculatedService2() + calculatedService3() + calculatedService4() + calculatedService5())/(calculatedCostForServiceAparrance()+calculatedCosForServicesAparrance2()+calculatedCosForServicesAparrance3()+calculatedCosForServicesAparrance4()+calculatedCosForServicesAparrance5());

return costTotal;

}

/**
* Description this method calculate the value of all services
* @return double the value of all services
*/
public double calculatedCostTotalForTheService(){
double m = 0.0;

m += (calculatedService1() + calculatedService2() + calculatedService3() + calculatedService4() + calculatedService5());

return m;

}
/**
*Description this method generate a report about the information that is avalibale at that dates
*pre: have to be on AAAA-MM-DD
*@param inicialDate String initial date
*@param finalDate String final date
*@return the service that was presented in those dates
*/
public String getReportedAboutAnimalWithInicialDateAndFinalDate(String inicialDate,String finalDate){
String msj = "";

for(int i = 0; i < typeOfServiceVeterinary.size();i++){

TypeOfService sd1 = typeOfServiceVeterinary.get(i);

if(inicialDate.compareTo(sd1.getDateThatItDoIt()) <= 0 && sd1.getDateThatItDoIt().compareTo(finalDate) <= 0){

  msj = "La siguiente informacion es:" + "\n" +sd1.serviceInformation();

}else{
  msj = "No se encontro la fecha o ingreso una fecha que no es o una equivocada";
}


}

return msj;

}

/**
* Description this method calculate de costs for a week
* @param dayActual int el dia actual
* @param monthActual int actual month
* @param actualYear int actual year
* @return price for a week
*/
public double calculatedCostForOneWeek(int dayActual, int monthActual, int actualYear){

double promediateWeek = 0.0;
int fechaActual = (dayActual + 7);

if(fechaActual > 30){
   promediateWeek = calculatedCostTotalForTheService()/(fechaActual % 30);
}else if(fechaActual < 30){
   promediateWeek = calculatedCostTotalForTheService()/fechaActual;
}


return promediateWeek;


}

}
