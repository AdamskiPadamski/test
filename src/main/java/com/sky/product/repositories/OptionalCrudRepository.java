package com.sky.product.repositories;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by Adam on 14/08/2016.
 */
@NoRepositoryBean
public interface OptionalCrudRepository<T, ID extends Serializable> extends Repository<T, ID> {

    <S extends T> S save(S var1);

    <S extends T> List<S> save(Iterable<S> var1);

    Optional<T> findOne(ID var1);

    boolean exists(ID var1);

    List<T> findAll();

    List<T> findAll(Iterable<ID> var1);

    long count();

    void delete(ID var1);

    void delete(T var1);

    void delete(Iterable<? extends T> var1);

    void deleteAll();
}
