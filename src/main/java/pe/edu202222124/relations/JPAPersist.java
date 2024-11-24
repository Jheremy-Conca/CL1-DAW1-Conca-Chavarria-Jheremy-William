package pe.edu202222124.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import pe.edu202222124.entity.Country;
import pe.edu202222124.entity.City;
import pe.edu202222124.entity.CountryLanguage;
import pe.edu202222124.entity.CountryLanguagePK;

import java.util.Arrays;

public class JPAPersist {

    public static void main(String[] args) {
        // Crear EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {
            // Crear el país
            Country country = new Country("XYZ", "Imaginaria", "Oceania", "Islas Fantásticas",
                    1200.50, 2024, 1000000, 75.5, 5000.00, 4500.00,
                    "Fantasia", "Monarquía", "Rey Imaginario", 1, "XY");

            // Crear ciudades
            City city1 = new City("Ciudad Uno", country, "Distrito Uno", 300000);
            City city2 = new City("Ciudad Dos", country, "Distrito Dos", 400000);
            City city3 = new City("Ciudad Tres", country, "Distrito Tres", 300000);

            // Crear lenguajes
            CountryLanguage language1 = new CountryLanguage(
                    new CountryLanguagePK(country.getCode(), "Idioma Uno"),
                    country,
                    "T",
                    60.0
            );

            CountryLanguage language2 = new CountryLanguage(
                    new CountryLanguagePK(country.getCode(), "Idioma Dos"),
                    country,
                    "T",
                    40.0
            );

            // Relacionar datos al país
            country.setCities(Arrays.asList(city1, city2, city3));
            country.setLanguages(Arrays.asList(language1, language2));

            // Persistir los datos
            em.getTransaction().begin();
            em.persist(country);
            em.getTransaction().commit();

            System.out.println("País registrado correctamente.");
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error al registrar país: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
