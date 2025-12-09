package org.example.kapsejladse24a.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resultID;

    private int position;

    private int point;

    private boolean finished;

    @ManyToOne
    @JoinColumn(name = "boatidfk", referencedColumnName = "boatID")
    private Sailboat sailboat;

    public int getResultID() {
        return resultID;
    }

    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Sailboat getSailboat() {
        return sailboat;
    }

    public void setSailboat(Sailboat sailboat) {
        this.sailboat = sailboat;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return resultID == result.resultID;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(resultID);
    }
}
