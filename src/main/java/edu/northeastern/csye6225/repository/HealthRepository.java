package edu.northeastern.csye6225.repository;

import edu.northeastern.csye6225.model.HealthCheck;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class HealthRepository {
    @PersistenceContext
    protected EntityManager entityManager;

    public void save(HealthCheck entity) {
        entityManager.persist(entity);
    }

    public void update(HealthCheck entity) {
        entityManager.merge(entity);
    }

    public void delete(HealthCheck entity) {
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}
