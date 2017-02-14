package services.authentification;

import java.util.List;

import javax.ejb.Local;

import edu.app.reclamation.persistence.Etudiant;
import edu.app.reclamation.persistence.Utilisateur;



@Local
public interface AuthentificationServiceLocal {
	public Utilisateur authentifier(String login, String pwd);

	boolean existeEmail(String login);

	void sauvegarderUtilisateur(Utilisateur utilisateur);
	
	List<Etudiant> listerEtudiants();
}
