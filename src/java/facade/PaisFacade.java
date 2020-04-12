/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import beans.Pais;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import beans.Pais_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import beans.Departamento;
import java.util.Collection;

/**
 *
 * @author COMPUTADOR
 */
@Stateless
public class PaisFacade extends AbstractFacade<Pais> {

    @PersistenceContext(unitName = "loginPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaisFacade() {
        super(Pais.class);
    }

    public boolean isDepartamentoCollectionEmpty(Pais entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Pais> pais = cq.from(Pais.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(pais, entity), cb.isNotEmpty(pais.get(Pais_.departamentoCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Departamento> findDepartamentoCollection(Pais entity) {
        Pais mergedEntity = this.getMergedEntity(entity);
        Collection<Departamento> departamentoCollection = mergedEntity.getDepartamentoCollection();
        departamentoCollection.size();
        return departamentoCollection;
    }
    
}
