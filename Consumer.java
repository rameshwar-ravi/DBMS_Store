package Connection;
import java.sql.*;
import java.util.*;
public class Consumer {
	Scanner sc=new Scanner(System.in);
	int customer_id=18;int order_id=15;int productcount=0;int cost=0;
	public int customer_login(Connection con) {
		try {
			Statement stmt=con.createStatement(); 
			try {
				System.out.println("Enter login id:");
				String loginid=sc.next();
				System.out.println("Enter Password:");
				String password=sc.next();
				ResultSet rs=stmt.executeQuery("select * from customer where login_id='"+loginid+"'"+ "and login_password='"+password+"'");
				boolean isnotEmpty = rs.first();
				if(isnotEmpty) {
					customer_id=rs.getInt(1);
					stmt.close();
					return 1;//logged in successfully
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
	public int customer_register(Connection con){
		System.out.print("Enter your login_id");String loginid=sc.next();System.out.println();
		System.out.print("Enter your password");String password=sc.next();System.out.println();
		System.out.print("Enter your first name");String fname=sc.next();System.out.println();
		System.out.print("Enter your lastname");String lname=sc.next();System.out.println();
		System.out.print("Enter your address line1");String address1=sc.next();System.out.println();
		System.out.print("Enter your address line2");String address2=sc.next();System.out.println();
		System.out.print("Enter your city");String city=sc.next();System.out.println();
		System.out.print("Enter your pincode");String pincode=sc.next();System.out.println();
		System.out.print("Enter your contact");String contact=sc.next();System.out.println();
		System.out.print("Enter your country code");String concode=sc.next();System.out.println();
		System.out.print("Enter your creditlimit");String creditlimit=sc.next();System.out.println();
		try {
			Statement stmt=con.createStatement(); 
			try {
				java.util.Date javaDate = new java.util.Date();
				long javaTime = javaDate.getTime();
				java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(javaTime);
				String join=sqlTimestamp.toString();
				String query1="INSERT into customer (`login_id`,`login_password`,`first_name`, `last_name`,`address_line1`,`address_line2`,`city`,`pin_code`,`contact`,`country_code`,`credit_limit`,`joined_at`)";
				String query2="VALUES ('"+loginid+"','"+password+"','"+fname+"','"+lname+"','"+address1+"','"+address2+"','"+city+"','"+pincode+"','"+contact+"','"+concode+"','"+creditlimit+"','"+join+"')";
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
	public int showresult(Connection con,int flag) {
		try {
			Statement stmt=con.createStatement(); 
			try {
				if(flag==1) {
					ResultSet rs=stmt.executeQuery("select product_name,product_price,product_rating from products where quantity_available>0" );
					while(rs.next()) {
						System.out.println("product"+rs.getString("product_name")+"price  "+rs.getString("product_price")+"ratings "+rs.getString("product_rating"));
					}
					return 1;
				}
				else if(flag==2) {
					System.out.println("please eneter the category");
					String category=sc.nextLine().trim();
					System.out.println(category);
					ResultSet rs=stmt.executeQuery("select p.product_name,p.product_price,p.product_rating,c.category_name from products as p,categories as c where p.quantity_available>0 and p.category_id=c.category_id and c.category_name='"+category+"'");
					while(rs.next()) {
						System.out.println("product"+rs.getString("p.product_name")+" price  "+rs.getString("p.product_price")+" ratings "+rs.getString("p.product_rating")+" category "+rs.getString("c.category_name"));
					}
					stmt.close();
					return 1;
				}
				else if(flag==3) {
					ResultSet rs=stmt.executeQuery("select category_name from categories");
					while(rs.next()) {
						System.out.println(rs.getString("category_name"));
					}
					stmt.close();
					return 1;
				}
				else if(flag==4) {
						System.out.println("Search for product and add to cart, press 0 to complete the order and place to cart");
						System.out.println("ADD in previous order yes/no");
						String prod=sc.nextLine();
						System.out.println(prod);
						String s=sc.next();
						if(!s.equals("yes")) {
							order_id++;
							productcount=0;
							cost=0;
						}
						productcount++;
						ResultSet rs=stmt.executeQuery("select product_name,product_price,product_rating,quantity_available from products where product_name='"+prod+"'");
						System.out.println(rs.first()) ;
						int product_price=rs.getInt("product_price");
						System.out.println("product"+rs.getString("product_name")+" price  "+Integer.toString(product_price)+" ratings "+rs.getString("product_rating"));
						System.out.println("want to add this product to cart yes/no");
						String input=sc.next();
						if(input.equals("yes")) {
							int quantity_available=rs.getInt(4);
							System.out.println("quantity, please put less than "+quantity_available);
							int k=sc.nextInt();
							int price=product_price*k;
							cost+=price;
							String pr=Integer.toString(price);
							stmt.executeUpdate("INSERT INTO order_items VALUES ("+Integer.toString(order_id)+","+rs.getString("product_price")+","+Integer.toString(k)+","+pr+","+"0"+","+pr+")" );
							System.out.println("hi");
						}
						System.out.println("finish order yes/no");
						String inp1=sc.next();
						if(inp1.equals("yes")) {
							order_id++;
							productcount=0;cost=0;
							stmt.executeUpdate("INSERT INTO orders (order_id,customer_id) VALUES ("+Integer.toString(order_id)+","+Integer.toString(customer_id)+")");
							stmt.executeUpdate("INSERT INTO cart VALUES ("+Integer.toString(customer_id)+","+Integer.toString(cost)+","+Integer.toString(productcount)+")");
							return 1;
						}
						return 1;
					}
				if(flag==5) {
					ResultSet rs=stmt.executeQuery("SELECT sum(total_amount),sum(number_of_products) FROM cart where customer_id="+Integer.toString(customer_id));
					int totc=0;
					int totp=0;
					if(rs.first()) {
						totc=rs.getInt(1);
						totp=rs.getInt(2);
						if(totc<0) totc=0;
						if(totp<0) totp=0;
						System.out.println("total cost "+totc+" total products "+ totp);
					}
					System.out.println("checkout yes/no");
					String yn=sc.next();
					if(yn.equals("yes")) {
						System.out.println("order placed successfully");
						stmt.executeUpdate("INSERT INTO cart VALUES ("+Integer.toString(customer_id)+","+Integer.toString(-totc)+","+Integer.toString(-totp)+")");
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
		return 0;
	}
}
/*(String loginid,String password,String fname,String lname,
 * String address1,String address2,String city,int pintcode,String contact,String countrycode,String credit_limit,String joined_at) */
