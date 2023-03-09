package com.toplomjer.toplomjer.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository {

    Patient findByUsernameAndPassword(String email, String password);

}