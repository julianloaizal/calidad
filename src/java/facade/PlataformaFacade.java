/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Plataforma;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import beans.Plataforma_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import beans.Empleado;
import beans.Operacion;
import java.util.Collection;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class PlataformaFacade extends AbstractFacade<Plataforma> {

    @PersistenceContext(unitName = "loginPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlataformaFacade() {
        super(Plataforma.class);
    }

    public boolean isEmpleadoCollectionEmpty(Plataforma entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Plataforma> plataforma = cq.from(Plataforma.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(plataforma, entity), cb.isNotEmpty(plataforma.get(Plataforma_.empleadoCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Empleado> findEmpleadoCollection(Plataforma entity) {
        Plataforma mergedEntity = this.getMergedEntity(entity);
        Collection<Empleado> empleadoCollection = mergedEntity.getEmpleadoCollection();
        empleadoCollection.size();
        return empleadoCollection;
    }

    public boolean isOperacionEmpty(Plataforma entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Plataforma> plataforma = cq.from(Plataforma.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(plataforma, entity), cb.isNotNull(plataforma.get(Plataforma_.operacion)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Operacion findOperacion(Plataforma entity) {
        return this.getMergedEntity(entity).getOperacion();
    }
    
}
