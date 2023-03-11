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
    public String showDashboard(Model model, long id) {
        currUser = userRepository.findById(id);
        List<Record> recordsList = recordRepository.findByPatient(currUser);
        model.addAttribute("currUser", currUser);
        model.addAttribute("recordsList", recordsList);
        return "patient-dashboard.html";
    }


    /* */

    @GetMapping("/addRecord")
    public String addRecord(Model model, int painLevel, int id) {
        Record newRecord = new Record(userRepository.findById(id), painLevel);
        recordRepository.save(newRecord);
        return "checkmark_temp.html";
    }



}
