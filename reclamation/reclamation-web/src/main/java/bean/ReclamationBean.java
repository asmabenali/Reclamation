package bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import edu.app.reclamation.persistence.Etudiant;
import edu.app.reclamation.persistence.Reclamation;
import edu.app.reclamation.persistence.TypeReclamation;
import services.reclamation.ReclamationServiceLocal;

@ManagedBean(name="claim")
public class ReclamationBean {
	
	
	
	@EJB 
	private ReclamationServiceLocal claimservice;
	
	@ManagedProperty("#{identityB.identifiedUser}")
	private Etudiant etudiant; 
	private Reclamation claim; 
	
	private List<Reclamation> reclamations;
	
	private List<TypeReclamation> types;
	
	
	public ReclamationBean(){}
	
	@PostConstruct
	public void init(){
		claim = new Reclamation();
		reclamations= claimservice.listerReclamationParEtudiant(etudiant);
		types= claimservice.listerTypeReclamations();
	}

	
	public String doAddClaim(){
		String navigateTo=null;
		claim.setEtudiant(etudiant);
		claimservice.ajouterReclamation(claim);
		reclamations= claimservice.listerReclamationParEtudiant(etudiant);
		claim=new Reclamation();
		return navigateTo;
		
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Reclamation getClaim() {
		return claim;
	}

	public void setClaim(Reclamation claim) {
		this.claim = claim;
	}

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public List<TypeReclamation> getTypes() {
		return types;
	}

	public void setTypes(List<TypeReclamation> types) {
		this.types = types;
	}
	
	
	
	
	
}
