package com.toplomjer.toplomjer;

import com.toplomjer.toplomjer.model.User;
import com.toplomjer.toplomjer.model.UserRepository;
import com.toplomjer.toplomjer.model.Record;
import com.toplomjer.toplomjer.model.RecordRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
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
    public String showForm1(Model model, Long id, HttpSession session) {
        currUser = userRepository.findById(id).get();
        model.addAttribute("currUser", currUser);
        Record record = new Record();
        record.setPatient(currUser);
        session.setAttribute("record", record);

        return "form-1.html";
    }

    //forma za razinu boli
    @GetMapping("/form-2")
    public String showForm2(Model model, int emotionLevel, HttpSession session) {
        Record record = (Record) session.getAttribute("record");
        if (emotionLevel < 20) {
            record.setEmotionLevel(1);

        } else if(emotionLevel < 40){
            record.setEmotionLevel(2);
        } else if(emotionLevel < 60){
            record.setEmotionLevel(3);
        }else if(emotionLevel < 80){
            record.setEmotionLevel(4);
        }else {
            record .setEmotionLevel(5);
        }
        record.setDate(new Date());
        model.addAttribute("currUser", record.getPatient());
        return "form-2.html";
    }

    //forma za unos teksta ako pacijenti zele, neobavezno, ovdje se nalazi form koji submite na server
    @GetMapping("/form-3")
    public String showForm3(Model model, int painLevel, HttpSession session) {
        Record record = (Record) session.getAttribute("record");
        model.addAttribute("currUser", record.getPatient());
        record.setPainLevel(painLevel);
        return "form-3.html";
    }
    @GetMapping("/form-end")
    public String formEnd(Model model, String text, HttpSession session) {
        Record record = (Record) session.getAttribute("record");
        record.setText(text);
        record.setDate(new Date());
        recordRepository.save(record);
        return "redirect:/patient-dashboard?id=" + record.getPatient().getId();

    }

    /* */



}
