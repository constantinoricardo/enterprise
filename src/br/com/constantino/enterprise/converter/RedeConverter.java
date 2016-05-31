package br.com.constantino.enterprise.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.constantino.enterprise.dao.RedeDAO;
import br.com.constantino.enterprise.entities.Rede;

@FacesConverter(value="redeConverter", forClass=Rede.class) 
public class RedeConverter implements Converter, Serializable {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (!value.equals("")) {
			Integer id = Integer.valueOf(value);
			return new RedeDAO().buscarPeloCodigo(id);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && !"".equals(value)) {

			SampleEntity entity = (SampleEntity) value;

			Integer codigo = entity.getId();
			if (codigo != null) {
				return String.valueOf(codigo);
			}
		}

		return (String) value;
	}

}
