package pe.edu202222124.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Country {

    @Id
    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private Double SurfaceArea;
    private Integer IndepYear;
    private Integer Population;
    private Double LifeExpectancy;
    private Double GNP;
    private Double GNPOld;
    private String LocalName;
    private String GovernmentForm;
    private String HeadOfState;
    private Integer Capital;
    private String Code2;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CountryLanguage> languages;

    public Country() {
    }

    // Constructor con todos los parámetros
    public Country(String code, String name, String continent, String region, Double surfaceArea,
                   Integer indepYear, Integer population, Double lifeExpectancy, Double gnp, Double gnpOld,
                   String localName, String governmentForm, String headOfState, Integer capital, String code2) {
        this.Code = code;
        this.Name = name;
        this.Continent = continent;
        this.Region = region;
        this.SurfaceArea = surfaceArea;
        this.IndepYear = indepYear;
        this.Population = population;
        this.LifeExpectancy = lifeExpectancy;
        this.GNP = gnp;
        this.GNPOld = gnpOld;
        this.LocalName = localName;
        this.GovernmentForm = governmentForm;
        this.HeadOfState = headOfState;
        this.Capital = capital;
        this.Code2 = code2;
    }

    @Override

    public String toString() {
        return "Country{" +
                "Code2='" + Code2 + '\'' +
                ", Capital=" + Capital +
                ", HeadOfState='" + HeadOfState + '\'' +
                ", GovernmentForm='" + GovernmentForm + '\'' +
                ", LocalName='" + LocalName + '\'' +
                ", GNPOld=" + GNPOld +
                ", GNP=" + GNP +
                ", LifeExpectancy=" + LifeExpectancy +
                ", Population=" + Population +
                ", IndepYear=" + IndepYear +
                ", SurfaceArea=" + SurfaceArea +
                ", Region='" + Region + '\'' +
                ", Continent='" + Continent + '\'' +
                ", Name='" + Name + '\'' +
                ", Code='" + Code + '\'' +
                '}';
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContinent() {
        return Continent;
    }

    public void setContinent(String Continent) {
        this.Continent = Continent;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public Double getSurfaceArea() {
        return SurfaceArea;
    }

    public void setSurfaceArea(Double SurfaceArea) {
        this.SurfaceArea = SurfaceArea;
    }

    public Integer getIndepYear() {
        return IndepYear;
    }

    public void setIndepYear(Integer IndepYear) {
        this.IndepYear = IndepYear;
    }

    public Integer getPopulation() {
        return Population;
    }

    public void setPopulation(Integer Population) {
        this.Population = Population;
    }

    public Double getLifeExpectancy() {
        return LifeExpectancy;
    }

    public void setLifeExpectancy(Double LifeExpectancy) {
        this.LifeExpectancy = LifeExpectancy;
    }

    public Double getGNP() {
        return GNP;
    }

    public void setGNP(Double GNP) {
        this.GNP = GNP;
    }

    public Double getGNPOld() {
        return GNPOld;
    }

    public void setGNPOld(Double GNPOld) {
        this.GNPOld = GNPOld;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public List<CountryLanguage> getLanguages() {
        return languages;
    }

    public void setLanguages(List<CountryLanguage> languages) {
        this.languages = languages;
    }
}

