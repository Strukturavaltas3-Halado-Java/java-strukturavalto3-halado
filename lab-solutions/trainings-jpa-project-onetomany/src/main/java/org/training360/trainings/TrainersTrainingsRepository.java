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
            actual.addTraining(training);
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
            return  em.createQuery("select trainer from Trainer trainer left join fetch trainer.trainings  training where training.trainer.id = :trainerId and not (training.endDate < :start OR training.startDate > :end)", Trainer.class)
                    .setParameter("trainerId", trainerId)
                    .setParameter("start", start)
                    .setParameter("end", end)
                    .getSingleResult();

        }finally {
            em.close();
        }
    }

    public void deleteTrainer(long trainerId){
        EntityManager entityManager = factory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Trainer trainer = entityManager.getReference(Trainer.class, trainerId);
            entityManager.remove(trainer);
            entityManager.getTransaction().commit();
        }finally {
            entityManager.close();
        }
    }


    public void updateTrainingWithPersistedStudent(long trainingId, long studentId){
        EntityManager em = factory.createEntityManager();
        try{
            em.getTransaction().begin();
            Training training = em.find(Training.class, trainingId);
            Student student = em.find(Student.class, studentId);
            training.addStudent(student);
            em.getTransaction().commit();
        }finally {
            em.close();
        }

    }


    public Training findTrainingWithStudents(long trainingId){
        EntityManager em = factory.createEntityManager();
        try{
            return em.createQuery("select training from Training training left join fetch training.students students where training.id = :id",Training.class)
                    .setParameter("id",trainingId)
                    .getSingleResult();
        }finally {
            em.close();
        }
    }

    public void deleteTrainingsTrainer(long trainingId){
        EntityManager entityManager = factory.createEntityManager();
        try{
            entityManager.getTransaction().begin();
            Training training = entityManager.find(Training.class,trainingId);
            training.setTrainer(null);
            entityManager.getTransaction().commit();
        }finally {
            entityManager.close();
        }
    }



}
