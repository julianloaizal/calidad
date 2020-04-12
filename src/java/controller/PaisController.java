package controller;

import beans.Pais;
import beans.Departamento;
import java.util.Collection;
import facade.PaisFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "paisController")
@ViewScoped
public class PaisController extends AbstractController<Pais> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isDepartamentoCollectionEmpty;

    public PaisController() {
        // Inform the Abstract parent controller of the concrete Pais Entity
        super(Pais.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsDepartamentoCollectionEmpty();
    }

    public boolean getIsDepartamentoCollectionEmpty() {
        return this.isDepartamentoCollectionEmpty;
    }

    private void setIsDepartamentoCollectionEmpty() {
        Pais selected = this.getSelected();
        if (selected != null) {
            PaisFacade ejbFacade = (PaisFacade) this.getFacade();
            this.isDepartamentoCollectionEmpty = ejbFacade.isDepartamentoCollectionEmpty(selected);
        } else {
            this.isDepartamentoCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Departamento entities
     * that are retrieved from Pais and returns the navigation outcome.
     *
     * @return navigation outcome for Departamento page
     */
    public String navigateDepartamentoCollection() {
        Pais selected = this.getSelected();
        if (selected != null) {
            PaisFacade ejbFacade = (PaisFacade) this.getFacade();
            Collection<Departamento> selectedDepartamentoCollection = ejbFacade.findDepartamentoCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Departamento_items", selectedDepartamentoCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/departamento/index";
    }

}
