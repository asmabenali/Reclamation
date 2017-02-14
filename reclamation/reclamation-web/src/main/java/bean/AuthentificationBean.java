package bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import edu.app.reclamation.persistence.Administrateur;
import edu.app.reclamation.persistence.Etudiant;
import edu.app.reclamation.persistence.Utilisateur;
import services.authentification.AuthentificationServiceLocal;

@ManagedBean(name="auth")
public class AuthentificationBean {
	
// na3mloulu page farga pr tester 
	
	@EJB
	private AuthentificationServiceLocal authservice;
	
	@ManagedProperty("#{identityB}")
	private IdentityBean identity;
	
	private String email;
	private String password;


	public void setIdentity(IdentityBean identity) {
		this.identity = identity;
	}



	public AuthentificationServiceLocal getAuthservice() {
		return authservice;
	}



	public void setAuthservice(AuthentificationServiceLocal authservice) {
		this.authservice = authservice;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public AuthentificationBean(){
		
	}
	
	public String doLogin(){
		String navigateTo=null;
		System.out.println("eeeeee **** : "+ email);
		System.out.println("pppppp **** : "+ password);
		Utilisateur found = authservice.authentifier(email,password);		
			if(found !=null && found.isActif())
			{
				identity.setIdentifiedUser(found);
				if(found instanceof Administrateur)
				{
					navigateTo = "/administrateur/accueil?faces-redirect=true";
				}else if (found instanceof Etudiant) {
					navigateTo = "/etu/accueil?faces-redirect=true";
				}
				
			}else {
				FacesContext
				.getCurrentInstance()
				.addMessage(null, new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"NON AUTORISE",
						null
						
				))	;
				
			}
		return navigateTo;
		
	}
	public String doLogout(){
		String navigateTo = null;
		FacesContext.getCurrentInstance().getExternalContext()
		.getSessionMap().clear();
		navigateTo = "/login?faces-redirect=true";
		return navigateTo;
	}
	
}
