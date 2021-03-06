package controllers;


import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import beans.User;
import business.UserBusinessServiceInterface;

@ManagedBean
public class LoginController {
	
	public static User loggedUser = new User();
    @Inject
    UserBusinessServiceInterface UDBC;
    
    int attempts = 3;
	public String onSubmit() {
		String register = "CreateAccount.xhtml";
		String success = "Home.xhtml";
		String incorrect = "Login.xhtml";
		String decided = "";
		//Get the user value from the input form;
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		// Send the information to the POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
			boolean check = UDBC.check(user.getUsername(), user.getPassword());
			if (check) {
				loggedUser.setUsername(user.getUsername());
				decided = success;
			} else {
				decided = incorrect;
				attempts--;
				//System.out.println(attempts);
				if (attempts < 0) {
					decided = register;
					attempts = 3;
				}
			}
		return decided;
	}
}
