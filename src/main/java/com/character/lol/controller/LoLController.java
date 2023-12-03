package com.character.lol.controller;

import com.character.lol.dto.CharacterDto;
import com.character.lol.service.LoLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoLController {
    @Autowired
    LoLService service;

    @GetMapping("/add")
    public String add() {
        return "addView";
    }
    @PostMapping("/create")
    public ResponseEntity create(CharacterDto dto) {
        ResponseEntity result = service.create(dto);
        return result;
    }

    @GetMapping("/readall")
    public ResponseEntity readall(Model model) {
        ResponseEntity response = service.readAll();
        model.addAttribute(response);
        return response;
    }

}
