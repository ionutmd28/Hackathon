package persistence.entities;

import javax.persistence.*;

@Entity
@Table(name = "car", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_car" }) })
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_car", nullable = false, unique = true)
    private int idCar;

    @Column(name = "brand", nullable = false, unique = true)
    private String brand;

    @Column(name = "year", nullable = false)
    private int year;

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

}
