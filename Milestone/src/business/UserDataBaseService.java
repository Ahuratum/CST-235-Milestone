package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.faces.bean.RequestScoped;

import beans.User;
import controllers.LoginController;
import controllers.StoreManager;


@Stateless
@Local(UserDataBaseInterface.class)
@Alternative
public class UserDataBaseService  implements UserDataBaseInterface {

	public static ArrayList<User> users = new ArrayList<User>();
	public static int attempts = 3;
	
	
	// Connect to databases
	public String dbURL = "jdbc:mysql://localhost:3306/anacompute?autoReconnect=true&useSSL=false";
	public String username = "root";
	public String password = "root";
	

	public void InsertUser(User user) {
		
		Connection c = null;
		PreparedStatement stmt = null;
		try {
			c = DriverManager.getConnection(dbURL, username, password);
			// create a SQL statement
			stmt = c.prepareStatement(
					"insert into anacompute.user (firstName, lastName, email, address, phoneNumber, username, password) values (?,?,?,?,?,?,?)");
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getPhoneNumber());
			stmt.setString(6, user.getUsername());
			stmt.setString(7, user.getPassword());
			// execute the statemant
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("SUCCESS!! Rows affected " + rowsAffected);
		try {
			c.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean check(String usName, String usPassword)  {
		boolean ct = false;
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// Connect to database
			c = DriverManager.getConnection(dbURL, username, password);
			// create a SQL statement
			stmt = c.createStatement();
			// execute the statemant
			rs = stmt.executeQuery("select * from anacompute.user");
			// process the rows in the result set
			while (rs.next()) {
				if (rs.getString("username").equals(usName)
						&& rs.getString("password").equals(usPassword)) {
					LoginController.loggedUser.setAdmin(rs.getBoolean("admin"));
					ct = true;
					updateToAdmin();
				}

			}

		} catch (SQLException e) {
			System.out.println("Connection unsuccessful!");
			e.printStackTrace();
		} finally {
			// close the connection
			try {
				rs.close();
				stmt.close();

				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			

		}

		return ct;
	}

	
	public void readAll()  {
		// Connect to database

		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			// Connect to database
			c = DriverManager.getConnection(dbURL, username, password);

			// create a SQL statement
			stmt = c.createStatement();
			// execute the statemant
			rs = stmt.executeQuery("select * from anacompute.user");

			// process the rows in the result set
			while (rs.next()) {
				//System.out.println(rs.getString("username"));
			}

		} catch (SQLException e) {
			System.out.println("Connection unsuccessful!");
			e.printStackTrace();
		} finally {
			// close the connection
			try {
				rs.close();

				stmt.close();

				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

	}

	
	public void deleteUser(User user) {
		Connection c = null;
		PreparedStatement stmt = null;
		int rowsAffected = 0;

		try {
			// Connect to database
			c = DriverManager.getConnection(dbURL, username, password);

			// create a SQL statement
			stmt = c.prepareStatement("delete from anacompute.user where id = ?");
			// execute the statemant
			stmt.setString(1, user.getUsername());

			rowsAffected = stmt.executeUpdate();

			// process the rows effected
			//System.out.println("Rows affected " + rowsAffected);

		} catch (SQLException e) {
			System.out.println("Connection unsuccessful!");
			e.printStackTrace();
		} finally {
			// close the connection
			try {
				stmt.close();
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		

		}

	}
	
	public void updateToAdmin() {
		Connection c = null;
		Statement stmt = null;
		int rowsAffected = 0;
	
		try {
			//Connect to database
			c = DriverManager.getConnection(dbURL, username, password);
		//	System.out.println("Connection successful!");
		///	System.out.println("Connected to : " + dbURL);
		//	
			
			
			// create a SQL statement 
			stmt = c.createStatement();
			// execute the statemant
			rowsAffected = stmt.executeUpdate("update anacompute.user set admin = '1' where admin = '0'");
			
			// process the rows effected
			//System.out.println("Rows affected " + rowsAffected);
			
			
			
			
			
		} catch (SQLException e) {
			System.out.println("Connection unsuccessful!");
			e.printStackTrace();
		} finally {
			//close the connection
			try {
				stmt.close();
				
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
