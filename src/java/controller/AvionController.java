package controller;

import beans.Avion;
import facade.AvionFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "avionController")
@ViewScoped
public class AvionController extends AbstractController<Avion> {

    @Inject
    private CiudadController ciudadController;
    @Inject
    private MobilePageController mobilePageController;

    public AvionController() {
        // Inform the Abstract parent controller of the concrete Avion Entity
        super(Avion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        ciudadController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Ciudad controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCiudad(ActionEvent event) {
        Avion selected = this.getSelected();
        if (selected != null && ciudadController.getSelected() == null) {
            ciudadController.setSelected(selected.getCiudad());
        }
    }

}
