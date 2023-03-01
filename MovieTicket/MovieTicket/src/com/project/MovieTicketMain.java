package com.project;

import java.util.Scanner;

public class MovieTicketMain {
	 public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);
	        int status=1;
	        
	        MovieTicket movielist[]= null;
	    
	    do{
	        System.out.println("WELCOME TO THE CINEMA HALL");
	        System.out.println("1. Add movie details");
	        System.out.println("2. Search and Book");
	        System.out.println("3. view all");
	        System.out.println("Enter your choice: ");
	       
	        int ch = sc.nextInt();
	        switch(ch){

	            case 1: 
	                     System.out.println("Enter no of movies : ");
	                     int no=sc.nextInt();
	                      movielist= new MovieTicket[no];
	                     for(int i=0;i<movielist.length;i++){
	                        int j=i;
	                        System.out.println("Fill-up  movie's "+ ++j +" details");
	                         movielist[i]= new MovieTicket();
	                     }
	                     System.out.println("Data saved.....");
	                     break;

	            case 2:
	                    boolean flag= true;
	                    sc.nextLine();
	                    System.out.println("Enter the movie name : ");
	                    String name = sc.nextLine();
	                    for(int i=0;i<movielist.length;i++){
	                        if(movielist[i].getName().equals(name)){
	                            movielist[i].viewAllDetails();
	                            flag = true;
	                            System.out.println("Would you like to book tickets for this movie? :");
	                            System.out.println("Enter 1 to book and 2 to exite :");
	                            int c=sc.nextInt();
	                            if(c==1){
	                                System.out.println("Enter the no. of tickets :");
	                                int tick = sc.nextInt();
	                                int tc = movielist[i].getCost()*tick;
	                                System.out.println("The bill comes up to :"+tc);
	                            }
	                            else
	                                 break;

	                        }
	                        else
	                             flag = false;
	                    }   
	                    if(flag==false)
	                    System.out.println("Not Found");
	                    break;
	                    
	            case 3: 
	                    for(int i=0;i<movielist.length;i++){
	                        movielist[i].viewAllDetails();
	                    } 
	                    
	            default : 
	                      System.out.println("Wrong choice...");       
	        }
	        System.out.println("Do you want to continue enter 1 or 2 (1.YES / 2. NO) :");
	        status = sc.nextInt();

	    }
	    while(status==1);
	    System.out.println("Execution completed succefully....");
	}
}
