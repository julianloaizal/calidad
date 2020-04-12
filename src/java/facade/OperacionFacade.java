/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Operacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import beans.Operacion_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import beans.Plataforma;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class OperacionFacade extends AbstractFacade<Operacion> {

    @PersistenceContext(unitName = "loginPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OperacionFacade() {
        super(Operacion.class);
    }

    public boolean isPlataformaEmpty(Operacion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Operacion> operacion = cq.from(Operacion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(operacion, entity), cb.isNotNull(operacion.get(Operacion_.plataforma)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Plataforma findPlataforma(Operacion entity) {
        return this.getMergedEntity(entity).getPlataforma();
    }
    
}
