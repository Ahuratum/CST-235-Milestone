package controllers;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class NavigationController {
	
	public String onSubmit(String desiredLocation) {
		if (getLoggedName() == null || getLoggedName() == "Not Logged In") {
			desiredLocation = "Login.xhtml";
		}
		return desiredLocation;
	}
	public String adminOnSubmit(String desiredLocation) {
		if (LoginController.loggedUser.getAdmin() == false) {
			desiredLocation = "Home.xhtml";
		}
		return desiredLocation;
	}
	public String getLoggedName() {
		String sendUsernName = "Not Logged In";
		if (LoginController.loggedUser.getUsername() != null && LoginController.loggedUser.getUsername() != "") {
			return "Logged in as: " + LoginController.loggedUser.getUsername();
		} 
		return sendUsernName;
	}
}
