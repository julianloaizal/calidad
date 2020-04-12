package converter;

import beans.Empleado;
import facade.EmpleadoFacade;
import controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.convert.FacesConverter;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@FacesConverter(value = "empleadoConverter")
public class EmpleadoConverter implements Converter {

    private EmpleadoFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.getEjbFacade().find(getKey(value));
    }

    beans.EmpleadoPK getKey(String value) {
        beans.EmpleadoPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new beans.EmpleadoPK();
        key.setCc(values[0]);
        key.setPlatf(values[1]);
        return key;
    }

    String getStringKey(beans.EmpleadoPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getCc());
        sb.append(SEPARATOR);
        sb.append(value.getPlatf());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Empleado) {
            Empleado o = (Empleado) object;
            return getStringKey(o.getEmpleadoPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Empleado.class.getName()});
            return null;
        }
    }

    private EmpleadoFacade getEjbFacade() {
        this.ejbFacade = CDI.current().select(EmpleadoFacade.class).get();
        return this.ejbFacade;
    }
}
