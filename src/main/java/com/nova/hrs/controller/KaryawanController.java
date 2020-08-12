package com.nova.hrs.controller;

import com.nova.hrs.dao.KaryawanRepository;
import com.nova.hrs.entity.Karyawan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/karyawan")
public class KaryawanController {

    @Autowired
    private KaryawanRepository karyawanRepository;

    @GetMapping
    public String index(Pageable pageable, Model model) {
        Page<Karyawan> listKry = karyawanRepository.findAll(pageable);
        model.addAttribute("listKaryawan", listKry);
        return "karyawan/index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("karyawan", new Karyawan());
        return "karyawan/form";
    }

    @PostMapping("/add")
    public String simpanKaryawan(@ModelAttribute @Valid Karyawan karyawan, BindingResult errors, SessionStatus status) {
        log.info("Data Karyawan telah tersimpan");

        if (errors.hasErrors()){
            return "/karyawan/add";
        }
        try{
            karyawanRepository.save(karyawan);
            status.setComplete();
            return "redirect:/karyawan";
        } catch (DataAccessException e) {
            errors.reject("error.object", e.getMessage());
            return "/karyawan/add";
        }
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        return "karyawan/form";
    }
}
