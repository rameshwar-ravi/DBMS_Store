package Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*; 
public class Admin {
	Scanner sc=new Scanner(System.in); 
	public int admin_login(Connection con) {
	try {
		Statement stmt=con.createStatement(); 
		try {
			
			System.out.println("**************************************************");
			System.out.println("		Enter User id:");
			System.out.println();
			String loginid=sc.next();
			System.out.println("**************************************************");
			System.out.println("		Enter Password:");
			System.out.println();
			System.out.println("**************************************************");
			String password=sc.next();
			ResultSet rs=stmt.executeQuery("select * from admin where admin_userid='"+loginid+"'"+ "and admin_password='"+password+"'");
			boolean isnotEmpty = rs.first();
			if(isnotEmpty) {
				stmt.close();
//				System.out.println("Login Successfull");
				return 1;//logged in successfully
			}
			else{return 0;}// not able to login
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	catch(Exception e) {
		System.out.println(e);
	}
	return 0;
}
	public void edit_supplier(Connection con)
	{
		try {
			Statement stmt=con.createStatement(); 
			try 
			{
				System.out.println(" __________________________________________________");
				System.out.println("|===================================================|");
				System.out.println("|                                                   |");
				System.out.println("|             Supplier Details                      |");
				System.out.println("|                                                   |");
				System.out.println("|===================================================|");
				System.out.println("|1.View supplier                                    |");
				System.out.println("|2.Update or delete a supplier                      |");
				System.out.println("|3.Exit                                             |");
				System.out.println(" __________________________________________________");
				System.out.println("      Please enter your choice");
				int flag=sc.nextInt();
				if(flag==1) //View Product
				{
					System.out.println("*******************************************************************************************************");
					System.out.println("									List of suppliers"	);
					System.out.println("*******************************************************************************************************");
					ResultSet rs=stmt.executeQuery("select * from supplier" );
					System.out.print("SupplierID  " + "Supplier Name  "+ "Pin Code  " + "  Contact Number" +  "Country Code" +" Supplier Rating:");
					while(rs.next()) {
						System.out.println();
						System.out.println("     "+rs.getString("supplier_id")+"         "+rs.getString("supplier_name")+"     "+rs.getString("pin_code")+"        "+rs.getString("contact_number")+"            "+rs.getString("country_code")+"            "+rs.getString("supplier_rating"));
					}
					System.out.println("********************************************************************************************************");
//					int w=sc.nextInt();
//					return 1;
				}
				else if(flag==2) //Update and delete
				{
					System.out.println("**************************************************");
					System.out.println("                 Update and Delete");
					System.out.println("**************************************************");
					ResultSet rs=stmt.executeQuery("select * from supplier" );
					System.out.print("SupplierID  " + "Supplier Name  "+ "Pin Code  " + "  Contact Number" +  "Country Code" +" Supplier Rating:");
					while(rs.next()) {
						System.out.println();
						System.out.println("     "+rs.getString("supplier_id")+"         "+rs.getString("supplier_name")+"     "+rs.getString("pin_code")+"        "+rs.getString("contact_number")+"            "+rs.getString("country_code")+"            "+rs.getString("supplier_rating"));
					}
					System.out.println();
					System.out.println("Choose the Supplier ID of the supplier you want to update/remove");
					String supplier_id=sc.next();
					System.out.println("====================================================");
					System.out.println("Press 1 to change supplier name");
					System.out.println("Press 2 to change the Supplier User ID");
					System.out.println("Press 3 to change the Supplier password");
					System.out.println("Press 4 to change the pin code");
					System.out.println("Press 5 to change the contact_number");
					System.out.println("Press 6 to change the country code");
					System.out.println("Press 7 to change the supplier rating");
					System.out.println("Press 8 to remove the supplier ");
					System.out.println("====================================================");

					int choice=sc.nextInt();
					if(choice==1)
					{
						System.out.println("------------------------------------------------");
						System.out.println("	Enter new name: ");
						System.out.println("------------------------------------------------");

						String update=sc.next();
						stmt.executeUpdate("Update supplier set supplier_name='" + update + "' where supplier_id=" + supplier_id);
		
					}
					else if(choice==2)
					{
						System.out.println("------------------------------------------------");
						System.out.println("	Enter new user ID: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update supplier set supplier_name='" + update + "' where supplier_id=" + supplier_id);
		
					}
					else if(choice==3)
					{
						System.out.println("------------------------------------------------");
						System.out.println("	Enter new password: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update supplier set password='" + update + "' where supplier_id=" + supplier_id);
		
					}
					else if(choice==4)
					{
						System.out.println("------------------------------------------------");
						System.out.println("	Enter new pin code: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update supplier set pin_code='" + update + "' where supplier_id=" + supplier_id);
		
					}
					else if(choice==5)
					{
						System.out.println("------------------------------------------------");
						System.out.println("	Enter new Contact Number: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update supplier set contact_number='" + update + "' where supplier_id=" + supplier_id);
					}
					else if(choice==6)
					{
						System.out.println("------------------------------------------------");
						System.out.println("	Enter new Country code: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update supplier set country_code='" + update + "' where supplier_id=" + supplier_id);
					}
					else if(choice==7)
					{
						System.out.println("------------------------------------------------");
						System.out.println("	Enter new Supplier Rating: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update supplier set supplier_rating='" + update + "' where supplier_id=" + supplier_id);
					}
					else if(choice==8)
					{
						System.out.println(" Deleted Supplier" );
						System.out.println("------------------------------------------------");
						stmt.executeUpdate("delete from supplier where supplier_id=" + supplier_id);
					}
//					return 1;
				}
			}	
			catch(Exception e) {
				System.out.println(e);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
//		return 0;
	}
	public int edit_products(Connection con)
	{
		try {
			Statement stmt=con.createStatement(); 
			try 
			{
				System.out.println(" __________________________________________________");
				System.out.println("|===================================================|");
				System.out.println("|                                                   |");
				System.out.println("|             Products Details                      |");
				System.out.println("|                                                   |");
				System.out.println("|===================================================|");
				System.out.println("|	1.View Product                                  |");
				System.out.println("|	2.Add Product                                   |");
				System.out.println("|	3.Update or delete a product                    |");
				System.out.println("|	4.Exit                                          |");
				System.out.println(" __________________________________________________");
				System.out.println("      Please enter your choice");
				int flag=sc.nextInt();
				if(flag==1) //View Product
				{
					System.out.println("*******************************************************************************************************");
					System.out.println("									List of products"	);
					System.out.println("*******************************************************************************************************");
					ResultSet rs=stmt.executeQuery("select * from products" );
					System.out.print("ProductID  " + "           Product Name          "+ "Supplier ID  " + "  Product Price " +  "Quantity available " +" Product Rating " + "  Category" + "  Created At");
					while(rs.next()) {
						System.out.println();
						System.out.println("     "+rs.getString("product_id")+"      "+rs.getString("product_name")+"       "+rs.getString("supplier_id")+"              "+rs.getString("product_price")+"              "+rs.getString("quantity_available")+"              "+rs.getString("product_rating")+"             "+rs.getString("category_id")+"       "+rs.getString("created_at"));
					}
					return 1;
				}
				else if(flag==2) //Add new Product 
				{
					System.out.println("**************************************************");
					System.out.println("                 Add new Product");
					System.out.println("**************************************************");
					System.out.println("Please choose a Category ID(Choose a number)");
					ResultSet rs=stmt.executeQuery("select category_id, category_name from categories");
					while(rs.next()) {
						System.out.println("Category ID: "+rs.getString("category_id")+"  Category Name:"+rs.getString("category_name"));
					}
					String category=sc.next();
					System.out.println("------------------------------------------------");
					System.out.println("Enter Name of the product:"); String product_name=sc.next();
					System.out.println("------------------------------------------------");
					System.out.println("Enter the product price: "); String price=sc.next();
					System.out.println("------------------------------------------------");
					System.out.println("Enter Quantity:"); String quantity=sc.next();
					System.out.println("------------------------------------------------");
					System.out.println("Enter supplier");String supplier=sc.next();
					System.out.println("------------------------------------------------");
					try {
						java.util.Date javaDate = new java.util.Date();
						long javaTime = javaDate.getTime();
						java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(javaTime);
						String join=sqlTimestamp.toString();
						String query1="INSERT into product (`product_name`,`supplier_id`,`product_price`,`quantity_available`,`created_at`,`category_id`)";
						String query2="VALUES ('"+product_name+"','"+supplier+"','"+price+"','"+quantity+"','"+join+"','"+category+"')";
						String final_query=query1+query2;
						stmt.executeUpdate(final_query);
						stmt.close();
						return 1;
					}
					catch(Exception e) {
						System.out.println(e);
					}
					stmt.close();
					return 1;
				}
				else if(flag==3) //Update and delete
				{
					System.out.println("**************************************************");
					System.out.println("                 Update and Delete");
					System.out.println("**************************************************");
					System.out.println("Products List");
					ResultSet rs=stmt.executeQuery("select * from products" );
					System.out.print("ProductID  " + "           Product Name          "+ "Supplier ID  " + "  Product Price " +  "Quantity available " +" Product Rating " + "  Category" + "  Created At");
					while(rs.next()) {
						System.out.println();
						System.out.println("     "+rs.getString("product_id")+"      "+rs.getString("product_name")+"       "+rs.getString("supplier_id")+"              "+rs.getString("product_price")+"              "+rs.getString("quantity_available")+"              "+rs.getString("product_rating")+"             "+rs.getString("category_id")+"       "+rs.getString("created_at"));
					}
					System.out.println("Choose the Product ID of product you want to update/remove");
					String product_id=sc.next();
					System.out.println("====================================================");
					System.out.println("	Press 1 to change product name");
					System.out.println("	Press 2 to change the product price");
					System.out.println("	Press 3 to change the category");
					System.out.println("	Press 4 to change the quantity");
					System.out.println("	Press 5 to remove: ");
					System.out.println("====================================================");
					int choice=sc.nextInt();
					if(choice==1)
					{
						System.out.println("------------------------------------------------");
						System.out.println("Enter new name: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update product set product_name='" + update + "' where product_id=" + product_id);
		
					}
					else if(choice==2)
					{
						System.out.println("------------------------------------------------");
						System.out.println("Enter new price: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update product set product_price='" + update + "' where product_id=" + product_id);
						
					}
					else if(choice==3)
					{
						rs=stmt.executeQuery("select category_id, category_name from categories");
						while(rs.next()) {
							System.out.println("Category ID: "+rs.getString("category_id")+"  Category Name:"+rs.getString("category_name"));
						}
						System.out.println("------------------------------------------------");
						System.out.println("Choose catgory: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update product set category_id='" + update + "' where product_id=" + product_id);
					}
					else if(choice==4)
					{
						System.out.println("------------------------------------------------");
						System.out.println("Enter new quantity: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update product set quantity='" + update + "' where product_id=" + product_id);
					}
					else if(choice==5)
					{
						System.out.println(" Deleted Product" );
						System.out.println("------------------------------------------------");
						stmt.executeUpdate("delete from products where product_id=" + product_id);
					}
					return 1;
				}
			}	
			catch(Exception e) {
				System.out.println(e);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	public int edit_delieveryexecutive(Connection con)
	{
		try {
			Statement stmt=con.createStatement(); 
			try 
			{
				System.out.println(" __________________________________________________");
				System.out.println("|===================================================|");
				System.out.println("|                                                   |");
				System.out.println("|        Delievery Executive Details                |");
				System.out.println("|                                                   |");
				System.out.println("|===================================================|");
				System.out.println("|1.View  Delievery Executive                        |");
				System.out.println("|2.Update or delete a  Delievery Executive          |");
				System.out.println("|3.Exit                                             |");
				System.out.println(" __________________________________________________");
				System.out.println("      Please enter your choice");
				int flag=sc.nextInt();
				if(flag==1) //View Product
				{
					System.out.println("*******************************************************************************************************");
					System.out.println("								List of Delievery Executive"	);
					System.out.println("*******************************************************************************************************");
					ResultSet rs=stmt.executeQuery("select * from delivery_executive" );
					System.out.print("Delievery Executive ID  " + "Delievery Executive Name  "+ " Delievery Executive Number  " +  " Photo ID Type " +" Photo ID number " + "Rating");
					while(rs.next()) {
						System.out.println();
						System.out.println("             "+rs.getString("delivery_executive_id")+"                  "+rs.getString("delivery_executive_name")+"                  "+rs.getString("delivery_executive_phone")+"        "+rs.getString("photo_id_type")+"        "+rs.getString("photo_id_number")+"        " + rs.getString("rating"));
					}
					System.out.println("*******************************************************************************************************");
					return 1;
				}
				else if(flag==2) //Update and delete
				{
					System.out.println("**************************************************");
					System.out.println("                 Update and Delete");
					System.out.println("**************************************************");
					ResultSet rs=stmt.executeQuery("select * from delivery_executive" );
					System.out.print("Delievery Executive ID  " + "Delievery Executive Name  "+ " Delievery Executive Number  " +  " Photo ID Type " +" Photo ID number " + "Rating");
					while(rs.next()) {
						System.out.println();
						System.out.println("             "+rs.getString("delivery_executive_id")+"                  "+rs.getString("delivery_executive_name")+"                  "+rs.getString("delivery_executive_phone")+"        "+rs.getString("photo_id_type")+"        "+rs.getString("photo_id_number")+"        " + rs.getString("rating"));
					}
					System.out.println("Choose the ID of the executive you want to update/remove");
					String delivery_executive_id=sc.next();
					System.out.println("=========================================================================");
					System.out.println("	Press 1 to change Delievery Executive name");
					System.out.println("	Press 2 to change the Delievery Executive User ID");
					System.out.println("	Press 3 to change the Delievery Executive password");
					System.out.println("	Press 4 to change the Delievery Executive contact_number");
					System.out.println("	Press 5 to change the Photo ID type code");
					System.out.println("	Press 6 to change the Photo ID number rating");
					System.out.println("	Press 7 to change the Photo ID number rating");
					System.out.println("	Press 8 to remove: ");
					System.out.println("=========================================================================");

					int choice=sc.nextInt();
					if(choice==1)
					{
						System.out.println("------------------------------------------------");
						System.out.println("	Enter new name: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update delivery_executive set delivery_executive_name='" + update + "' where delivery_executive_id=" + delivery_executive_id);
		
					}
					else if(choice==2)
					{
						System.out.println("------------------------------------------------");
						System.out.println("	Enter new UserID: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update delivery_executive set login_id='" + update + "' where delivery_executive_id=" + delivery_executive_id);
		
					}
					else if(choice==3)
					{
						System.out.println("------------------------------------------------");
						System.out.println("	Enter new password: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update delivery_executive set password='" + update + "' where delivery_executive_id=" + delivery_executive_id);
		
					}
					else if(choice==4)
					{
						System.out.println("------------------------------------------------");
						System.out.println("	Enter new Contact Number: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update delivery_executive set delivery_executive_phone='" + update + "' where delivery_executive_id=" + delivery_executive_id);
					}
					else if(choice==5)
					{
						System.out.println("------------------------------------------------");
						System.out.println("	Enter Photo Id Type: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update delivery_executive set photo_id_type='" + update + "' where delivery_executive_id=" + delivery_executive_id);
					}
					else if(choice==6)
					{
						System.out.println("------------------------------------------------");
						System.out.println("	Enter Photo Id Number: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update delivery_executive set photo_id_number='" + update + "' where delivery_executive_id=" + delivery_executive_id);
					}
					else if(choice==7)
					{
						System.out.println("------------------------------------------------");
						System.out.println("	Enter new Rating: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update delivery_executive set rating='" + update + "' where delivery_executive_id=" + delivery_executive_id);
					}
					else if(choice==8)
					{
						System.out.println(" Deleted Delievery Executive" );
						System.out.println("------------------------------------------------");
						stmt.executeUpdate("delete from delivery_executive where supplier_id=" + delivery_executive_id);
					}
					return 1;
				}
			}	
			catch(Exception e) {
				System.out.println(e);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	public int edit_categories(Connection con)
	{
		try {
			Statement stmt=con.createStatement(); 
			try 
			{
				System.out.println(" __________________________________________________");
				System.out.println("|===================================================|");
				System.out.println("|                                                   |");
				System.out.println("|             Categories Details                    |");
				System.out.println("|                                                   |");
				System.out.println("|===================================================|");
				System.out.println("|	1.View Categories                               |");
				System.out.println("|	2.Add Categories                                |");
				System.out.println("|	3.Update or delete a Categories                 |");
				System.out.println("|	4.Exit                                          |");
				System.out.println(" __________________________________________________");
				System.out.println("      Please enter your choice");
				int flag=sc.nextInt();
				if(flag==1) //View Product
				{
					System.out.println("*******************************************************************************************************");
					System.out.println("								List of Categories"	);
					System.out.println("*******************************************************************************************************");
					ResultSet rs=stmt.executeQuery("select * from categories" );
					System.out.print("CategoryID  " + "Category Name  ");
					while(rs.next()) {
						System.out.println();
						System.out.println("       "+rs.getString("category_id")+"          "+rs.getString("category_name"));
					}
					return 1;
				}
				else if(flag==2) //Add new Product 
				{
					System.out.println("**************************************************");
					System.out.println("                 Add new Category");
					System.out.println("**************************************************");
					System.out.println("------------------------------------------------");
					System.out.println("Enter Name of the category:"); 
					System.out.println("------------------------------------------------");
					String category_name=sc.next();
					try {

						String query1="INSERT into categories (`category_name`)";
						String query2="VALUES ('"+category_name+"')";
						String final_query=query1+query2;
						stmt.executeUpdate(final_query);
						stmt.close();
						return 1;
					}
					catch(Exception e) {
						System.out.println(e);
					}
					stmt.close();
					return 1;
				}
				else if(flag==3) //Update and delete
				{
					System.out.println("**************************************************");
					System.out.println("                 Update and Delete");
					System.out.println("**************************************************");
					ResultSet rs=stmt.executeQuery("select * from categories" );
					System.out.print("CategoryID  " + "Category Name  ");
					while(rs.next()) {
						System.out.println();
						System.out.println("       "+rs.getString("category_id")+"        "+rs.getString("category_name"));
					}
					System.out.println("Choose the Category ID of the category you want to update/remove");
					String category_id=sc.next();
					System.out.println("=========================================================================");
					System.out.println("	Press 1 to change category name");
					System.out.println("	Press 2 to remove: ");
					System.out.println("=========================================================================");

					int choice=sc.nextInt();
					if(choice==1)
					{
						System.out.println("------------------------------------------------");
						System.out.println("Enter new name: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update categories set category_name='" + update + "' where category_id=" + category_id );
		
					}
					else if(choice==2)
					{
						System.out.println(" Deleted Category" );
						System.out.println("------------------------------------------------");
						stmt.executeUpdate("delete from categories where category_id=" + category_id);
					}
					return 1;
				}
			}	
			catch(Exception e) {
				System.out.println(e);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	public int view_feedback(Connection con)
	{
		try {
			Statement stmt=con.createStatement(); 
			
					ResultSet rs=stmt.executeQuery("select * from feedback" );
					System.out.print("Customer ID  " + "Product ID  " + "Supplier ID  " + "Delievery Executive ID  " + "Product Rating  " + "Supplier Rating  " + "Delievery Executive Rating  " + "Submission date and time ");
					while(rs.next()) {
						System.out.println();
						System.out.println("   " + rs.getString("customer_id")+"            " +rs.getString("product_id")+"            "+rs.getString("supplier_id")+"                   "+rs.getString("delivery_executive_id")+"                 "+rs.getString("product_rating")+"            "+rs.getString("supplier_rating") +"                        "+rs.getString("delivery_executive_rating")+"                 "+rs.getString("submission_date"));
					}
					return 1;
			}
		catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	public void edit_customer(Connection con)
	{
		try {
			Statement stmt=con.createStatement(); 
			try 
			{
				System.out.println(" __________________________________________________");
				System.out.println("|===================================================|");
				System.out.println("|                                                   |");
				System.out.println("|             Consumer Details                      |");
				System.out.println("|                                                   |");
				System.out.println("|===================================================|");
				System.out.println("|1.View consumer                                    |");
				System.out.println("|2.Update or delete a Consumer                      |");
				System.out.println("|3.Exit                                             |");
				System.out.println(" __________________________________________________");
				System.out.println("      Please enter your choice");
				int flag=sc.nextInt();
				if(flag==1) //View Product
				{
					System.out.println("*******************************************************************************************************");
					System.out.println("								List of Consumers"	);
					System.out.println("*******************************************************************************************************");
					ResultSet rs=stmt.executeQuery("select * from customer" );
					System.out.print("ConsumerID  " + "First Name  " +"Last Name  " + "        Address Line 1      " + "       Address Line 2       " + "City  "+ "Pin Code  " + "Contact Number  " +  "Country Code  " +"Credit Limit Joined At  ");
					while(rs.next()) {
						System.out.println();
						System.out.println("   "+rs.getString("customer_id")+"      "+rs.getString("first_name")+"       "+rs.getString("last_name")+"    "+rs.getString("address_line1")+"            "+rs.getString("address_line2")+"      "+rs.getString("city")+"            "+rs.getString("pin_code")+"            "+rs.getString("contact")+"            "+rs.getString("country_code")+"        "+rs.getString("credit_limit") +"      "+ rs.getString("joined_at"));
					}
					System.out.println("*******************************************************************************************************");
//					return 1;
				}
				else if(flag==2) //Update and delete
				{
					System.out.println("**************************************************");
					System.out.println("                 Update and Delete");
					System.out.println("**************************************************");
					ResultSet rs=stmt.executeQuery("select * from customer" );
					System.out.print("ConsumerID  " + "First Name  " +"Last Name  " + "Address Line 1  " + "Address Line 2  " + "City  "+ "Pin Code  " + "Contact Number  " +  "Country Code  " +"Credit Limit Joined At  ");
					while(rs.next()) {
						System.out.println();
						System.out.println(rs.getString("customer_id")+rs.getString("first_name")+rs.getString("last_name")+rs.getString("address_line1")+rs.getString("address_line2")+rs.getString("city")+rs.getString("pin_code")+rs.getString("contact")+rs.getString("country_code")+rs.getString("credit_limit") + rs.getString("joined_at"));
					}
					System.out.println("Choose the Consumer ID of the customer you want to update/remove");
					int customer_id=sc.nextInt();
					System.out.println("====================================================");
					System.out.println("	Press 1 to change Consumer name");
					System.out.println("	Press 2 to change the Address");
					System.out.println("	Press 3 to change the Consumer UserID");
					System.out.println("	Press 4 to change the Password");
					System.out.println("	Press 5 to change the Contact number");
					System.out.println("	Press 6 to change the Credit Limit");
					System.out.println("	Press 7 to remove: ");
					System.out.println("====================================================");

					int choice=sc.nextInt();
					if(choice==1)
					{
						System.out.println("------------------------------------------------");
						System.out.println("Enter new First name: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update customer set first_name='"+ update + "' where customer_id=" + customer_id + ";");
						
						System.out.println("------------------------------------------------");
						System.out.println("Enter new Second name: ");
						System.out.println("------------------------------------------------");
						update=sc.next();
						stmt.executeUpdate("Update customer set last_name='" + update + "' where customer_id=" + customer_id + ";");
		
					}
					else if(choice ==2)
					{
						System.out.println("------------------------------------------------");
						System.out.println("Enter address line 1: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update customer set address_line1='" + update + "' where customer_id=" + customer_id);
						System.out.println("------------------------------------------------");
						System.out.println("Enter new address line 2: ");
						System.out.println("------------------------------------------------");
						update=sc.next();
						stmt.executeUpdate("Update customer set address_line2='" + update + "' where customer_id=" + customer_id);
						System.out.println("------------------------------------------------");
						System.out.println("Enter city ");
						System.out.println("------------------------------------------------");
						update=sc.next();
						stmt.executeUpdate("Update customer set city='" + update + "' where customer_id=" + customer_id);
						System.out.println("------------------------------------------------");
						System.out.println("Enter Pin Code ");
						System.out.println("------------------------------------------------");
						update=sc.next();
						stmt.executeUpdate("Update customer set pin_code='" + update + "' where customer_id=" + customer_id);
		
		
					}
					else if(choice==4)
					{
						System.out.println("------------------------------------------------");
						System.out.println("Enter new password: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update customer set login_password='" + update + "' where customer_id=" + customer_id);
		
					}
					else if(choice==3)
					{
						System.out.println("------------------------------------------------");
						System.out.println("Enter new Second name: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update customer set login_id='" + update + "' where customer_id=" + customer_id);
		
		
					}
					else if(choice==5)
					{
						System.out.println("------------------------------------------------");
						System.out.println("Enter new Country code: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update customer set country_code='" + update + "' where customer_id=" + customer_id);
						System.out.println("------------------------------------------------");
						System.out.println("Enter new Contact Number: ");
						System.out.println("------------------------------------------------");
						update=sc.next();
						stmt.executeUpdate("Update customer set contact='" + update + "' where customer_id=" + customer_id);
					}
					else if(choice==6)
					{
						System.out.println("------------------------------------------------");
						System.out.println("Enter new Credit Limit: ");
						System.out.println("------------------------------------------------");
						String update=sc.next();
						stmt.executeUpdate("Update customer set credit_limit='" + update + "' where customer_id=" + customer_id);
					}
					else if(choice==7)
					{
						System.out.println(" Deleted Consumer" );
						System.out.println("------------------------------------------------");
						stmt.executeUpdate("delete from customer where customer_id=" + customer_id);
					}
					
				}
			}	
			catch(Exception e) {
				System.out.println(e);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}
