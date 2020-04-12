/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author COMPUTADOR
 */
@Entity
@Table(catalog = "gestion_aeropuerto", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plataforma.findAll", query = "SELECT p FROM Plataforma p")
    , @NamedQuery(name = "Plataforma.findByIdplat", query = "SELECT p FROM Plataforma p WHERE p.idplat = :idplat")
    , @NamedQuery(name = "Plataforma.findByCobroxhora", query = "SELECT p FROM Plataforma p WHERE p.cobroxhora = :cobroxhora")
    , @NamedQuery(name = "Plataforma.findByImpuesto", query = "SELECT p FROM Plataforma p WHERE p.impuesto = :impuesto")})
public class Plataforma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String idplat;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double cobroxhora;
    private Double impuesto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plataforma")
    private Collection<Empleado> empleadoCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "plataforma")
    private Operacion operacion;

    public Plataforma() {
    }

    public Plataforma(String idplat) {
        this.idplat = idplat;
    }

    public String getIdplat() {
        return idplat;
    }

    public void setIdplat(String idplat) {
        this.idplat = idplat;
    }

    public Double getCobroxhora() {
        return cobroxhora;
    }

    public void setCobroxhora(Double cobroxhora) {
        this.cobroxhora = cobroxhora;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    @XmlTransient
    public Collection<Empleado> getEmpleadoCollection() {
        return empleadoCollection;
    }

    public void setEmpleadoCollection(Collection<Empleado> empleadoCollection) {
        this.empleadoCollection = empleadoCollection;
    }

    public Operacion getOperacion() {
        return operacion;
    }

    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplat != null ? idplat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plataforma)) {
            return false;
        }
        Plataforma other = (Plataforma) object;
        if ((this.idplat == null && other.idplat != null) || (this.idplat != null && !this.idplat.equals(other.idplat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Plataforma[ idplat=" + idplat + " ]";
    }
    
}
