/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Avion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import beans.Avion_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import beans.Ciudad;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class AvionFacade extends AbstractFacade<Avion> {

    @PersistenceContext(unitName = "loginPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AvionFacade() {
        super(Avion.class);
    }

    public boolean isCiudadEmpty(Avion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Avion> avion = cq.from(Avion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(avion, entity), cb.isNotNull(avion.get(Avion_.ciudad)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Ciudad findCiudad(Avion entity) {
        return this.getMergedEntity(entity).getCiudad();
    }
    
}
