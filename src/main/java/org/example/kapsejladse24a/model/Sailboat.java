package org.example.kapsejladse24a.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Sailboat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int boatID;
    private BoatType boatType;
    private String name;

    @OneToMany(mappedBy = "sailboat")
    private Set<Result> results = new HashSet<>();

    public int getBoatID() {
        return boatID;
    }

    public void setBoatID(int boatID) {
        this.boatID = boatID;
    }

    public BoatType getBoatType() {
        return boatType;
    }

    public void setBoatType(BoatType boatType) {
        this.boatType = boatType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
