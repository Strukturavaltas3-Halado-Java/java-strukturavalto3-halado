package org.training360.trainings;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.util.List;

public class TrainersTrainingsRepository {


    private EntityManagerFactory factory;

    public TrainersTrainingsRepository(EntityManagerFactory factory) {
        this.factory = factory;
    }

    public Trainer saveTrainer(Trainer trainer){
        EntityManager em = factory.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(trainer);
            em.getTransaction().commit();
            return trainer;
        }finally {
            em.close();
        }
    }


    public Training saveTrainingWithTrainer(long trainerId, Training training){
        EntityManager em = factory.createEntityManager();
        try{
            em.getTransaction().begin();
            Trainer actual = em.find(Trainer.class, trainerId);
            training.setTrainer(actual);
            em.persist(training);
            em.getTransaction().commit();
            return training;
        }finally {
            em.close();
        }
    }

    public Trainer findTrainerById(long trainerId){
        EntityManager em = factory.createEntityManager();
        try{
            Trainer trainer = em.find(Trainer.class, trainerId);
            return trainer;
        }finally {
            em.close();
        }
    }

    public Training findTrainingById(long trainingId){
        EntityManager em = factory.createEntityManager();
        try{
            return em.find(Training.class, trainingId);
        }finally {
            em.close();
        }
    }

    public Trainer findTrainingWithTrainerBetween(long trainerId, LocalDate start, LocalDate end){
        EntityManager em = factory.createEntityManager();
        try{
            return  em.createQuery("select trainer from Trainer trainer left join fetch trainer.trainings  training where training.trainer.id = :trainerId and (training.startDate between :start and :end) or (training.endDate between :start and :end)", Trainer.class)
                    .setParameter("trainerId", trainerId)
                    .setParameter("start", start)
                    .setParameter("end", end)
                    .getSingleResult();

        }finally {
            em.close();
        }
    }



}
