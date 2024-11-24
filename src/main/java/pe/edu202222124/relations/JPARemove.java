package pe.edu202222124.relations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu202222124.entity.Country;

public class JPARemove {

    public static void main(String[] args) {
        // Crear EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {
            // Buscar el país imaginario
            Country country = em.find(Country.class, "XYZ"); // "XYZ" es el código del país creado en JPAPersist

            if (country != null) {
                // Iniciar transacción y eliminar el país
                em.getTransaction().begin();
                em.remove(country); // Elimina el país y sus dependencias (ciudades y lenguajes)
                em.getTransaction().commit();

                System.out.println("País y sus dependencias eliminados correctamente.");
            } else {
                System.out.println("País no encontrado.");
            }

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println("Error al eliminar país: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}
