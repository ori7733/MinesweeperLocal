/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import DataBase.exceptions.IllegalOrphanException;
import DataBase.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Ori
 */
public class FavoriteSizeJpaController implements Serializable {

    public FavoriteSizeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FavoriteSize favoriteSize) {
        if (favoriteSize.getGamesCollection() == null) {
            favoriteSize.setGamesCollection(new ArrayList<Games>());
        }
        if (favoriteSize.getGamesCollection1() == null) {
            favoriteSize.setGamesCollection1(new ArrayList<Games>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users userID = favoriteSize.getUserID();
            if (userID != null) {
                userID = em.getReference(userID.getClass(), userID.getId());
                favoriteSize.setUserID(userID);
            }
            Collection<Games> attachedGamesCollection = new ArrayList<Games>();
            for (Games gamesCollectionGamesToAttach : favoriteSize.getGamesCollection()) {
                gamesCollectionGamesToAttach = em.getReference(gamesCollectionGamesToAttach.getClass(), gamesCollectionGamesToAttach.getId());
                attachedGamesCollection.add(gamesCollectionGamesToAttach);
            }
            favoriteSize.setGamesCollection(attachedGamesCollection);
            Collection<Games> attachedGamesCollection1 = new ArrayList<Games>();
            for (Games gamesCollection1GamesToAttach : favoriteSize.getGamesCollection1()) {
                gamesCollection1GamesToAttach = em.getReference(gamesCollection1GamesToAttach.getClass(), gamesCollection1GamesToAttach.getId());
                attachedGamesCollection1.add(gamesCollection1GamesToAttach);
            }
            favoriteSize.setGamesCollection1(attachedGamesCollection1);
            em.persist(favoriteSize);
            if (userID != null) {
                userID.getFavoriteSizeCollection().add(favoriteSize);
                userID = em.merge(userID);
            }
            for (Games gamesCollectionGames : favoriteSize.getGamesCollection()) {
                FavoriteSize oldColumnsOfGamesCollectionGames = gamesCollectionGames.getColumns();
                gamesCollectionGames.setColumns(favoriteSize);
                gamesCollectionGames = em.merge(gamesCollectionGames);
                if (oldColumnsOfGamesCollectionGames != null) {
                    oldColumnsOfGamesCollectionGames.getGamesCollection().remove(gamesCollectionGames);
                    oldColumnsOfGamesCollectionGames = em.merge(oldColumnsOfGamesCollectionGames);
                }
            }
            for (Games gamesCollection1Games : favoriteSize.getGamesCollection1()) {
                FavoriteSize oldRowsOfGamesCollection1Games = gamesCollection1Games.getRows();
                gamesCollection1Games.setRows(favoriteSize);
                gamesCollection1Games = em.merge(gamesCollection1Games);
                if (oldRowsOfGamesCollection1Games != null) {
                    oldRowsOfGamesCollection1Games.getGamesCollection1().remove(gamesCollection1Games);
                    oldRowsOfGamesCollection1Games = em.merge(oldRowsOfGamesCollection1Games);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FavoriteSize favoriteSize) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FavoriteSize persistentFavoriteSize = em.find(FavoriteSize.class, favoriteSize.getId());
            Users userIDOld = persistentFavoriteSize.getUserID();
            Users userIDNew = favoriteSize.getUserID();
            Collection<Games> gamesCollectionOld = persistentFavoriteSize.getGamesCollection();
            Collection<Games> gamesCollectionNew = favoriteSize.getGamesCollection();
            Collection<Games> gamesCollection1Old = persistentFavoriteSize.getGamesCollection1();
            Collection<Games> gamesCollection1New = favoriteSize.getGamesCollection1();
            List<String> illegalOrphanMessages = null;
            for (Games gamesCollectionOldGames : gamesCollectionOld) {
                if (!gamesCollectionNew.contains(gamesCollectionOldGames)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Games " + gamesCollectionOldGames + " since its columns field is not nullable.");
                }
            }
            for (Games gamesCollection1OldGames : gamesCollection1Old) {
                if (!gamesCollection1New.contains(gamesCollection1OldGames)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Games " + gamesCollection1OldGames + " since its rows field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (userIDNew != null) {
                userIDNew = em.getReference(userIDNew.getClass(), userIDNew.getId());
                favoriteSize.setUserID(userIDNew);
            }
            Collection<Games> attachedGamesCollectionNew = new ArrayList<Games>();
            for (Games gamesCollectionNewGamesToAttach : gamesCollectionNew) {
                gamesCollectionNewGamesToAttach = em.getReference(gamesCollectionNewGamesToAttach.getClass(), gamesCollectionNewGamesToAttach.getId());
                attachedGamesCollectionNew.add(gamesCollectionNewGamesToAttach);
            }
            gamesCollectionNew = attachedGamesCollectionNew;
            favoriteSize.setGamesCollection(gamesCollectionNew);
            Collection<Games> attachedGamesCollection1New = new ArrayList<Games>();
            for (Games gamesCollection1NewGamesToAttach : gamesCollection1New) {
                gamesCollection1NewGamesToAttach = em.getReference(gamesCollection1NewGamesToAttach.getClass(), gamesCollection1NewGamesToAttach.getId());
                attachedGamesCollection1New.add(gamesCollection1NewGamesToAttach);
            }
            gamesCollection1New = attachedGamesCollection1New;
            favoriteSize.setGamesCollection1(gamesCollection1New);
            favoriteSize = em.merge(favoriteSize);
            if (userIDOld != null && !userIDOld.equals(userIDNew)) {
                userIDOld.getFavoriteSizeCollection().remove(favoriteSize);
                userIDOld = em.merge(userIDOld);
            }
            if (userIDNew != null && !userIDNew.equals(userIDOld)) {
                userIDNew.getFavoriteSizeCollection().add(favoriteSize);
                userIDNew = em.merge(userIDNew);
            }
            for (Games gamesCollectionNewGames : gamesCollectionNew) {
                if (!gamesCollectionOld.contains(gamesCollectionNewGames)) {
                    FavoriteSize oldColumnsOfGamesCollectionNewGames = gamesCollectionNewGames.getColumns();
                    gamesCollectionNewGames.setColumns(favoriteSize);
                    gamesCollectionNewGames = em.merge(gamesCollectionNewGames);
                    if (oldColumnsOfGamesCollectionNewGames != null && !oldColumnsOfGamesCollectionNewGames.equals(favoriteSize)) {
                        oldColumnsOfGamesCollectionNewGames.getGamesCollection().remove(gamesCollectionNewGames);
                        oldColumnsOfGamesCollectionNewGames = em.merge(oldColumnsOfGamesCollectionNewGames);
                    }
                }
            }
            for (Games gamesCollection1NewGames : gamesCollection1New) {
                if (!gamesCollection1Old.contains(gamesCollection1NewGames)) {
                    FavoriteSize oldRowsOfGamesCollection1NewGames = gamesCollection1NewGames.getRows();
                    gamesCollection1NewGames.setRows(favoriteSize);
                    gamesCollection1NewGames = em.merge(gamesCollection1NewGames);
                    if (oldRowsOfGamesCollection1NewGames != null && !oldRowsOfGamesCollection1NewGames.equals(favoriteSize)) {
                        oldRowsOfGamesCollection1NewGames.getGamesCollection1().remove(gamesCollection1NewGames);
                        oldRowsOfGamesCollection1NewGames = em.merge(oldRowsOfGamesCollection1NewGames);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = favoriteSize.getId();
                if (findFavoriteSize(id) == null) {
                    throw new NonexistentEntityException("The favoriteSize with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FavoriteSize favoriteSize;
            try {
                favoriteSize = em.getReference(FavoriteSize.class, id);
                favoriteSize.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The favoriteSize with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Games> gamesCollectionOrphanCheck = favoriteSize.getGamesCollection();
            for (Games gamesCollectionOrphanCheckGames : gamesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This FavoriteSize (" + favoriteSize + ") cannot be destroyed since the Games " + gamesCollectionOrphanCheckGames + " in its gamesCollection field has a non-nullable columns field.");
            }
            Collection<Games> gamesCollection1OrphanCheck = favoriteSize.getGamesCollection1();
            for (Games gamesCollection1OrphanCheckGames : gamesCollection1OrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This FavoriteSize (" + favoriteSize + ") cannot be destroyed since the Games " + gamesCollection1OrphanCheckGames + " in its gamesCollection1 field has a non-nullable rows field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Users userID = favoriteSize.getUserID();
            if (userID != null) {
                userID.getFavoriteSizeCollection().remove(favoriteSize);
                userID = em.merge(userID);
            }
            em.remove(favoriteSize);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FavoriteSize> findFavoriteSizeEntities() {
        return findFavoriteSizeEntities(true, -1, -1);
    }

    public List<FavoriteSize> findFavoriteSizeEntities(int maxResults, int firstResult) {
        return findFavoriteSizeEntities(false, maxResults, firstResult);
    }

    private List<FavoriteSize> findFavoriteSizeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FavoriteSize.class));
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

    public FavoriteSize findFavoriteSize(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FavoriteSize.class, id);
        } finally {
            em.close();
        }
    }

    public int getFavoriteSizeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FavoriteSize> rt = cq.from(FavoriteSize.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
