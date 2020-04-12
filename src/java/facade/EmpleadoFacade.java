/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Empleado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import beans.Empleado_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import beans.Cargo;
import beans.Plataforma;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> {

    @PersistenceContext(unitName = "loginPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }

    public boolean isCargoIdCargoEmpty(Empleado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empleado> empleado = cq.from(Empleado.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empleado, entity), cb.isNotNull(empleado.get(Empleado_.cargoIdCargo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Cargo findCargoIdCargo(Empleado entity) {
        return this.getMergedEntity(entity).getCargoIdCargo();
    }

    public boolean isPlataformaEmpty(Empleado entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empleado> empleado = cq.from(Empleado.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empleado, entity), cb.isNotNull(empleado.get(Empleado_.plataforma)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Plataforma findPlataforma(Empleado entity) {
        return this.getMergedEntity(entity).getPlataforma();
    }
    
}
