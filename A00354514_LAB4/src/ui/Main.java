package ui;

import model.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Main{

//Relaciones

private Veterinary principal;
private Scanner reader;


public Main(){
  init();
  reader = new Scanner(System.in);

}

public static void main(String[] args) {
  Main m = new Main();
  m.showMenu();

  }

  public void showMenu(){
        int userImput =0;
      System.out.println("=========================================");
      System.out.println("Bienvenido al software de la veterinaria");
      System.out.println("=========================================");
      System.out.println("1.Mostrar La Informacion Del Usuario");
      System.out.println("2.Registrarse Con Su Mascota");
      System.out.println("3.Mostrar Info Medica");
      System.out.println("4.Hospitalizar");
      System.out.println("5.Calcular Los Ingresos");
      System.out.println("6.Para Dar De Alta");
      System.out.println("7.Mostrar Info Clientes");
      System.out.println("8.Mostrar Info Minicuartos");
      System.out.println("9.Actualizar Direccion Y Numero");
      System.out.println("10.Agregar Medicina");
      System.out.println("11.Agregar Notas");
      System.out.println("12.Agregar Sintomas");
      System.out.println("13.Mostrar El Calculo De Los Ingresos");
      System.out.println("14.El Costo De Servicios Promediados");
      System.out.println("15.El Costo Total De Los Servicios");
      System.out.println("16.Ingresar Un Nuevo Servicio");
      System.out.println("17.Mostrar La Info Con Fecha Inicial Y La Final");
      System.out.println("18.Mostrar El Calculo De Una Semana");
      System.out.println("19.Salir");



        while(userImput != 19){
          userImput =reader.nextInt();
          reader.nextLine();
         if(userImput == 1){
           System.out.println("Digite su identificacion");
           int id = reader.nextInt();
           System.out.println(principal.infoPet1(id));

           principal.infoPet1(id);
         }else if(userImput == 2){
         System.out.println("Digite el nombre del usuario");
         String name = reader.nextLine();

         System.out.println("Digite su identificacion");
         int iden = reader.nextInt();
         reader.nextLine();

         System.out.println("Digite su dirección ");
         String address = reader.nextLine();

         System.out.println("Digite su celular");
         String phone = reader.nextLine();

         Client client = new Client(name,iden,address,phone);

         System.out.println("Digite el numero de mascotas que quiere tener");
         int numberOfUser = reader.nextInt();
         reader.nextLine();

         ArrayList<Pet> clientsPets = new ArrayList<Pet>();

         for(int i = 0; i < numberOfUser; i++){
         System.out.println("Digite el nombre de su mascota ");
         String nameP = reader.nextLine();

         System.out.println("Digite la edad de su mascota ");
         int ageOfM = reader.nextInt();
         reader.nextLine();

         System.out.println("Digite el tipo de su mascota ");

         System.out.println("Perro ");
         System.out.println("Gato ");
         System.out.println("Pajaro ");
         System.out.println("Otro ");

         String typeOfM = reader.nextLine();

         System.out.println("Digite el peso de su mascota ");

         double weightOfM = reader.nextDouble();
         reader.nextLine();

         System.out.println("Digite la altura de su mascota");

         double heightOfP = reader.nextDouble();
         reader.nextLine();

         Pet pet3 = new Pet(nameP, ageOfM, typeOfM, weightOfM,heightOfP,client);
         clientsPets.add(pet3);
         principal.addClient(client,clientsPets);
         System.out.println("Se ha añadido la mascota con exito");
       }
         
       } else if( userImput ==3){

         System.out.println(principal.showClinicalHistories());

        }else if(userImput == 4){
          System.out.println(principal.showClients());
          System.out.println("Ponga el id del cliente");
          int clientId = reader.nextInt();
          reader.nextLine();

          System.out.println("Ponga el nombre de la mascota");
          String petName = reader.nextLine();

          System.out.println("SOLO CREAR HISTORIAS CLINICAS DE PACIENTES HOSPITALIZADOS");

          System.out.println("Digite el dia de ingreso");
          int dai = reader.nextInt();
          reader.nextLine();

          System.out.println("Digite el mes de ingreso");
          int mon = reader.nextInt();
          reader.nextLine();

          System.out.println("Digite el año de ingreso ");
          int yea = reader.nextInt();
          reader.nextLine();

          HistorialDated dateIn = new HistorialDated(dai, mon, yea);

          System.out.println("Digite el dia de salida potencial");
          int dai2 = reader.nextInt();
          reader.nextLine();

          System.out.println("Digite el mes de salida potencial");
          int mon2 = reader.nextInt();
          reader.nextLine();

          System.out.println("Digite el año de salida potencial");
          int yea2 = reader.nextInt();
          reader.nextLine();

          HistorialDated dateOut = new HistorialDated(dai2, mon2, yea2);

          System.out.println("Digite el nombre del dueño ");
          String nameClie = reader.nextLine();

          System.out.println("Digite el id del cliente");
          int idClie = reader.nextInt();
          reader.nextLine();

          System.out.println("Digite el nombre completo de la mascota");
          String namePe = reader.nextLine();

          System.out.println("Digite el sintoma del animal");
          String symp = reader.nextLine();

          System.out.println("Digite el diagnostico ");
          String diag = reader.nextLine();

          System.out.println("Digite el estado");
          boolean stat = reader.nextBoolean();
          reader.nextLine();

          System.out.println("Digite el nombre del medicamento");
          String medi = reader.nextLine();

          System.out.println("Digite la dosis");
          double dos = reader.nextDouble();
          reader.nextLine();

          System.out.println("Digite la total de dosis");
          double totaldos = reader.nextDouble();
          reader.nextLine();

          System.out.println("Digite la frecuencia del medicamento");
          int frec = reader.nextInt();
          reader.nextLine();

          Pet pet2 = principal.findPett(nameClie, idClie, namePe);

          ClinicalHistory newMedRec = new ClinicalHistory( nameClie, namePe , symp, diag, stat, dateIn,dateOut, pet2);

          Medicament medics = new Medicament(medi, dos, totaldos, frec);

          principal.hospitalizeVet(nameClie,idClie,namePe, newMedRec, medics);

          System.out.println(principal.hospitalize(clientId, petName));

        }else if(userImput ==5){
           System.out.println("Digite el tipo de animal de su Mascota");
           System.out.println("Perro ");
           System.out.println("Gato ");
           System.out.println("Pajaro ");
           System.out.println("Otro ");
           String typeAnimal = reader.nextLine();

          System.out.println("Digite el peso de de su Mascota");
           double weight = reader.nextDouble();
           reader.nextLine();

           System.out.println("Por favor digite el dia actual");
           int actualDay = reader.nextInt();
           reader.nextLine();

           System.out.println("Por favor digite el mes actual");
           int actualMonth = reader.nextInt();
           reader.nextLine();

           System.out.println("Por favor digite el año actual");
           int actualYear = reader.nextInt();
           reader.nextLine();

           principal.costOfhospis(typeAnimal, weight,actualDay, actualMonth, actualYear);
           System.out.println(principal.costOfhospis(typeAnimal,weight,actualDay, actualMonth, actualYear));


        }else if(userImput ==6){
          System.out.println(principal.showClients());

          System.out.println("Por favor digite la identificacion del usuario para dar de alto a su animal");
          int idClientt = reader.nextInt();
          reader.nextLine();

          System.out.println("Por favor digite el nombre de la mascota para darlo de alto");
          String nampe = reader.nextLine();

          System.out.println("UNA VEZ REALIZADA ESTA ACCION, SE SACARA AL ANIMALITO DEL CUARTO");

          System.out.println("Digite el dia de ingreso");
          int dai = reader.nextInt();
          reader.nextLine();

          System.out.println("Digite el mes de ingreso");
          int mon = reader.nextInt();
          reader.nextLine();

          System.out.println("Digite el año de ingreso ");
          int yea = reader.nextInt();
          reader.nextLine();

          HistorialDated dateIn = new HistorialDated(dai, mon, yea);

          System.out.println("Digite el dia de salida");
          int dai2 = reader.nextInt();
          reader.nextLine();

          System.out.println("Digite el mes de salida");
          int mon2 = reader.nextInt();
          reader.nextLine();

          System.out.println("Digite el año de salida ");
          int yea2 = reader.nextInt();
          reader.nextLine();

          HistorialDated dateOut = new HistorialDated(dai2, mon2, yea2);

          System.out.println("Digite el nombre del dueño ");
          String nameClie = reader.nextLine();

          System.out.println("Digite el id del cliente");
          int idClie = reader.nextInt();
          reader.nextLine();

          System.out.println("Digite el nombre completo de la mascota");
          String namePe = reader.nextLine();

          System.out.println("Digite el sintoma del animal");
          String symp = reader.nextLine();

          System.out.println("Digite el diagnostico ");
          String diag = reader.nextLine();

          System.out.println("Digite el estado");
          boolean stat = reader.nextBoolean();
          reader.nextLine();

          System.out.println("Digite el nombre del medicamento");
          String medi = reader.nextLine();

          System.out.println("Digite la dosis");
          double dos = reader.nextDouble();
          reader.nextLine();

          System.out.println("Digite la total de dosis");
          double totaldos = reader.nextDouble();
          reader.nextLine();

          System.out.println("Digite la frecuencia del medicamento");
          int frec = reader.nextInt();
          reader.nextLine();

          Pet pet2 = principal.findPett(nameClie, idClie, namePe);

          ClinicalHistory newMedRec = new ClinicalHistory( nameClie, namePe , symp, diag, stat, dateIn,dateOut, pet2);

          Medicament medics = new Medicament(medi, dos, totaldos, frec);

          principal.hospitalizeVet(nameClie, idClie, namePe, newMedRec, medics);


          System.out.println(principal.findToHospitalize(idClientt,nampe));

          
       }else if( userImput == 7){
           System.out.println("Mostrar la informacion");

           System.out.println(principal.showClients());

       }else if( userImput == 8){

        System.out.println(principal.showRoom());

      }else if( userImput == 9){

      System.out.println("Digite el id del cliente por favor");
      int idClientToVeterinary = reader.nextInt();
      reader.nextLine();

      System.out.println("Digite la dirección que quiere actualizar por favor");
      String addresClientToVeterinary = reader.nextLine();

      System.out.println("Por favor digite el telefono que quiere actualizar por favor");
      String phoneClientToVeterinary = reader.nextLine();

      System.out.println(principal.actualizePhoneAndAddressOfCLient(idClientToVeterinary,addresClientToVeterinary,phoneClientToVeterinary));

      }else if(userImput == 10){

      System.out.println("Digite el id del usuario para poder buscarlo");
      int clientForVeterinary = reader.nextInt();
      reader.nextLine();

      System.out.println("Digite el nombre de la mascota del dueño");
      String namePetLupe = reader.nextLine();

      System.out.println("Digite el nombre del medicamento");
      String medicamentForVeterinary = reader.nextLine();

      System.out.println("Digite la dosis del medicamento");
      double doseForVeterinary = reader.nextDouble();
      reader.nextLine();

      System.out.println("Digite el costo de la medicina");
      double costForVeterinary = reader.nextDouble();
      reader.nextLine();

      System.out.println("Digite la frecuencia del medicamento");
      int frecForVeterinary = reader.nextInt();
      reader.nextLine();

      System.out.println(principal.addMediceToHospitalization(clientForVeterinary,namePetLupe,medicamentForVeterinary, doseForVeterinary, costForVeterinary, frecForVeterinary));


      }else if(userImput == 11){

        System.out.println("Por favor digite el id del cliente del animalito");
        int clientIdentify = reader.nextInt();
        reader.nextLine();

        System.out.println("Por favor digite el nombre del animal del dueño");
        String nameClientPet = reader.nextLine();


        System.out.println("Digite las notas que desea agregar al diagnostico del paciente");
        String notes = reader.nextLine();

        principal.addNotesToHospitalization(clientIdentify,nameClientPet,notes);

      }else if(userImput == 12){

      System.out.println("Digite el id del usuario");
      int clientToPet = reader.nextInt();
      reader.nextLine();

      System.out.println("Digite el nombre del animal");
      String petNameToPet = reader.nextLine();

      System.out.println("Ahora por favor digite el nuevo sintoma del animalito");
      String symptomPet = reader.nextLine();

      principal.addNewSymptom(clientToPet,petNameToPet,symptomPet);

      }else if(userImput == 13){

      System.out.println("El costo del servicio de lavado de mascotas es:" + principal.calculatedService1());
      System.out.println("El costo del servicio de lavado de mascotas a domicilios es:" + principal.calculatedService2());
      System.out.println("El costo del servicio de corte de uñas de mascotas es:" + principal.calculatedService3());
      System.out.println("El costo del servicio de profilaxis dental mascotas es:" + principal.calculatedService4());
      System.out.println("El costo del servicio de aplicacion de vacunas para mascotas es:" + principal.calculatedService5());

      }else if(userImput ==14){

      System.out.println(principal.promediateCostOfServices());


      }else if(userImput == 15){

      System.out.println("El ingreso total de los servicios es:" + principal.calculatedCostTotalForTheService());

      }else if(userImput == 16){
      System.out.println("|--Por favor digite los siguientes digitos--|");

      System.out.println("Por favor digite el tipo de servicio:" + TypeOfService.service1 + "/"+ TypeOfService.service2 + "/" + TypeOfService.service3 + "/" + TypeOfService.service4 + "/" +TypeOfService.service5);
      String serviceOf = reader.nextLine();

      System.out.println("Por favor digite el costo:");
      double costOfService = reader.nextDouble();
      reader.nextLine();

      System.out.println("Por favor digite el dia en el que se hace:");
      String dateInService = reader.nextLine();

      System.out.println("Por favor digite la identificacion del animalito:");
      int identifyServicePet = reader.nextInt();
      reader.nextLine();

      System.out.println("Por favor digite la identificacion del cliente:");
      int identifyServiceClient = reader.nextInt();
      reader.nextLine();

      System.out.println("Por favor digite el nombre de la mascota:");
      String namePetService = reader.nextLine();

      System.out.println("Por favor digite  la edad de la mascota:");
      int agePetOld = reader.nextInt();
      reader.nextLine();

      System.out.println("Por favor digite el tipo de animal:" + Pet.DOG + "/" + Pet.CAT+ "/" + Pet.BIRD + "/" + Pet.OTHER);
      String typeOfAnimalService = reader.nextLine();

      System.out.println("Por favor digite el peso del animal:");
      double weightAnimal = reader.nextDouble();
      reader.nextLine();

      System.out.println("Por favor digite la altura del animal:");
      double heightAnimal = reader.nextDouble();
      reader.nextLine();

      System.out.println("Por favor digite el nombre de su dueño:");
      String nameOfClientService = reader.nextLine();

      System.out.println("Por favor digite la direccion:");
      String clientDirection = reader.nextLine();

      System.out.println("Por favor digite el numero:");
      String numberOfClient = reader.nextLine();

      Client theClient = new Client(nameOfClientService,identifyServiceClient,clientDirection,numberOfClient);
      Pet p = new Pet(namePetService,agePetOld,typeOfAnimalService,weightAnimal,heightAnimal,theClient);
      TypeOfService m = new TypeOfService(serviceOf,costOfService,dateInService,identifyServicePet,identifyServiceClient,p);

      principal.addServiceWithPet(m,p);

      }else if(userImput == 17){


      System.out.println("Por favor digite la fecha inicial en el siguiente formato: AAAA-MM-DD");

      String inicialDate = reader.nextLine();

      System.out.println("Por favor digite la fecha final en el siguiente formato: AAAA-MM-DD");

      String finalDate = reader.nextLine();

      System.out.println(principal.getReportedAboutAnimalWithInicialDateAndFinalDate(inicialDate,finalDate));


      }else if(userImput == 18){
        System.out.println("Digite el dia actual");
        int dayActual = reader.nextInt();
        reader.nextLine();

        System.out.println("Digite el mes actual");
        int monthActual = reader.nextInt();
        reader.nextLine();

        System.out.println("Digite el año actual");
        int actualYear = reader.nextInt();
        reader.nextLine();

        System.out.println(principal.calculatedCostForOneWeek(dayActual,monthActual,actualYear));



      }else{
         System.out.println("Adios");
       }

      }

    }
// DE AHI EN ADELANTE ES CREAR LOS CLIENTES POR DEFECTO
public void init(){

 principal = new Veterinary("Mi pequena mascota");

    Client maria = new Client("Maria", 5820, "Limonar", "55267");
		Pet molly = new Pet("Molly",12, "Gato", 12.0,130.0,maria);
		ArrayList<Pet> PetsMaria = new ArrayList<Pet>();
		PetsMaria.add(molly);
		principal.addClient(maria,PetsMaria);

		Client andres = new Client("Andres", 1245, "Caney 1", "19035");
		Pet tigre = new Pet("Tigre", 13, "Perro", 23.0,130.0,andres);
		ArrayList<Pet> PetsAndres = new ArrayList<Pet>();
		PetsAndres.add(tigre);
		principal.addClient(andres, PetsAndres);

		Client sofia = new Client("Sofia", 1249, "Caney 2", "3155678");
		Pet susi = new Pet("Susi",15, "Otro", 70.0,29.6,sofia);
		Pet beto = new Pet("Beto",19, "Perro", 39.0,87.0,sofia);
		ArrayList<Pet> PetsSofia = new ArrayList<Pet>();
		PetsSofia.add(susi);
    PetsSofia.add(beto);
		principal.addClient(sofia,PetsSofia);

		Client camilo  = new Client("Camilo", 0502, "Caney 3", "41889");
		Pet lola = new Pet("lola",2, "Gato",20.0,230.0,camilo);
		Pet cheto = new Pet("cheto",4,"Ave",3.2,134.8,camilo);
		ArrayList<Pet> PetsCamilo = new ArrayList<Pet>();
		PetsCamilo.add(lola);
    PetsCamilo.add(cheto);
		principal.addClient(camilo, PetsCamilo);

    Client esteban  = new Client("Esteban", 1112, "Caney Especial", "30176");
    Pet princesa = new Pet("Princesa",9, "Otro",29.0,140.0,esteban);
    Pet pancake = new Pet("Pancake",100,"Otro",113.2,150.0,esteban);
    ArrayList<Pet> PetsEsteban = new ArrayList<Pet>();
    PetsEsteban.add(princesa);
    PetsEsteban.add(pancake);
    principal.addClient(esteban, PetsEsteban);

    Client luisa  = new Client("Luisa", 7895, "Calicanto", "934055");
    Pet cosita = new Pet("Cosita",9, "Otro",1220.0,156.0,luisa);
    ArrayList<Pet> PetsLuisa = new ArrayList<Pet>();
    PetsLuisa.add(cosita);
    principal.addClient(luisa, PetsLuisa);

    Client miguel = new Client("Miguel", 1234,"Valle del lili", "300529");
    Pet chispas = new Pet("Chispas", 12 , Pet.DOG, 120.0, 300.0, miguel);
    TypeOfService s1 = new TypeOfService(TypeOfService.service1, TypeOfService.washPets,"4 de enero/2018",1234,1234,chispas);

    principal.addServiceWithPet(s1,chispas);

    Client flor = new Client("Flor", 1111,"Caney", "121421");
    Pet perro = new Pet("Perro", 17 , Pet.CAT, 150.0, 310.0, flor);
    TypeOfService s2 = new TypeOfService(TypeOfService.service3, TypeOfService.cutNails,"3 de marzo/2010",1111,1111,perro);

    principal.addServiceWithPet(s2,perro);


    Room miniRoom1 = new Room(false, 1, princesa);
		Room miniRoom2 = new Room(false, 2, lola);
		Room miniRoom3 = new Room(false, 3, beto );
		Room miniRoom4 = new Room(false, 4, pancake);
		Room miniRoom5 = new Room(false, 5, susi);
		Room miniRoom6 = new Room(false,6, tigre);
		Room miniRoom7 = new Room(false, 7, cosita);
		Room miniRoom8 = new Room(false, 8, cheto);
		principal.addMiniRoom(miniRoom1, miniRoom2, miniRoom3 ,miniRoom4, miniRoom5, miniRoom6, miniRoom7, miniRoom8);

}

}
