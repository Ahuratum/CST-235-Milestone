/**
 *  Interface for use with:
 *   - Passing account information
 *   - Updating account information 
 */
package business;

import java.sql.SQLException;

import javax.ejb.Local;
import beans.User;

/**
 * @author Nick
 *
 */

@Local
public interface AccountDataServiceInterface {
	
	public void test();
	public User retrieveUserData(String userName);
	public void updateUserData(String userName);
	public void deleteUser(String userName);
}
