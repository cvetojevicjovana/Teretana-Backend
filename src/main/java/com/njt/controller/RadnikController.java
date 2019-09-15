/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.controller;

import com.njt.dto.RadnikDTO;
import com.njt.entity.Radnik;
import com.njt.service.RadnikService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roki
 */
@RestController
@RequestMapping("/radnik")
@CrossOrigin
public class RadnikController {

    @Autowired
    RadnikService radnikService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/all", method = GET)
    public List<RadnikDTO> findAll() {
        List<Radnik> radnici = radnikService.findAll();

        List<RadnikDTO> radniciDTO = radnici.stream()
                .map(radnik -> modelMapper.map(radnik, RadnikDTO.class))
                .collect(Collectors.toList());

        return radniciDTO;

    }

    @RequestMapping(value = "/{id}", method = GET)
    public RadnikDTO findById(@PathVariable int id) {
        Radnik radnik = radnikService.findById(id);
        RadnikDTO radnikDTO = modelMapper.map(radnik, RadnikDTO.class);
        return radnikDTO;
    }

    @RequestMapping(value = "/username={username}", method = GET)
    public RadnikDTO findByUsername(@PathVariable String username) {
        Radnik radnik = radnikService.findByUsernamee(username);
        RadnikDTO radnikDTO = modelMapper.map(radnik, RadnikDTO.class);
        return radnikDTO;
    }

    @RequestMapping(value = "/login", method = GET)
    public RadnikDTO findByUsernameAndPassword(@RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password) {

        Radnik radnik = radnikService.findByUsernameAndPassword(username, password);
        RadnikDTO radnikDTO = modelMapper.map(radnik, RadnikDTO.class);
        return radnikDTO;
    }
}
