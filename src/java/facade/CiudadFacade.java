/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Ciudad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import beans.Ciudad_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import beans.Departamento;
import beans.Avion;
import java.util.Collection;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class CiudadFacade extends AbstractFacade<Ciudad> {

    @PersistenceContext(unitName = "loginPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CiudadFacade() {
        super(Ciudad.class);
    }

    public boolean isIdDepartamentoEmpty(Ciudad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ciudad, entity), cb.isNotNull(ciudad.get(Ciudad_.idDepartamento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Departamento findIdDepartamento(Ciudad entity) {
        return this.getMergedEntity(entity).getIdDepartamento();
    }

    public boolean isAvionCollectionEmpty(Ciudad entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ciudad> ciudad = cq.from(Ciudad.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ciudad, entity), cb.isNotEmpty(ciudad.get(Ciudad_.avionCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Avion> findAvionCollection(Ciudad entity) {
        Ciudad mergedEntity = this.getMergedEntity(entity);
        Collection<Avion> avionCollection = mergedEntity.getAvionCollection();
        avionCollection.size();
        return avionCollection;
    }
    
}
