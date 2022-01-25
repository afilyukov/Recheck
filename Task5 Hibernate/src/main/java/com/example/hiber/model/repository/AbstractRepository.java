package com.example.hiber.model.repository;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractRepository<Entity, Id> {
    public AbstractRepository(EntityManager entityManager, Class<Entity> type) {
        this.entityManager = entityManager;
        this.type = type;
    }

    private final EntityManager entityManager;
    private final Class<Entity> type;


    public List<Entity> findAll() {
        return entityManager.createQuery("from " +type.getSimpleName(), type).getResultList();
    }

    public Entity findById(Id id) {
        return entityManager.createQuery("from " + type.getSimpleName() + " t where t.id = " + id, type).getSingleResult();
    }

    public void save(Entity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public void remove(Id id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findById(id));
        entityManager.getTransaction().commit();
    }
}
