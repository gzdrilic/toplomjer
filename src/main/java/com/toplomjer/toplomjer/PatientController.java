package com.toplomjer.toplomjer;

import com.toplomjer.toplomjer.model.Patient;
import com.toplomjer.toplomjer.model.PatientRepository;
import com.toplomjer.toplomjer.model.Record;
import com.toplomjer.toplomjer.model.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {


    @Autowired
    PatientRepository patientRepository;

    @Autowired
    RecordRepository recordRepository;

    Patient currPatient;

    @GetMapping("/login")
    public String processLogin(Model model,String username, String password) {
        Patient currPatient = patientRepository.findByUsernameAndPassword(username, password);
        if ( currPatient != null) {
            model.addAttribute("patient", currPatient);
            return "patient.html";
        } else {
            return "pacijent-slider.html";
        }

    }

    /* */

    @GetMapping("/addRecord")
    public String addRecord(Model model, int painLevel, int id) {
        Record newRecord = new Record(patientRepository.findById(id), painLevel);
        recordRepository.save(newRecord);
        return "checkmark_temp.html";
    }



}
