/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

import SQL.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Ori
 */
public class BombsLocationJpaController implements Serializable {

    public BombsLocationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BombsLocation bombsLocation) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bombsLocation);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BombsLocation bombsLocation) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bombsLocation = em.merge(bombsLocation);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = bombsLocation.getId();
                if (findBombsLocation(id) == null) {
                    throw new NonexistentEntityException("The bombsLocation with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            BombsLocation bombsLocation;
            try {
                bombsLocation = em.getReference(BombsLocation.class, id);
                bombsLocation.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bombsLocation with id " + id + " no longer exists.", enfe);
            }
            em.remove(bombsLocation);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BombsLocation> findBombsLocationEntities() {
        return findBombsLocationEntities(true, -1, -1);
    }

    public List<BombsLocation> findBombsLocationEntities(int maxResults, int firstResult) {
        return findBombsLocationEntities(false, maxResults, firstResult);
    }

    private List<BombsLocation> findBombsLocationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BombsLocation.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public BombsLocation findBombsLocation(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BombsLocation.class, id);
        } finally {
            em.close();
        }
    }

    public int getBombsLocationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BombsLocation> rt = cq.from(BombsLocation.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
