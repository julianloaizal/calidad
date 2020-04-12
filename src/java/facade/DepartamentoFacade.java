/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Departamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import beans.Departamento_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import beans.Ciudad;
import beans.Pais;
import java.util.Collection;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class DepartamentoFacade extends AbstractFacade<Departamento> {

    @PersistenceContext(unitName = "loginPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DepartamentoFacade() {
        super(Departamento.class);
    }

    public boolean isCiudadCollectionEmpty(Departamento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Departamento> departamento = cq.from(Departamento.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(departamento, entity), cb.isNotEmpty(departamento.get(Departamento_.ciudadCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Ciudad> findCiudadCollection(Departamento entity) {
        Departamento mergedEntity = this.getMergedEntity(entity);
        Collection<Ciudad> ciudadCollection = mergedEntity.getCiudadCollection();
        ciudadCollection.size();
        return ciudadCollection;
    }

    public boolean isPaisNombreEmpty(Departamento entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Departamento> departamento = cq.from(Departamento.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(departamento, entity), cb.isNotNull(departamento.get(Departamento_.paisNombre)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Pais findPaisNombre(Departamento entity) {
        return this.getMergedEntity(entity).getPaisNombre();
    }
    
}
