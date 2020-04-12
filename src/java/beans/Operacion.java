/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "Operacion.findAll", query = "SELECT o FROM Operacion o")
    , @NamedQuery(name = "Operacion.findByIdoperacion", query = "SELECT o FROM Operacion o WHERE o.idoperacion = :idoperacion")
    , @NamedQuery(name = "Operacion.findByProveedor", query = "SELECT o FROM Operacion o WHERE o.proveedor = :proveedor")
    , @NamedQuery(name = "Operacion.findByCantidadCombustible", query = "SELECT o FROM Operacion o WHERE o.cantidadCombustible = :cantidadCombustible")
    , @NamedQuery(name = "Operacion.findByPrecioxlibra", query = "SELECT o FROM Operacion o WHERE o.precioxlibra = :precioxlibra")
    , @NamedQuery(name = "Operacion.findByPrecioTotal", query = "SELECT o FROM Operacion o WHERE o.precioTotal = :precioTotal")})
public class Operacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String idoperacion;
    @Size(max = 45)
    private String proveedor;
    @Size(max = 45)
    @Column(name = "cantidad_combustible")
    private String cantidadCombustible;
    private Integer precioxlibra;
    @Column(name = "precio_total")
    private Integer precioTotal;
    @JoinColumn(name = "idoperacion", referencedColumnName = "idplat", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Plataforma plataforma;

    public Operacion() {
    }

    public Operacion(String idoperacion) {
        this.idoperacion = idoperacion;
    }

    public String getIdoperacion() {
        return idoperacion;
    }

    public void setIdoperacion(String idoperacion) {
        this.idoperacion = idoperacion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getCantidadCombustible() {
        return cantidadCombustible;
    }

    public void setCantidadCombustible(String cantidadCombustible) {
        this.cantidadCombustible = cantidadCombustible;
    }

    public Integer getPrecioxlibra() {
        return precioxlibra;
    }

    public void setPrecioxlibra(Integer precioxlibra) {
        this.precioxlibra = precioxlibra;
    }

    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
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
        hash += (idoperacion != null ? idoperacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operacion)) {
            return false;
        }
        Operacion other = (Operacion) object;
        if ((this.idoperacion == null && other.idoperacion != null) || (this.idoperacion != null && !this.idoperacion.equals(other.idoperacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.Operacion[ idoperacion=" + idoperacion + " ]";
    }
    
}
