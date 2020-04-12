/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author COMPUTADOR
 */
@Embeddable
public class EmpleadoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String cc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    private String platf;

    public EmpleadoPK() {
    }

    public EmpleadoPK(String cc, String platf) {
        this.cc = cc;
        this.platf = platf;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getPlatf() {
        return platf;
    }

    public void setPlatf(String platf) {
        this.platf = platf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cc != null ? cc.hashCode() : 0);
        hash += (platf != null ? platf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoPK)) {
            return false;
        }
        EmpleadoPK other = (EmpleadoPK) object;
        if ((this.cc == null && other.cc != null) || (this.cc != null && !this.cc.equals(other.cc))) {
            return false;
        }
        if ((this.platf == null && other.platf != null) || (this.platf != null && !this.platf.equals(other.platf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.EmpleadoPK[ cc=" + cc + ", platf=" + platf + " ]";
    }
    
}
