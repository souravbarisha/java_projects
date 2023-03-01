package com.project;

import java.util.Scanner;

public class MovieTicket {
	 private String name;
	    private String theaterName;
	    private int noOfTickets;
	    private int cost;
	    MovieTicket(){
	        Scanner sc =new Scanner(System.in);

	        System.out.println("Enter the movie's name:");
	        this.name = sc.nextLine();

	        System.out.println("Enter the theater's name:");
	        this.theaterName = sc.nextLine();
	        
	        System.out.println("Enter the no of tickets:");
	        this.noOfTickets = sc.nextInt();
	        
	        System.out.println("Enter the cost per ticket:");
	        this.cost = sc.nextInt();
	    }
	    void setName(String name){
	        this.name = name;
	    }
	    String getName(){
	        return name;
	    }
	    void setTheaterName(String theaterName){
	        this.theaterName = theaterName;
	    }
	    String getTheaterName(){
	        return theaterName;
	    }
	    void setNoOfTickets(int noOfTickets){
	        this.noOfTickets= noOfTickets;
	    }
	    int getNoOfTickets(){
	        return noOfTickets;
	    }
	    void setCost(int cost){
	        this.cost= cost;
	    }
	    int getCost(){
	        return cost;
	    }

	    void storeAllDetails(String name, String brand, int memory, int camera, double price){
	        this.name= name;
	        this.theaterName= theaterName;
	        this.noOfTickets= noOfTickets;
	        this.cost= cost;
	    }

	    void viewAllDetails(){
	        System.out.println("Name :"+name);
	        System.out.println("Theater Name :"+theaterName);
	        System.out.println("NO. Of Tickets :"+noOfTickets);
	        System.out.println("Coast Of The Ticket :"+cost);
	    }
}
