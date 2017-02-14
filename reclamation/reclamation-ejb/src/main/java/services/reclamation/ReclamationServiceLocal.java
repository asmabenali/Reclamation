package services.reclamation;

import java.util.List;

import javax.ejb.Local;

import edu.app.reclamation.persistence.Etudiant;
import edu.app.reclamation.persistence.Reclamation;
import edu.app.reclamation.persistence.TypeReclamation;
@Local
public interface ReclamationServiceLocal {
	 void ajouterReclamation(Reclamation reclamation);
	 void ajouterTypeReclamation(TypeReclamation typeReclamation);
	 List<Reclamation> listerReclamations();
	 List<TypeReclamation> listerTypeReclamations();
	 boolean existeTypeReclalamtion(String type);
	 TypeReclamation chercherTypeReclamationParType(String type);
	 List<Reclamation> listerReclamationParEtudiant(Etudiant etudiant);
}
