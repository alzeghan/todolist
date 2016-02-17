package com.todo.persistance.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> extends Serializable {

    /**
     * Save or updates the collection of entities.
     *
     * @param entities collection of entities
     */
    public void saveOrUpdateAll(Collection<T> entities);

    /**
     * Save or Update an entity.
     *
     * @param entity entity
     */
    public void saveOrUpdate(T entity);

    /**
     * Persist an entity.
     *
     * @param entity entity
     */
    public void save(T entity);

    /**
     * Delete an entity.
     *
     * @param entity entity to delete
     */
    public void delete(T entity);

    /**
     * Delete an entity.
     *
     * @param entityId entity identifier
     */
    public void delete(ID entityId);

    /**
     * Hard delete the collection of entities.
     *
     * @param entities - collection of entities.
     */
    public void deleteAll(Collection<T> entities);

    /**
     * merges the state of the managed or detached object
     *
     * @param entity - entity to be persisted
     * @return - merged entity
     */
    public T update(T entity);

    /**
     * Returns a list of entities for the specified entity class.
     *
     * @return list of all entities in database
     */
    public List<T> findAll();

    /**
     * Find an entity by its PK.
     *
     * @param entityId entity identifier
     * @return entity
     */
    public T findByPrimaryKey(ID entityId);

    /**
     * Find an entity by a unique key. Typically this is an external key, other than the primary key of that entity.
     *
     * @param key
     * @param value
     * @return the entity
     */
    T findByKey(String key, String value);

    List<T> findByKeyMultipleResults(String fieldName, Object value);

    /**
     * Find an entity by a unique key, regardless of case(upper/lower). Typically this is an external key, other than the primary key of that entity.
     *
     * @param key
     * @param value
     * @return the entity
     */
    T findByKeyEqualsIgnoreCase(String key, String value);

    List<T> findAllByKeyList(String key, List<String> values);
}