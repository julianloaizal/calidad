package controller;

import beans.Plataforma;
import beans.Empleado;
import java.util.Collection;
import facade.PlataformaFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "plataformaController")
@ViewScoped
public class PlataformaController extends AbstractController<Plataforma> {

    @Inject
    private OperacionController operacionController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isEmpleadoCollectionEmpty;

    public PlataformaController() {
        // Inform the Abstract parent controller of the concrete Plataforma Entity
        super(Plataforma.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        operacionController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsEmpleadoCollectionEmpty();
    }

    public boolean getIsEmpleadoCollectionEmpty() {
        return this.isEmpleadoCollectionEmpty;
    }

    private void setIsEmpleadoCollectionEmpty() {
        Plataforma selected = this.getSelected();
        if (selected != null) {
            PlataformaFacade ejbFacade = (PlataformaFacade) this.getFacade();
            this.isEmpleadoCollectionEmpty = ejbFacade.isEmpleadoCollectionEmpty(selected);
        } else {
            this.isEmpleadoCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Empleado entities that
     * are retrieved from Plataforma and returns the navigation outcome.
     *
     * @return navigation outcome for Empleado page
     */
    public String navigateEmpleadoCollection() {
        Plataforma selected = this.getSelected();
        if (selected != null) {
            PlataformaFacade ejbFacade = (PlataformaFacade) this.getFacade();
            Collection<Empleado> selectedEmpleadoCollection = ejbFacade.findEmpleadoCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Empleado_items", selectedEmpleadoCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/empleado/index";
    }

    /**
     * Sets the "selected" attribute of the Operacion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareOperacion(ActionEvent event) {
        Plataforma selected = this.getSelected();
        if (selected != null && operacionController.getSelected() == null) {
            operacionController.setSelected(selected.getOperacion());
        }
    }

}
