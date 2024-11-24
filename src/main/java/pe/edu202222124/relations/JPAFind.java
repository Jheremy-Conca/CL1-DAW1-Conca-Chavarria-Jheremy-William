package pe.edu202222124.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu202222124.entity.Country;
import pe.edu202222124.entity.City;

import java.util.List;

public class JPAFind {

    public static void main(String[] args) {
        // Crear EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {
            // Buscar el país por código "PER" (Perú)
            Country country = em.find(Country.class, "PER");

            if (country != null) {
                // Mostrar mensaje de país encontrado
                System.out.println("País encontrado.");

                // Filtrar y mostrar las ciudades con población > 700k usando lambda
                List<City> cities = country.getCities();
                cities.stream()
                        .filter(city -> city.getPopulation() > 700000) // Lambda para filtrar por población
                        .forEach(city -> System.out.println(city.getName())); // Imprimir el nombre de la ciudad

            } else {
                System.out.println("País no encontrado.");
            }

        } catch (Exception e) {
            System.err.println("Error al consultar país: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
