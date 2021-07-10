package com.currylandia.currylandia.repository;

import com.currylandia.currylandia.domain.Restaurant;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RestaurantRepository implements JpaRepository<Restaurant, Long> {
    List<Restaurant> restaurants;

    public RestaurantRepository(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public List<Restaurant> findAll() {
        return null;
    }

    @Override
    public List<Restaurant> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Restaurant> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Restaurant> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Restaurant entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Restaurant> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Restaurant> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Restaurant> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Restaurant> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Restaurant> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Restaurant> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Restaurant> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Restaurant getOne(Long aLong) {
        return null;
    }

    @Override
    public Restaurant getById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Restaurant> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Restaurant> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Restaurant> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Restaurant> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Restaurant> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Restaurant> boolean exists(Example<S> example) {
        return false;
    }
}
