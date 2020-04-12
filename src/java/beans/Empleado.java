/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author COMPUTADOR
 */
@Entity
@Table(catalog = "gestion_aeropuerto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByCc", query = "SELECT e FROM Empleado e WHERE e.empleadoPK.cc = :cc")
    , @NamedQuery(name = "Empleado.findByFechaIngreo", query = "SELECT e FROM Empleado e WHERE e.fechaIngreo = :fechaIngreo")
    , @NamedQuery(name = "Empleado.findByPeso", query = "SELECT e FROM Empleado e WHERE e.peso = :peso")
    , @NamedQuery(name = "Empleado.findByEstatura", query = "SELECT e FROM Empleado e WHERE e.estatura = :estatura")
    , @NamedQuery(name = "Empleado.findByPlatf", query = "SELECT e FROM Empleado e WHERE e.empleadoPK.platf = :platf")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoPK empleadoPK;
    @Size(max = 45)
    @Column(name = "fecha_ingreo")
    private String fechaIngreo;
    private Short peso;
    private Short estatura;
    @JoinColumn(name = "cargo_id_cargo", referencedColumnName = "idcargo")
    @ManyToOne
    private Cargo cargoIdCargo;
    @JoinColumn(name = "plataforma", referencedColumnName = "idplat")
    @ManyToOne(optional = false)
    private Plataforma plataforma;

    public Empleado() {
    }

    public Empleado(EmpleadoPK empleadoPK) {
        this.empleadoPK = empleadoPK;
    }

    public Empleado(String cc, String platf) {
        this.empleadoPK = new EmpleadoPK(cc, platf);
    }

    public EmpleadoPK getEmpleadoPK() {
        return empleadoPK;
    }

    public void setEmpleadoPK(EmpleadoPK empleadoPK) {
        this.empleadoPK = empleadoPK;
    }

    public String getFechaIngreo() {
        return fechaIngreo;
    }

    public void setFechaIngreo(String fechaIngreo) {
        this.fechaIngreo = fechaIngreo;
    }

    public Short getPeso() {
        return peso;
    }

    public void setPeso(Short peso) {
        this.peso = peso;
    }

    public Short getEstatura() {
        return estatura;
    }

    public void setEstatura(Short estatura) {
        this.estatura = estatura;
    }

    public Cargo getCargoIdCargo() {
        return cargoIdCargo;
    }

    public void setCargoIdCargo(Cargo cargoIdCargo) {
        this.cargoIdCargo = cargoIdCargo;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoPK != null ? empleadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.empleadoPK == null && other.empleadoPK != null) || (this.empleadoPK != null && !this.empleadoPK.equals(other.empleadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Empleado[ empleadoPK=" + empleadoPK + " ]";
    }
    
}
