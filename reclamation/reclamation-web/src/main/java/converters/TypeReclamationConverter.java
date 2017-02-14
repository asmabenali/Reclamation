package converters;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import edu.app.reclamation.persistence.TypeReclamation;
import services.reclamation.ReclamationServiceLocal;

@ManagedBean(name="typeReclamationConverter")
public class TypeReclamationConverter implements Converter{
	
	@EJB
	private ReclamationServiceLocal reclamationServiceLocal;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		TypeReclamation eqTypeReclamation = null;
		System.out.println("vvv111 ****** : "+value);
		if (!value.trim().equals("")) {
			System.out.println("vvv222 ****** : "+value);
			eqTypeReclamation  = reclamationServiceLocal.chercherTypeReclamationParType(value);
			System.out.println("vvv333 ****** : "+eqTypeReclamation.getType());
		}
		return eqTypeReclamation;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		String eqString = null;
		if (value == null || value.equals("")) {
			eqString = "";
		}else{
			eqString = ((TypeReclamation)value).getType();
		}
		return eqString;
	}

}
