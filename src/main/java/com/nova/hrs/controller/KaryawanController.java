package com.nova.hrs.controller;

import com.nova.hrs.dao.KaryawanRepository;
import com.nova.hrs.entity.Karyawan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
}
