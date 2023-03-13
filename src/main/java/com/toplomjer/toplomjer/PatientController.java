package com.toplomjer.toplomjer;

import com.toplomjer.toplomjer.model.User;
import com.toplomjer.toplomjer.model.UserRepository;
import com.toplomjer.toplomjer.model.Record;
import com.toplomjer.toplomjer.model.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PatientController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    RecordRepository recordRepository;

    User currUser;

    @GetMapping("/patient-dashboard")
    public String showDashboard(Model model, Long id) {
        currUser = userRepository.findById(id).get();
        List<Record> recordsList = recordRepository.findByPatient(currUser);
        model.addAttribute("currUser", currUser);
        model.addAttribute("recordsList", recordsList);
        return "patient-dashboard.html";
    }

    //forma za emoji osjecaja
    @GetMapping("/form-1")
    public String showForm1(Model model, Long id) {
        currUser = userRepository.findById(id).get();
        model.addAttribute("currUser", currUser);
        return "form-1.html";
    }

    //forma za razinu boli
    @GetMapping("/form-2")
    public String showForm2(Model model, Long id, int emotionLevel) {
        return "form-2.html";
    }

    //forma za unos teksta ako pacijenti zele, neobavezno, ovdje se nalazi form koji submite na server
    @GetMapping("/form-3")
    public String showForm3(Model model, Long id, int emotionLevel, int painLevel) {
        return "form-3.html";
    }

    /* */

    @GetMapping("/addRecord")
    public String addRecord(Model model, int painLevel, Long id) {
        Record newRecord = new Record(userRepository.findById(id).get(), painLevel);
        recordRepository.save(newRecord);
        return "checkmark_temp.html";
    }



}
