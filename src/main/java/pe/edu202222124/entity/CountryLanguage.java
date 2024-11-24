package pe.edu202222124.entity;

import jakarta.persistence.*;

@Entity
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguagePK id;  // Asegúrate de que esto esté como clave primaria compuesta

    @ManyToOne
    @MapsId("CountryCode")  // Asocia la clave compuesta a la entidad Country
    @JoinColumn(name = "CountryCode", nullable = false)

    private Country country;

    private String IsOfficial;
    private Double Percentage;

    public CountryLanguage() {
    }


    public CountryLanguage(CountryLanguagePK id, Country country, String isOfficial, Double percentage) {
        this.id = id;
        this.country = country;
        IsOfficial = isOfficial;
        Percentage = percentage;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "id=" + id +
                ", IsOfficial='" + IsOfficial + '\'' +
                ", Percentage=" + Percentage +
                '}';
    }

    public CountryLanguagePK getId() {
        return id;
    }

    public void setId(CountryLanguagePK id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getIsOfficial() {
        return IsOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        IsOfficial = isOfficial;
    }

    public Double getPercentage() {
        return Percentage;
    }

    public void setPercentage(Double percentage) {
        Percentage = percentage;
    }
}
