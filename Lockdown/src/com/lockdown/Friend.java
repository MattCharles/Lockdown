package com.lockdown;

public class Friend {
	
	private String name;
	private String numberString;
	private int number;
	
	public Friend(){
		name = "";
		numberString = "";
		number = 0;
	}
	public Friend( String name ){
		this.name = name;
		numberString = "";
		number = 0;
	}
	public Friend( String name, int number ){
		this.name = name;
		numberString = Integer.toString(number) ;
		this.number = number;
	}
	
	
	public String getName(){
		return name;
	}
	public int getNumber(){
		return number;
	}
	public String getNumberString(){
		return numberString;
	}
	public void getName( String name ){
		this.name = name;
	}
	public void setNumber( int number ){
		this.number = number;
	}
	public void setNumberString( String numberString ){
		 this.numberString = numberString;
	}
	
}
