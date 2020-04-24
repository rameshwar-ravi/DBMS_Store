package Connection;


import java.util.*;
import java.sql.*;

public class grocery_store {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Mysql_connection mysql_conn=new Mysql_connection();
		Connection con=mysql_conn.conn("root", "jayantj1j");
		System.out.println("Welcome to amazon store");
		System.out.println("Press 1 to enter as Admin \nPress 2 to enter as Customer \n"
				+ "Press 3 to enter as Delivery Executive \nPress 4 to enter as Supplier");
		System.out.println("Press 0 to exit");
		int input1=sc.nextInt();
		int flag=0;
		if(input1==2) flag=2; //Consumer
		if(input1==3) flag=3; // Delivery Executive
		if(input1==4) flag=4; //Supplier

		while(true && flag!=0) {
			//admin left
			
			
			
			//consumer part
			if(flag==2) {
				
				boolean loggedin=false;
				Consumer customer=new Consumer();
				try {
					if(!loggedin) {
						System.out.println("Welcome to Customer Portal\nPress 1 to register as a new customer");
						System.out.println("Press 2 to log in");
						System.out.println("Press 0 to exit");
						int flag1=sc.nextInt();
						if(flag1==1) { //register
							int reg=customer.customer_register(con);
							if(reg==0) {
								System.out.println("Error: You have already registered in our portal or have entered faulty inputs");
								continue;
							}
							else {
								flag1=2; // login
							}
						}
						if(flag1==2) { //login
							int log=customer.customer_login(con);
							if(log==1) {
								loggedin=true;
								System.out.println("Login Successful");
								continue;
							}
							else {
								loggedin=false;
								System.out.println("Wrong credentials");
								System.out.println("Press 0 to exit or 1 to try again");
								int ex=sc.nextInt();
								if(ex==0) break;
								else continue; 
							}
						}
						if(flag1==0) break;
					}
					if(loggedin) {
						System.out.println("Press 1 to display all items");
						System.out.println("Press 2 to see products by category");
						System.out.println("Press 3 to search and add product to cart");
						System.out.println("Press 4 to checkout");
						System.out.println("Press 5 to rate previously ordered products");
						System.out.println("Press 0 to exit");

						int item_flag=sc.nextInt();
						if(item_flag==1) { //display all items
							int noerr=customer.showresult(con, item_flag);
							if(noerr==0) {
								System.out.println("Wrong input");
								continue;
							}
						}
						if(item_flag==2) {
							System.out.println("Below are the available categories, please enter one");
							customer.showresult(con, 3); //display all available categories
							int noerr=customer.showresult(con, item_flag); //display all products of the chosen category
							if(noerr==0) {
								System.out.println("Wrong input");
								continue;
							}
						}
						if(item_flag==3) { //search and add product to cart
							int noerr=customer.showresult(con, 4);
							if(noerr==0) {
								System.out.println("wrong input");
								continue;
							}
						}
						if(item_flag==4) { //checkout
							int noerr=customer.showresult(con, 5);
							if(noerr==0) {
								System.out.println("Wrong input");
								continue;
							}
						}
						if(item_flag==5) { // rate products
							int noerr=customer.showresult(con, 7);
							if(noerr==0) {
								System.out.println("Wrong input");
								continue;
							}
						}
						if(item_flag==0) break;
					}
				}
				catch(Exception e){
					System.out.println(e);
				}
			}
			
			//delivery executive 
			else if(flag==3) {
				try {
					System.out.println("Welcome to Delivery Executive Portal");
					System.out.println("Press 1 to proceed");
					System.out.println("Press 0 to exit");
					int hh=sc.nextInt();
					if(hh==0) break;
					
					int delivery=0;
					Delivery_Executive delx=new Delivery_Executive();
					int flag1=1;int reg=-1;
					
					while(flag1==1) 
					{
						reg=delx.delivery_executive_login(con);
						if(reg==0) 
						{
							System.out.println("Wrong credentials");
							System.out.println("Press 0 to exit or 1 to try again");
							int ex=sc.nextInt();
							if(ex==0) break;
							else continue; 
						}
						else 
						{
							System.out.println("Login Successful");
							delivery=reg;
							flag1=2; //logged in
						}
					}


					System.out.println("Press 0 display your current details \n "
							+ "Press 1 to view your current pending orders \n "
							+ "Press 2 to view details of a specific order(using order_ID) \n"

							+ "Press 3 to update your details "
							+ "Press 0 to exit");

					int item_flag=sc.nextInt();

					if(item_flag==0 && flag1==2) { //show details
						delx.show_details(con,delivery);
						break;
					}

					if(item_flag==1 && flag1==2) { //display current pending orders
						System.out.println("Your currently pending orders");
						delx.delivery_executive_showresult(con,Integer.toString(delivery),1);

					}

					else if(item_flag==2 && flag1==2) { //view details of single order
						delx.delivery_executive_showresult(con,Integer.toString(delivery),2);

					}

					else if(item_flag==3 && flag1==2) { //update details
						delx.delivery_executive_showresult(con,Integer.toString(delivery),3);

					}

				}

				catch(Exception e){
					System.out.println(e);
				}
				
			}
			
			// supplier part
			else if(flag==4) {
				try {
					System.out.println("Welcome to Supplier Portal");

					System.out.println("Press 1 to proceed");
					System.out.println("Press 0 to exit");
					
					int hh=sc.nextInt();
					if(hh==0) break;
					int sup_id=0;
					
					Supplier sup=new Supplier();
					int flag1=1;int reg=-1;
					
					while(flag1==1) {
						reg=sup.supplier_login(con);
						if(reg==0) {
							System.out.println("Wrong id entered");
							System.out.println("Press 0 to exit supplier or 1 to try again");
							int ex=sc.nextInt();
							if(ex==0) return; 
							else continue; 
						}
						else {
							System.out.println("Login Successful");
							sup_id=reg;
							flag1=2; //login 
						}
					}

				System.out.println();
				
					System.out.println("Press 0 to know your supplied products details \n ");
					System.out.println("Press 1 to know your details & rating \n ");
				

					int item_flag=sc.nextInt();

					if(item_flag==0 && flag1==2) { //display supplied products
						sup.supplier_showresult(con,Integer.toString(sup_id),1);
						
					}
					else if(item_flag==1 && flag1==2) { //details and rating
						sup.supplier_showresult(con,Integer.toString(sup_id),44);
						
					}

				}

				catch(Exception e){
					System.out.println("An error occured. Try sometime later");
					System.out.println(e);
				}

			}
			else {
				break;
			}
		}
		System.out.println("Exit Successful");
	}

}