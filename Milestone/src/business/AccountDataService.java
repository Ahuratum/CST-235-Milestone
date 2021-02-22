/**
 *  Interface for use with:
 *   - Passing account information
 *   - Updating account information
 */
package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.User;

/**
 * @author Nick
 */

@Stateless
@Local(AccountDataServiceInterface.class)
public class AccountDataService implements AccountDataServiceInterface {

	String dbURL = "jdbc:mysql://localhost:3306/anacompute?autoReconnect=true&useSSL=false";
	String username = "root";
	String password = "root";
	
	@Override
	public void test() {
		System.out.println("The AccountData object is working");
	}

	@Override
	public User retrieveUserData(String userName) {
		Connection c = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = new User();
		try {
			// Connection to database
			c = DriverManager.getConnection(dbURL, username, password);
			// create a SQL statement
			stmt = c.createStatement();
			// execute the statemant
			rs = stmt.executeQuery("select * from anacompute.user");
			
			while (rs.next()) {
				if (rs.getString("username").equals(userName)) {
					user.setUsername(rs.getString("userName").toString());
					user.setFirstName(rs.getString("firstName"));
					user.setLastName(rs.getString("lastName"));
					user.setPhoneNumber(rs.getString("phoneNumber"));
					user.setEmail(rs.getString("email"));
					user.setAddress(rs.getString("firstName"));
					user.setAdmin(Boolean.parseBoolean(rs.getString("admin")));
				}
			}
		} catch (SQLException e) { 
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
		return user;
	}

	@Override
	public void updateUserData(String userName) {
			
	}

	@Override
	public void deleteUser(String userName) {
		
	}

}
