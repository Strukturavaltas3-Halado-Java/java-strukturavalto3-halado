package org.training360.musicians;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.util.List;

public class BandsMusiciansRepository {

    private EntityManagerFactory factory;

    public BandsMusiciansRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public Band saveBand(Band band) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(band);
            em.getTransaction().commit();
            return band;
        } finally {
            em.close();
        }
    }

    public Band findBandById(long bandId) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(Band.class, bandId);
        } finally {
            em.close();
        }
    }

    public Musician updateBandWithMusician(long bandId, Musician musician) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            Band band = em.find(Band.class, bandId);
            em.persist(musician);
            musician.setBand(band);
            em.getTransaction().commit();
            return musician;
        } finally {
            em.close();
        }
    }

    public Band findBandWithAllMusicians(long bandId) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createQuery("select b from Band b left join fetch b.musicians where b.id =:bandId", Band.class)
                    .setParameter("bandId", bandId)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    public void deleteMusicianById(long musicianId) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            Musician musician = em.getReference(Musician.class, musicianId);
            em.remove(musician);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public Band findBandWithAlbumsAfter(LocalDate date) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createQuery("select b from Band b left join fetch b.discography a where a.releaseDate >= :date", Band.class)
                    .setParameter("date", date)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Band> findBandsWithMusicianName(String name) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createQuery("select b from Band b left join fetch b.musicians m where m.name like :name", Band.class)
                    .setParameter("name", "%" + name + "%")
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
