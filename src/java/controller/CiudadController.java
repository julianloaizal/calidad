package controller;

import beans.Ciudad;
import beans.Avion;
import java.util.Collection;
import facade.CiudadFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "ciudadController")
@ViewScoped
public class CiudadController extends AbstractController<Ciudad> {

    @Inject
    private DepartamentoController idDepartamentoController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isAvionCollectionEmpty;

    public CiudadController() {
        // Inform the Abstract parent controller of the concrete Ciudad Entity
        super(Ciudad.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idDepartamentoController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsAvionCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the Departamento controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdDepartamento(ActionEvent event) {
        Ciudad selected = this.getSelected();
        if (selected != null && idDepartamentoController.getSelected() == null) {
            idDepartamentoController.setSelected(selected.getIdDepartamento());
        }
    }

    public boolean getIsAvionCollectionEmpty() {
        return this.isAvionCollectionEmpty;
    }

    private void setIsAvionCollectionEmpty() {
        Ciudad selected = this.getSelected();
        if (selected != null) {
            CiudadFacade ejbFacade = (CiudadFacade) this.getFacade();
            this.isAvionCollectionEmpty = ejbFacade.isAvionCollectionEmpty(selected);
        } else {
            this.isAvionCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Avion entities that are
     * retrieved from Ciudad and returns the navigation outcome.
     *
     * @return navigation outcome for Avion page
     */
    public String navigateAvionCollection() {
        Ciudad selected = this.getSelected();
        if (selected != null) {
            CiudadFacade ejbFacade = (CiudadFacade) this.getFacade();
            Collection<Avion> selectedAvionCollection = ejbFacade.findAvionCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Avion_items", selectedAvionCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/avion/index";
    }

}
