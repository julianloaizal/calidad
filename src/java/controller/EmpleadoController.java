package controller;

import beans.Empleado;
import facade.EmpleadoFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "empleadoController")
@ViewScoped
public class EmpleadoController extends AbstractController<Empleado> {

    @Inject
    private CargoController cargoIdCargoController;
    @Inject
    private PlataformaController plataformaController;
    @Inject
    private MobilePageController mobilePageController;

    public EmpleadoController() {
        // Inform the Abstract parent controller of the concrete Empleado Entity
        super(Empleado.class);
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setEmpleadoPK(new beans.EmpleadoPK());
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        cargoIdCargoController.setSelected(null);
        plataformaController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Cargo controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareCargoIdCargo(ActionEvent event) {
        Empleado selected = this.getSelected();
        if (selected != null && cargoIdCargoController.getSelected() == null) {
            cargoIdCargoController.setSelected(selected.getCargoIdCargo());
        }
    }

    /**
     * Sets the "selected" attribute of the Plataforma controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void preparePlataforma(ActionEvent event) {
        Empleado selected = this.getSelected();
        if (selected != null && plataformaController.getSelected() == null) {
            plataformaController.setSelected(selected.getPlataforma());
        }
    }

}
