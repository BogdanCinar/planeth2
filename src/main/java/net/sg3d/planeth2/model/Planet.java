package net.sg3d.planeth2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "planet")
public class Planet {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private Double gravity;

    private Double radius;

    public Planet() {
    }

    public Planet(String name, Double gravity, Double radius) {
        this.name = name;
        this.gravity = gravity;
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGravity() {
        return gravity;
    }

    public void setGravity(Double gravity) {
        this.gravity = gravity;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gravity=" + gravity +
                ", radius=" + radius +
                '}';
    }
}
