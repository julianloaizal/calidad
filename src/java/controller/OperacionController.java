package controller;

import beans.Operacion;
import facade.OperacionFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "operacionController")
@ViewScoped
public class OperacionController extends AbstractController<Operacion> {

    @Inject
    private PlataformaController plataformaController;
    @Inject
    private MobilePageController mobilePageController;

    public OperacionController() {
        // Inform the Abstract parent controller of the concrete Operacion Entity
        super(Operacion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        plataformaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Plataforma controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePlataforma(ActionEvent event) {
        Operacion selected = this.getSelected();
        if (selected != null && plataformaController.getSelected() == null) {
            plataformaController.setSelected(selected.getPlataforma());
        }
    }

}
