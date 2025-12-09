package org.example.kapsejladse24a.controller;

import org.example.kapsejladse24a.model.Result;
import org.example.kapsejladse24a.model.Sailboat;
import org.example.kapsejladse24a.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("results")
public class ResultRestController {

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping
    private List<Result> findAll(){
        return resultRepository.findAll();
    }


}
