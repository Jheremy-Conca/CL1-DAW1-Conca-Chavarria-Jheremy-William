package pe.edu202222124.entity;

import jakarta.persistence.*;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String Name;

    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;  // Relación con Country, esta está correcta


    private String District;
    private Integer Population;

    public City() {
    }

    public City(String Name, Country country, String District, Integer Population) {
        this.Name = Name;
        this.country = country;
        this.District = District;
        this.Population = Population;
    }

    @Override
    public String toString() {
        return "City{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", District='" + District + '\'' +
                ", Population=" + Population +
                '}';
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String District) {
        this.District = District;
    }

    public Integer getPopulation() {
        return Population;
    }

    public void setPopulation(Integer Population) {
        this.Population = Population;
    }
}
