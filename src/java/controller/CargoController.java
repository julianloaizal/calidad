package controller;

import beans.Cargo;
import beans.Empleado;
import java.util.Collection;
import facade.CargoFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "cargoController")
@ViewScoped
public class CargoController extends AbstractController<Cargo> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isEmpleadoCollectionEmpty;

    public CargoController() {
        // Inform the Abstract parent controller of the concrete Cargo Entity
        super(Cargo.class);
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
        Cargo selected = this.getSelected();
        if (selected != null) {
            CargoFacade ejbFacade = (CargoFacade) this.getFacade();
            this.isEmpleadoCollectionEmpty = ejbFacade.isEmpleadoCollectionEmpty(selected);
        } else {
            this.isEmpleadoCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Empleado entities that
     * are retrieved from Cargo and returns the navigation outcome.
     *
     * @return navigation outcome for Empleado page
     */
    public String navigateEmpleadoCollection() {
        Cargo selected = this.getSelected();
        if (selected != null) {
            CargoFacade ejbFacade = (CargoFacade) this.getFacade();
            Collection<Empleado> selectedEmpleadoCollection = ejbFacade.findEmpleadoCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Empleado_items", selectedEmpleadoCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/empleado/index";
    }

}
