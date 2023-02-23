package org.training360.trainings;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TrainersTrainingsRepositoryTest {

    TrainersTrainingsRepository repository;
    EntityManagerFactory factory;

    @BeforeEach
    void init(){
        factory = Persistence.createEntityManagerFactory("pu");
        repository = new TrainersTrainingsRepository(factory);
    }

    @AfterEach
    void close(){
        //factory.close();
    }

    @Test
    void saveTrainer(){
       Trainer result = repository.saveTrainer(new Trainer("John",Status.MEDIOR));

       assertTrue(result.getId()!=null);
    }

    @Test
    void testSaveTrainingWithTrainerId(){
        Trainer trainer = repository.saveTrainer(new Trainer("John",Status.MEDIOR));
        Training training = repository.saveTrainingWithTrainer(
                trainer.getId(),
                new Training("Java", LocalDate.parse("2022-09-03"),LocalDate.parse("2023-04-26")));

        Training result = repository.findTrainingById(training.getId());

        assertTrue(result.getId()!=null);
        assertEquals("John", result.getTrainer().getName());

    }

    @Test
    void testFindTrainerWithTrainingsBetween(){
        Trainer trainer = repository.saveTrainer(new Trainer("John",Status.MEDIOR));
        repository.saveTrainingWithTrainer(
                trainer.getId(),
                new Training("Java", LocalDate.parse("2022-09-03"),LocalDate.parse("2023-04-26")));

        repository.saveTrainingWithTrainer(
                trainer.getId(),
                new Training("Java Halado", LocalDate.parse("2020-09-01"),LocalDate.parse("2021-04-26")));

        Trainer result = repository.findTrainingWithTrainerBetween(trainer.getId(),LocalDate.parse("2022-08-15"),LocalDate.parse("2022-09-05"));

        assertEquals(1, result.getTrainings().size());

        assertEquals("Java", result.getTrainings().get(0).getTitle());
    }


    @Test
    void findTrainerById(){
        Trainer trainer = repository.saveTrainer(new Trainer("John",Status.MEDIOR));
        Trainer result = repository.findTrainerById(trainer.getId());

        //assertEquals(0,result.getTrainings().size());

    }


}