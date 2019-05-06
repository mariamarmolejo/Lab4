package model;


public class HistorialDated{

//Atributes
private int day;
private int month;
private int year;

//Constructor
/**
*Description this contructor initializate the variables
*@param day int day
*@param month int month
*@param year int year
*/
public HistorialDated(int day, int month, int year){
  this.day = day;
  this.month = month;
  this.year = year;
}

/**
*Description this method get the day
*@return int the day
*/
public int getDay(){
  return day;
}

/**
*Description this method set the day
*@param day int the day
*/
public void setDay(int day){
  this.day = day;
}

/**
*Description this method get the month
*@return int the month
*/
public int getMonth(){
  return month;
}

/**
*Description this method set the month
*@param month int the month
*/
public void setMonth(int month){
  this.month= month;
}

/**
*Description this method get the year
*@return int the year
*/
public int getYear(){
  return year;
}

/**
*Description this method set the year
*@param year int the year
*/
public void setYear(int year){
  this.year = year;
}

/**
*Description this method get the days
*@param actualDay int actual day 
*@param actualMonth int actual month
*@param actualYear int actual year
*@return int  days gonna be used
*/
public int getFrecuencyOfTheMedicament(int actualDay , int actualMonth, int actualYear){

	int dia = 0;
	int diaActual = 0;
	int diasCorridos = 0;
	int diasPreciso = 0;

	dia += (actualMonth - month)*30;
	diaActual += (actualDay - dia);
	diasCorridos += (actualYear - year)*360;

	diasPreciso += (dia + diaActual + diasCorridos);

  return diasPreciso;
}
}
