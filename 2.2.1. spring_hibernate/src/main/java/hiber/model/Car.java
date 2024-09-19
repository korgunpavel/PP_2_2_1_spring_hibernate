package hiber.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "series")
    private int series;

    @Column(name = "model")
    private String model;

    @OneToOne(mappedBy = "car")
    private User owner;

    public Car() {
    }

    public Car(User owner, int series, String model) {
        this.owner = owner;
        this.series = series;
        this.model = model;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "owner=" + owner +
                ", series=" + series +
                ", model='" + model + '\'' +
                '}';
    }
}
