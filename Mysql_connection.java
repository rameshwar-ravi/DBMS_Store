package Connection;
import java.sql.*; 
import java.util.*;
    class Mysql_connection{  
    public static void main(String args[]){ 
    	Mysql_connection co=new Mysql_connection();
    	Connection kk=co.conn("root", "password");
    }
    Connection conn(String username,String pass) {
    	Connection con=null;
    	try{  
    	    Class.forName("com.mysql.cj.jdbc.Driver");  
    	    con=DriverManager.getConnection(  
    	    "jdbc:mysql://localhost:3306/online_grocerystore_management_system",username,pass); 
    	    return con;
    	    }catch(Exception e){ System.out.println(e);
    	    	return null;
    	    }
    	
    	    } 
    
    }
    