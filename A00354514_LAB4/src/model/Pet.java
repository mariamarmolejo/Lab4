package model;
import java.util.ArrayList;

public class Pet{

//Constant

public final static String DOG = "Perro";
public final static String CAT = "Gato";
public final static String BIRD = "Ave";
public final static String OTHER = "Otro";

//Atributes
private String namePet;
private int ageOfPet;
private String typeOfPet;
private double weightPet;
private double heightPet;

//Relations
private ArrayList<ClinicalHistory> clientWithHisto;
private Client cli1;

//Constructor
/**
*Description this constructor initialize the variables
*@param namePet String the name of the pet
*@param ageOfPet int the age of the pet
*@param typeOfPet String type of pet
*@param weightPet double weigth of pet
*@param heightPet double heigth of pet
*@param cli1 Client client that have the pet
*/
public Pet(String namePet , int ageOfPet , String typeOfPet, double weightPet,double heightPet,Client cli1){
		this.namePet = namePet;
		this.ageOfPet = ageOfPet;
		this.typeOfPet = typeOfPet;
		this.weightPet = weightPet;
		this.heightPet = heightPet;
		this.cli1 = cli1;
		clientWithHisto = new ArrayList<ClinicalHistory>();
	}

/**
*Description this method get the name of the pet
*@return String the name of the pet
*/
public String getNamePet(){
		return namePet;
}

/**
*Description this method set the name of the pet
*@param namePet String the name of the pet
*/
public void setNamePet(String namePet){
	this.namePet = namePet;
}

/**
*Description this method get the age of the pet
*@return int the age of the pet
*/
public int getAgeOfPet(){
	return ageOfPet;
}

/**
*Description this method set the age of the pet
*@param ageOfPet int the age of the pet
*/
public void setAgeOfPet(int ageOfPet){
	this.ageOfPet = ageOfPet;
}

/**
*Description this method get the type of pet
*@return String the type of pet
*/
public String getTypeOfPet(){
	return typeOfPet;
}

/**
*Description this method set the type of pet
*@param typeOfPet String the type of pet
*/
public void setTypeOfPet(String typeOfPet){
	this.typeOfPet = typeOfPet;
}

/**
*Description this method get the weigth of the pet
*@return double the weigth of the pet
*/
public double getWeightPet(){
	return weightPet;
}

/**
*Description this method set the weigth of the pet
*@param weightPet double the weigth of the pet
*/
public void setWeightPet(double weightPet){
	this.weightPet = weightPet;
}

/**
*Description this method get the client of the pet
*@return Client the client of the pet
*/
public Client getCli1(){
	return cli1;
}

/**
*Description this method set the client of the pet
*@param cli1 the client of the pet
*/
public void setCli1(Client cli1){
	this.cli1 = cli1;
}

/**
*Description this method get the arraylist of clinical history of the pet
*@return ArrayList the arraylist of clinical history of the pet
*/
public ArrayList<ClinicalHistory> getClientWithHisto(){
 return clientWithHisto;
}

/**
*Description this method set the arraylist of clinical history of the pet
*@param clientWithHisto ArrayList arraylist of clinical history
*/
public void setClientWithHisto(ArrayList<ClinicalHistory> clientWithHisto){
 this.clientWithHisto = clientWithHisto;
}

/**
*Description this method set the clinical history of the pet
*@param clientWithHisto ArrayList arraylist of clinical history
*/
public void setPets(ArrayList<ClinicalHistory> clientWithHisto){
 this.clientWithHisto = clientWithHisto;
}

/**
*Description this method show the information of the pet
*@return String the information of the pet
*/
public String showInfoPet(){
 String msj = "";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj += "El name es:" + namePet + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj += "Su edad es:" + ageOfPet + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj += "Mi peso es:" + weightPet + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj +="Mi tipo es:" + typeOfPet + "\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
 msj += "Mi IMB es:" + calculateIBMOfAnimal() +"\n";
 msj += "---------------------------------------------------------------------------------------------------------------------------- \n";

	return msj;

}

/**
*Description This method allows to add new medicines that were prescription during the hospitalization at the patient stories.
*pre: The patient clinic story must be not null.
*post: New medicines were added to the patient clinic story.
*@param medicamentForVeterinary String The medicine name. This param must be not null.
*@param doseForVeterinary double The medicine dose, this param refers to the amount of medicine supplied to the pet each time according the frequence assigned. This param must be not null.
*@param costForVeterinary double The medicine cost by each dose. This param could be empty.
*@param frecForVeterinary int The frequency of medicine application. This param could be empty.
*@return A message that indiques if medicine was added to the patient clinic story
*/
public String addPetToHistoryCLinical(String medicamentForVeterinary, double doseForVeterinary, double costForVeterinary, int frecForVeterinary){
String msj = "";

Medicament m = new Medicament(medicamentForVeterinary,doseForVeterinary,costForVeterinary,frecForVeterinary);
clientWithHisto.get((clientWithHisto.size()-1)).addMedicaments(m);

msj = "Se agrego";

return msj;


}

/**
*Description This method allows to calculate the body mass index for a pet.
*pre: The pet was created before and its attributes height and weight are not null neither height must be zero.
*post: The BMI is calculated.
*@return double turn The pet body mass index.
*/

public double calculateIBMOfAnimal(){

return weightPet/(heightPet * heightPet);

}


/**
*Description this method add the clinical history and medicaments
*@param newMedRec ClinicalHistory the clinical history
*@param medic Medicament the medicaments
*/
public void addMedRec(ClinicalHistory newMedRec, Medicament medic){

	newMedRec.setPetInfo(showInfoPet());
	clientWithHisto.add(newMedRec);

	clientWithHisto.get((clientWithHisto.size()-1)).addMedicaments(medic);

}

/**
*Description this method calculate the cost of hospitalization
*@param typeAnimal String type of the animal
*@param weight double weigth of the pet
*@param actualDay int actual day
*@param actualMonth int actual month
*@param actualYear int actual year
*@return double the cost of the hospitalization
*/
public double costOfHospitalizate(String typeAnimal, double weight,int actualDay, int actualMonth, int actualYear){

double total = 0.0;

for(int i = 0; i < clientWithHisto.size(); i++){
	int diasPreciso = clientWithHisto.get(i).daysInHospitalization(actualDay, actualMonth, actualYear);
	double medicamentCost = clientWithHisto.get(i).medicamentCosts();

if(typeAnimal.equals(CAT)){
	if(weight >= 1.0 && 3.0 <= weight){
		total += (double) (diasPreciso * 10000)+ medicamentCost;
	}else if(weight >= 3.1 && 10.0 <= weight){
		total += (double) (diasPreciso* 12000)+ medicamentCost;
	}else if(weight >= 10.1 && 20.0 <= weight){
		total += (double) (diasPreciso * 15000)+ medicamentCost;
 }else if(weight > 20.0 ){
	 total +=(double) (diasPreciso * 20000)+ medicamentCost;
 }
} else if(typeAnimal.equals(DOG)){
	if(weight>= 1.0 && 3.0 <= weight){
		total += (double) (diasPreciso * 15000)+ medicamentCost;
	}else if(weight >= 3.1 && 10.0 <= weight){
		total += (double)(diasPreciso * 17000)+ medicamentCost;
	}else if(weight >= 10.1 && 20.0 <= weight){
		total += (double) (diasPreciso * 20000)+ medicamentCost;
 }else if(weight > 20.0 ){
	 total += (double) (diasPreciso * 25000)+ medicamentCost;
 }

}else if(typeAnimal.equals(BIRD)){
	if( weight >= 1.0 && 3.0 <= weight){
		total += (double) (diasPreciso * 10000)+ medicamentCost;
	}else if(weight >= 3.1 && 10.0 <= weight){
		total +=(double)  (diasPreciso * 12000)+ medicamentCost;
	}else if(weight >= 10.1 && 20.0 <= weight){
		total += (double) (diasPreciso * 20000)+ medicamentCost;
 }else if(weight > 20.0 ){
	 total +=(double) (diasPreciso * 25000)+ medicamentCost;
 }

}else if(typeAnimal.equals(OTHER)){
	if( weight >= 1.0 && 3.0 <= weight){
		total += (double)  (diasPreciso * 10000)+ medicamentCost;
	}else if(weight >= 3.1 && 10.0 <= weight){
		total += (double) (diasPreciso * 17000)+ medicamentCost;
	}else if(weight >= 10.1 && 20.0 <= weight){
		total += (double) (diasPreciso * 30000)+ medicamentCost;
 }else if(weight > 20.0 ){
	 total += (double) (diasPreciso * 30000)+ medicamentCost;
  }

 }
}
return total;

}

/**
*Description this method show the information of the hospitalization
*@return String the information of the hospitalization
*/
public String showHospitalization(){
String msj = "";
int k =0;

for(int i= 0; i < clientWithHisto.size(); i++){
++k;
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "El name es:" + namePet + "\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "Su edad es:" + ageOfPet + "\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "Mi peso es:" + weightPet + "\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj +="Mi tipo es" + typeOfPet + "\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "Mi IMB es:" + calculateIBMOfAnimal() +"\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "Histo" + k + "";
msj += clientWithHisto.get(i).infoAnimalHistory();
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
}
 return msj;


}

/**
*Description this method shows the information of the pet in hospitalization
*@return String the information of the pet in hospitalization
*/
public String showInfoPetHospit(){
String msj = "";

for(int k = 0; k  < clientWithHisto.size(); k++){

msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "El name es:" + namePet + "\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "Su edad es:" + ageOfPet + "\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "Mi peso es:" + weightPet + "\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj +="Mi tipo es:" + typeOfPet + "\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "Mi IMB es:" + calculateIBMOfAnimal() +"\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "El animal es:" + clientWithHisto.get(k).infoAnimalHistoryHospi() +"\n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";
msj += "---------------------------------------------------------------------------------------------------------------------------- \n";

	}
	 return msj;
}

/**
*Description this method add notes to the hospitalization
*@param notes String notes
*/
public void addNotesToHospitalizationFatality(String notes){

clientWithHisto.get((clientWithHisto.size()-1 )).addNotes(notes);

}

/**
*Description this method add the new symptom of the hospitalization
*@param symptomPet String the symptom of the pet
*/
public void addNewSymptomHistory(String symptomPet){

clientWithHisto.get((clientWithHisto.size()-1)).addNewSymptomFinally(symptomPet);

}



}
