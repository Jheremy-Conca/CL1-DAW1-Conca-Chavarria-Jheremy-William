package pe.edu202222124.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryLanguagePK implements Serializable {

    private String CountryCode;
    private String Language;

    // Constructor vacío
    public CountryLanguagePK() {}

    // Constructor completo
    public CountryLanguagePK(String countryCode, String language) {
        this.CountryCode = countryCode;
        this.Language = language;
    }

    // Getters y setters
    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        this.CountryCode = countryCode;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        this.Language = language;
    }

    // hashCode y equals para claves compuestas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguagePK that = (CountryLanguagePK) o;
        return Objects.equals(CountryCode, that.CountryCode) &&
                Objects.equals(Language, that.Language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CountryCode, Language);
    }
}
