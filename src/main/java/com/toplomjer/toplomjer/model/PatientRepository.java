package com.toplomjer.toplomjer.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    Patient findByUsernameAndPassword(String username, String password);

    Patient findById(long id);

}