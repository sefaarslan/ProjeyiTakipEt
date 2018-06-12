package projetakip.converter;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import projetakip.bean.ProjeBean;
import projetakip.model.Durum;
 
 
@FacesConverter("durumConverter")
public class DurumConverter implements Converter {
 
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	ProjeBean service = (ProjeBean) fc.getExternalContext().getSessionMap().get("projeBean");
            	int id = Integer.parseInt(value);
            	return getMyDurum(id,service.getDurumList());
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid durum."));
            }
        }
        else {
            return null;
        }
    }
 
    private Object getMyDurum(int id, List<Durum> durumList) {
    	for (Durum durum : durumList) {
			if(durum.getId() == id)
				return durum;
		}
    	return null;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Durum) object).getId());
        }
        else {
            return null;
        }
    }   
}         
