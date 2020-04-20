package Connection;
import java.util.*;
import java.sql.*;

public class grocery_store {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Mysql_connection mysql_conn=new Mysql_connection();
		Connection con=mysql_conn.conn("root", "Password");
		System.out.println("welcome to racaj store");
		System.out.println("enter as \n press 1 for admin \n press 2 for customer \n press 3 for delivery executive \n press 4 for Supplier");
		System.out.println("want to exit press 0");
		int input1=sc.nextInt();
		int flag=0;
		if(input1==2) flag=2;
		boolean loggedin=false;
		Consumer customer=new Consumer();
		while(true && flag!=0) {
		if(flag==2) {
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
					System.out.println("show all items press 1 \n press 2 to see products by category \n else press 4 to search and add a product to cart/n press 5 to checkout or 0 to exit");
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
		else {
			break;
		}
	}
		System.out.println("Exit Successful");
	}
	
}
