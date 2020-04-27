

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Delivery_Executive {
	Scanner sc=new Scanner(System.in);
	int deliver_executive_id=15;
	public int delivery_executive_login(Connection con) {
		try {
			Statement stmt=con.createStatement(); 
			try {
				System.out.println("************");
				System.out.println("Welcome Delivery Executive");
				System.out.println("Enter delivery executive ID: ");
		String loginid=sc.next();
		System.out.println("Enter your unique photo ID number:");
		String password=sc.next();
		System.out.println("************");
		ResultSet rs=stmt.executeQuery("select * from delivery_executive where delivery_executive_id='"+loginid+"'"+ "and photo_id_number='"+password+"'");

		boolean isnotEmpty = rs.first();
		if(isnotEmpty) {
			deliver_executive_id=rs.getInt(1);
			System.out.println("your id "+deliver_executive_id);
			stmt.close();
			return deliver_executive_id;//logged in successfully
		}
		else return 0;// not able to login
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

public void show_details(Connection con,int delivery){
	try {
		Statement stmt=con.createStatement(); 
		System.out.println("Your details");
	ResultSet rs=stmt.executeQuery("Select delivery_executive_name, delivery_executive_phone,"
			+ " photo_id_type, photo_id_number, rating, delivery_executive_id, photo_id_number "
			+ "from delivery_executive where delivery_executive_id = " +Integer.toString(delivery));
	while(rs.next()) {
		System.out.println("*************");
		System.out.print(" Name: " + rs.getString("delivery_executive_name") );
		System.out.println(" Contact: "+rs.getString("delivery_executive_phone"));
		System.out.println(" Photo ID type: " + rs.getString("photo_id_type"));
		System.out.println(" Photo ID number: " + rs.getString("photo_id_number"));
		System.out.println(" Login ID: " + rs.getString("delivery_executive_id"));
		System.out.println(" Password: " + rs.getString("photo_id_number"));
		System.out.println(" Rating: " + rs.getString("rating") );
			System.out.println();

		}

	}
	catch (Exception e) {
		System.out.println(e);
	}


}
public int deliveryexec_register(Connection con){
	System.out.print("Enter your login id");String loginid=sc.next();System.out.println();
System.out.print("Enter your password");String password=sc.next();System.out.println();
System.out.print("Enter your name");String name=sc.next();System.out.println();
System.out.print("Enter your ID type");String idType=sc.next();System.out.println();
System.out.print("Enter your ID number");String idNumber=sc.next();System.out.println();
System.out.print("Enter your contact number");String contact=sc.next();System.out.println();
//		String rating=null;
try {
	Statement stmt=con.createStatement(); 
	try {
		String query1="INSERT into delivery_executive (`delivery_executive_login_id`,`delivery_executive_password`,`deliver_executive_name`,`deliver_executive_phone`,`photo_id_type`,`photo_id_number`)";
		String query2="VALUES ('"+loginid+"','"+password+"','"+name+"','"+contact+"','"+idType+"','"+idNumber+"')";
			String final_query=query1+query2;
			stmt.executeUpdate(final_query);
			stmt.close();
			return 1;
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
public int delivery_executive_showresult(Connection con, String delivery, int flag) {
	try {
		Statement stmt=con.createStatement(); 
		try {
			if(flag==1) //View current pending orders assigned to you
		{
			ResultSet rs=stmt.executeQuery("Select A.order_id, B.first_name, A.status, A.order_ship_address_line1, A.order_ship_address_line2  from orders as A, customer as B where A.status='"+"Shipping"+"'"+"and A.customer_id = B.customer_id and A.order_delivery_partner ='" +delivery+"'"); 
			boolean check=rs.first();
			if(check) {
				do {
					System.out.println("************");
					System.out.println("Order ID: "+rs.getString("A.order_id"));
					System.out.println("Customer Name: " + rs.getString("B.first_name"));
					System.out.println("Order Status: " + rs.getString("A.status"));
					System.out.println("Address: " + rs.getString("A.order_ship_address_line1") + rs.getString("A.order_ship_address_line2"));
					System.out.println("--------------");
				}while(rs.next());
			}
			else {
				System.out.println("No order is pending for you!");
			}
			return 1;
		}
		else if(flag==2) //View details of a particular order
		{

			try{
				System.out.println("Please enter an orderID :) ");
				int order=sc.nextInt();
				ResultSet rs = stmt.executeQuery("Select A.order_id, C.first_name, C.contact, "
						+ "A.order_ship_address_line1, A.order_ship_address_line2, A.order_ship_city_pincode, "
						+ "A.order_ship_country, B.product_id, B.quantity, B.sum_total, D.payment_mode, D.paid "
						+ "from orders as A, order_items as B, customer as C, invoice as D "
						
						+ "where B.order_id = A.order_id and A.customer_id = C.customer_id and "
						+ "D.order_id = A.order_id and A.order_id='" + order +"'"+
						"and A.order_delivery_partner='" + delivery+"'");
					//System.out.println(rs.first());
				if(rs.first()) {
					while(rs.next()) {
						System.out.println("************");
						System.out.println("Order ID: "+rs.getString("A.order_id"));
						System.out.println("Customer Name: " + rs.getString("C.first_name"));
						System.out.println("Customer contact: " + rs.getString("C.contact"));
						System.out.println("Address: " + rs.getString("A.order_ship_address_line1") + 
								rs.getString("A.order_ship_address_line2") + rs.getString("A.order_ship_city_pincode") + rs.getString("A.order_ship_country"));
						System.out.println("Product ID: "+rs.getString("B.product_id"));
						System.out.println("Quantity: "+rs.getString("B.quantity"));
						System.out.println("Sum total: "+rs.getString("B.sum_total"));
						System.out.println("Payment Mode: "+rs.getString("D.payment_mode"));
						System.out.println("Paid ( 1 for yes, 0 for no:)-> "+rs.getString("D.paid"));
						System.out.println("--------------");
					}
				}
				
				
				return 1;
				}
			catch (Exception e){
				System.out.println("No such orders");
				System.out.println(e);
				return 0;
			}

		}
		else if(flag==3) //Update your information
		{
			System.out.println("Your current details");
			System.out.println("************");
			show_details(con, Integer.parseInt(delivery));
			System.out.println("--------------");

			System.out.println("Press 1 to change your name");
			System.out.println("Press 2 to change your contact");

			System.out.println("Press 5 to change your login ID");


			int choice=sc.nextInt();
			if(choice==1)
			{	System.out.println("--------------");
				System.out.println("Enter new name: ");
				String update=sc.next();
				stmt.executeUpdate("Update delivery_executive set delivery_executive_name='" + update +"'"+"where delivery_executive_id='"+delivery+"'");

			}
			else if(choice==2)
			{	System.out.println("--------------");
				System.out.println("Enter new contact: ");
				String update=sc.next();
				stmt.executeUpdate("Update delivery_executive set delivery_executive_phone='" + update +"'"+ "where delivery_executive_id='"+delivery+"'");

			}
	
			else if(choice==5)
			{
				ResultSet rs=stmt.executeQuery("Select MAX(delivery_executive_id) from delivery_executive");
				System.out.println("--------------");
				System.out.println("Set value greater than "+rs.getString(1));
				System.out.println("Enter new loginID: ");
				String update=sc.next();
				
				try {
				stmt.executeUpdate("Update delivery_executive set delivery_executive_id='" + update +"'"+ "where delivery_executive_id='"+delivery+"'");   //login_password='"+password+"'");
				}
				catch(Exception E) {
					System.out.println("Already taken username entered!");
				}
				}
					return 1;
				}
				else if(flag==4) 
				{
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
}
