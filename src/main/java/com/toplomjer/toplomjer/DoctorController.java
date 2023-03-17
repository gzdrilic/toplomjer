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
        List<User> patientList = userRepository.findByPermissionLevel(0);
        model.addAttribute("currUser", currUser);
        model.addAttribute("patientList", patientList);
        return "doctor-dashboard.html";
    }

    @GetMapping("/newPatient")
    public String addPatient(Model model, Long id) {
        currUser = userRepository.findById(id).get();
        model.addAttribute("currUser", currUser);
        return "add_patient.html";
    }


    @GetMapping("/savePatient")
    public String savePatient(String firstName, String lastName, String username, String password) {
        userRepository.save(new User(firstName, lastName, username, password, 0));
        return "redirect:/doctor-dashboard?id=" + currUser.getId();
    }

    /*  // PALLIATIVE TEAM METHODS
    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute(userRepository.findByType(0));
        return "palliativeTeam_patients.html";
       // tu sam sama napravila prvo svoj template, al je izbrisan, pa sam napravila
       novi doctor-dashboard, ali taj se ne spaja na bazu

        return "doctor-dashboard.html";
    }
*/

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
