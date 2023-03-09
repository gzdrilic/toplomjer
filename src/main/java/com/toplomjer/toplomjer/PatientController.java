package com.toplomjer.toplomjer;

import com.toplomjer.toplomjer.model.PatientRepository;
import com.toplomjer.toplomjer.model.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {


    @Autowired
    PatientRepository patientRepository;


    RecordRepository recordRepository;

    @GetMapping("/login")
    public String processLogin(Model model,String username, String password) {
        if (patientRepository.findByUsernameAndPassword(username, password) != null) {

        }

    }



}
