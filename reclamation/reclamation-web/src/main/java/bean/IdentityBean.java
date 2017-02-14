package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.app.reclamation.persistence.Administrateur;
import edu.app.reclamation.persistence.Etudiant;
import edu.app.reclamation.persistence.Utilisateur;



@ManagedBean(name="identityB")
@SessionScoped
public class IdentityBean {
	
	private Utilisateur identifiedUser;
	
	public IdentityBean(){}

	public Utilisateur getIdentifiedUser() {
		return identifiedUser;
	}

	public void setIdentifiedUser(Utilisateur identifiedUser) {
		this.identifiedUser = identifiedUser;
	}
	
	public Boolean hasRole(String role) {
		Boolean response = false;
		switch (role) {
		case "Admin":
			response = identifiedUser instanceof Administrateur;
			break;
		case "Etu":
			response = identifiedUser instanceof Etudiant;
			break;
		}
		return response;
	}


}
