package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import edu.app.reclamation.persistence.Etudiant;
import services.authentification.AuthentificationServiceLocal;

@ManagedBean(name="account")
@ViewScoped
public class AccountsBean {

	@EJB
	private AuthentificationServiceLocal authservice;
	
	private List<Etudiant> etudiants; 
	
	private Etudiant selectedEtudiant;

	public AuthentificationServiceLocal getAuthservice() {
		return authservice;
	}

	public void setAuthservice(AuthentificationServiceLocal authservice) {
		this.authservice = authservice;
	}

	public List<Etudiant> getEtudiants() {
		return etudiants;
	}

	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	public Etudiant getSelectedEtudiant() {
		return selectedEtudiant;
	}

	public void setSelectedEtudiant(Etudiant selectedEtudiant) {
		this.selectedEtudiant = selectedEtudiant;
	}
	
	public AccountsBean()
	{
		
	}
	
	@PostConstruct
	public void init(){
		
		etudiants = authservice.listerEtudiants();
	}
	
	public String doDesactivateCompte(Etudiant etudiant)
	{
		String navigateTo="null";
		if(etudiant.isActif())
		{
			etudiant.setActif(false);
		}
		else {
			etudiant.setActif(true);
		}
		authservice.sauvegarderUtilisateur(etudiant);
		etudiants= authservice.listerEtudiants();
		
		return navigateTo;
		
	}
	
}
