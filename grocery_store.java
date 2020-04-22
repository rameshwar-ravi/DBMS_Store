

import java.util.*;
import java.sql.*;

public class grocery_store {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Mysql_connection mysql_conn=new Mysql_connection();
		Connection con=mysql_conn.conn("root", "jayantj1j");
		System.out.println("Welcome to amazon store");
		System.out.println("Enter as \n press 1 for admin \n press 2 for customer \n "
				+ "press 3 for delivery executive \n press 4 for Supplier");
		System.out.println("Want to exit press 0");
		int input1=sc.nextInt();
		int flag=0;
		if(input1==2) flag=2;
		if(input1==3) flag=3;
		if(input1==4) flag=4;

		while(true && flag!=0) {
			//admin left
			
			
			
			/////consumer part
			if(flag==2) {
				boolean loggedin=false;
				Consumer customer=new Consumer();
				try {
					if(!loggedin) {
						System.out.println("welcome \n want to register: press 1");
						System.out.println("for log in: press 2");
						System.out.println("for exit press 0");
						int flag1=sc.nextInt();
						if(flag1==1) {
							int reg=customer.customer_register(con);
							if(reg==0) {
								System.out.println("error: already registered aur faulty inputs");
								continue;
							}
							else {
								flag1=2;
							}
						}
						if(flag1==2) {
							int log=customer.customer_login(con);
							if(log==1) {
								loggedin=true;
								System.out.println("log in successful");
								continue;
							}
							else {
								loggedin=false;
								System.out.println("wrong credentials");
								System.out.println("press 0 to exit or 1 to try again");
								int ex=sc.nextInt();
								if(ex==0) break;
								else continue; 
							}
						}
						if(flag1==0) break;
					}
					if(loggedin) {
						System.out.println("show all items press 1 \n press 2 to see products by category"
								+ " \n else press 4 to search and add a product to cart "
								+ "/n press 5 to checkout or 0 to exit");
						System.out.println("press 7 to rate previously ordered products");
						int item_flag=sc.nextInt();
						if(item_flag==1) {
							int noerr=customer.showresult(con, item_flag);
							if(noerr==0) {
								System.out.println("wrong input");
								continue;
							}
						}
						if(item_flag==2) {
							System.out.println("available categories, please enter one");
							customer.showresult(con, 3);
							int noerr=customer.showresult(con, item_flag);
							if(noerr==0) {
								System.out.println("wrong input");
								continue;
							}
						}
						if(item_flag==4) {
							int noerr=customer.showresult(con, item_flag);
							if(noerr==0) {
								System.out.println("wrong input");
								continue;
							}
						}
						if(item_flag==5) {
							int noerr=customer.showresult(con, item_flag);
							if(noerr==0) {
								System.out.println("wrong input");
								continue;
							}
						}
						if(item_flag==7) {
							int noerr=customer.showresult(con, item_flag);
							if(noerr==0) {
								System.out.println("wrong input");
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
			///////////////////delivery execuive waala part
			else if(flag==3) {
				try {
					System.out.println("Want to proceed press 1 else press 0 to exit");
					int hh=sc.nextInt();
					if(hh==0) break;
					int delivery=0;
					Delivery_Executive delx=new Delivery_Executive();
					int flag1=1;int reg=-1;
					while(flag1==1) {
						reg=delx.delivery_executive_login(con);
						if(reg==0) {
							System.out.println("wrong credentials");
							System.out.println("press 0 to exit or 1 to try again");
							int ex=sc.nextInt();
							if(ex==0) break;
							else continue; 
						}
						else {
							System.out.println("log in successful");
							delivery=reg;
							flag1=2;
						}
					}


					System.out.println("press 0 know my current details \n "
							+ "press 1 to view your current pending orders \n "
							+ "press 2 to view details of your order(using order_ID) \n"

							+ "press 3 to update your details "
							+ "or 0 to exit");

					int item_flag=sc.nextInt();

					if(item_flag==0 && flag1==2) {
						delx.show_details(con,delivery);
						break;
					}

					if(item_flag==1 && flag1==2) {
						System.out.println("Your currently pending orders");
						delx.delivery_executive_showresult(con,Integer.toString(delivery),1);

					}

					else if(item_flag==2 && flag1==2) {
						delx.delivery_executive_showresult(con,Integer.toString(delivery),2);

					}

					else if(item_flag==3 && flag1==2) {
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
					System.out.println("Want to proceed press 1 else press 0 to exit");
					int hh=sc.nextInt();
					if(hh==0) break;
					int sup_id=0;
					Supplier sup=new Supplier();
					int flag1=1;int reg=-1;
					while(flag1==1) {
						reg=sup.supplier_login(con);
						if(reg==0) {
							System.out.println("wrong id entered");
							System.out.println("press 0 to exit supplier or 1 to try again");
							int ex=sc.nextInt();
							if(ex==0) return; 
							else continue; 
						}
						else {
							System.out.println("log in successful");
							sup_id=reg;
							flag1=2;
						}
					}

					System.out.println();
				if(flag1==2)
				System.out.println("Press 0 to know your supplied products details \n ");
				System.out.println("Press 1 to know your details & rating \n ");

					int item_flag=sc.nextInt();

					if(item_flag==0 && flag1==2) {
						sup.supplier_showresult(con,Integer.toString(sup_id),1);
						
					}
					else if(item_flag==1 && flag1==2) {
						sup.supplier_showresult(con,Integer.toString(sup_id),44);
						
					}

				}

				catch(Exception e){
					System.out.println("An error occured..Try sometime later");
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