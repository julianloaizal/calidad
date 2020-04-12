package controller;

import beans.Departamento;
import beans.Ciudad;
import java.util.Collection;
import facade.DepartamentoFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "departamentoController")
@ViewScoped
public class DepartamentoController extends AbstractController<Departamento> {

    @Inject
    private PaisController paisNombreController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isCiudadCollectionEmpty;

    public DepartamentoController() {
        // Inform the Abstract parent controller of the concrete Departamento Entity
        super(Departamento.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        paisNombreController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsCiudadCollectionEmpty();
    }

    public boolean getIsCiudadCollectionEmpty() {
        return this.isCiudadCollectionEmpty;
    }

    private void setIsCiudadCollectionEmpty() {
        Departamento selected = this.getSelected();
        if (selected != null) {
            DepartamentoFacade ejbFacade = (DepartamentoFacade) this.getFacade();
            this.isCiudadCollectionEmpty = ejbFacade.isCiudadCollectionEmpty(selected);
        } else {
            this.isCiudadCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Ciudad entities that are
     * retrieved from Departamento and returns the navigation outcome.
     *
     * @return navigation outcome for Ciudad page
     */
    public String navigateCiudadCollection() {
        Departamento selected = this.getSelected();
        if (selected != null) {
            DepartamentoFacade ejbFacade = (DepartamentoFacade) this.getFacade();
            Collection<Ciudad> selectedCiudadCollection = ejbFacade.findCiudadCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Ciudad_items", selectedCiudadCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/ciudad/index";
    }

    /**
     * Sets the "selected" attribute of the Pais controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePaisNombre(ActionEvent event) {
        Departamento selected = this.getSelected();
        if (selected != null && paisNombreController.getSelected() == null) {
            paisNombreController.setSelected(selected.getPaisNombre());
        }
    }

}
