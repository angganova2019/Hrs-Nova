package com.nova.hrs.controller;

import com.nova.hrs.dao.KantorRepository;
import com.nova.hrs.entity.Kantor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@RequestMapping("/pengaturan")
public class BasicSettingController {

    @Autowired
    KantorRepository kantorRepository;

    @GetMapping
    public ModelMap index(Pageable pageable) {
        return new ModelMap().addAttribute("kantors", kantorRepository.findAll());
    }

    @PostMapping
    public String simpanPengaturan(@ModelAttribute @Valid Kantor kantor, BindingResult errors, SessionStatus status) {
        if (errors.hasErrors()){
            return "/pengaturan";
        }
        try{
            kantorRepository.save(kantor);
            status.setComplete();
            return "redirect:/pengaturan";
        } catch (DataAccessException e) {
            errors.reject("error.object", e.getMessage());
            return "/pengaturan";
        }
    }
}
