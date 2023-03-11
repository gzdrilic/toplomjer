package com.toplomjer.toplomjer;

import com.toplomjer.toplomjer.model.Record;
import com.toplomjer.toplomjer.model.RecordRepository;
import com.toplomjer.toplomjer.model.User;
import com.toplomjer.toplomjer.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RecordRepository recordRepository;

    User currUser;


    //Ovdje pretpostavljam da ce svi doktori imati ovlasti vidjeti sve pacijente i njihove zapise

    @GetMapping("/doctor-dashboard")
    public String showDashboard(Model model, Long id) {
        currUser = userRepository.findById(id).get();
        List<User> patientList = userRepository.findByPermissionLevel(1);
        model.addAttribute("currUser", currUser);
        model.addAttribute("patientList", patientList);
        return "doctor-dashboard.html";
    }


    @GetMapping("/showPatientRecords")
    public String showPatientRecords(Model model, Long id) {
        User currSelectedPatient = userRepository.findById(id).get();
        List<Record> recordsList = recordRepository.findByPatient(currSelectedPatient);
        model.addAttribute("currUser", currUser);
        model.addAttribute("currPatient", currSelectedPatient);
        model.addAttribute("recordsList", recordsList);
        return "patient-records.html";
    }


}
