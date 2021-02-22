/**
 * Bean handles the user account object
 */
package beans;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Nick
 *
 */
public class Account {
	
	private User user;
	private Map<String, String> securityQuestion;
	private ArrayList<String> securityQuestions;
	private ArrayList<Product> cart;
	private ArrayList<Orders> orders;
	
	public Account() {
		
	}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the securityQuestion
	 */
	public Map<String, String> getSecurityQuestion() {
		return securityQuestion;
	}

	/**
	 * @param securityQuestion the securityQuestion to set
	 */
	public void setSecurityQuestion(Map<String, String> securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	/**
	 * @return the securityQuestions
	 */
	public ArrayList<String> getSecurityQuestions() {
		return securityQuestions;
	}

	/**
	 * @param securityQuestions the securityQuestions to set
	 */
	public void setSecurityQuestions(ArrayList<String> securityQuestions) {
		this.securityQuestions = securityQuestions;
	}

	/**
	 * @return the cart
	 */
	public ArrayList<Product> getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(ArrayList<Product> cart) {
		this.cart = cart;
	}

	/**
	 * @return the orders
	 */
	public ArrayList<Orders> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(ArrayList<Orders> orders) {
		this.orders = orders;
	}
	
	
}
