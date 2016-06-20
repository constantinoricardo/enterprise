package br.com.constantino.enterprise.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.constantino.enterprise.dao.EstabelecimentoDAO;
import br.com.constantino.enterprise.entities.Estabelecimento;

@FacesConverter(value = "estabelecimentoConverter", forClass = Estabelecimento.class)
public class EstabelecimentoConverter implements Converter, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (!value.equals("")) {
			Integer id = Integer.valueOf(value);
			return new EstabelecimentoDAO().buscarPorId(id);
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
