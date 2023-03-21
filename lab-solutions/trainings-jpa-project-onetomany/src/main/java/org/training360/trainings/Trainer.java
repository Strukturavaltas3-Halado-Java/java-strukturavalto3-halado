package org.training360.trainings;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="trainers")
public class Trainer {

//    @TableGenerator(name ="Trainer_Gen",
//    table="ID_GEN",
//    pkColumnName = "GEN_NAME",
//    valueColumnName = "GEN_VALUE",
//    pkColumnValue = "Trainer_Gen",
//    initialValue = 1000,
//    allocationSize = 100)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "trainer", cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, orphanRemoval = true)
    private List<Training> trainings = new ArrayList<>();

    public Trainer(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    public Trainer(){}


    public void addTraining(Training training){
        trainings.add(training);
        training.setTrainer(this);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", trainings=" + trainings +
                '}';
    }
}
