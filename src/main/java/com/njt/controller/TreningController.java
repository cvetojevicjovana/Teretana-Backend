/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.controller;

import com.njt.dto.TreningDTO;
import com.njt.entity.Trening;
import com.njt.service.TreningService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Roki
 */
@RestController
@RequestMapping("/trening")
@CrossOrigin
public class TreningController {

    @Autowired
    TreningService treningService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/all", method = GET)
    public List<TreningDTO> findAll() {
        List<Trening> treninzi = treningService.findAll();

        List<TreningDTO> treninziDTO = treninzi.stream()
                .map(trening -> modelMapper.map(trening, TreningDTO.class))
                .collect(Collectors.toList());

        return treninziDTO;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public TreningDTO findById(@PathVariable int id) {
        Trening trening = treningService.findById(id);
        TreningDTO treningDTO = modelMapper.map(trening, TreningDTO.class);
        return treningDTO;
    }

    @RequestMapping(value = "/new", method = POST)
    public Trening save(@RequestBody TreningDTO treningDTO) {
        Trening trening = modelMapper.map(treningDTO, Trening.class);
        treningService.saveOrUdate(trening);
        return trening;
    }

    @RequestMapping(value = "/update", method = PUT)
    public Trening update(@RequestBody TreningDTO treningDTO) {
        Trening trening = modelMapper.map(treningDTO, Trening.class);
        treningService.saveOrUdate(trening);
        return trening;
    }

    @RequestMapping(value = "/search", method = GET)
    public List<TreningDTO> search(@RequestParam(value = "id", required = false, defaultValue = "0") int id,
            @RequestParam(value = "naziv", required = false) String naziv,
            @RequestParam(value = "opis", required = false) String opis,
            @RequestParam(value = "cena", required = false, defaultValue = "0") double cena) {

        List<Trening> treninzi = treningService.search(id, naziv, opis, cena);
        List<TreningDTO> treninziDTO = treninzi.stream()
                .map(t -> modelMapper.map(t, TreningDTO.class))
                .collect(Collectors.toList());
        return treninziDTO;
    }

}
