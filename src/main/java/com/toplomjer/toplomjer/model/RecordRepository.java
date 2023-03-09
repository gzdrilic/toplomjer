package com.toplomjer.toplomjer.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecordRepository extends CrudRepository {


    List<Record> findByPatient(Patient patient);

}