package com.devsav.model.repository;

import org.springframework.data.repository.CrudRepository;
import com.devsav.model.entity.PeopleEntity;

import java.util.List;

public interface PeopleRepository extends CrudRepository<PeopleEntity, Long> {

    List<PeopleEntity> findAll();
    PeopleEntity findById(int id);

}
