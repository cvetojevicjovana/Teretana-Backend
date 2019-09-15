/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.controller;

import com.njt.dto.ClanskaKartaDTO;
import com.njt.dto.TerminDTO;
import com.njt.entity.ClanskaKarta;
import com.njt.entity.Termin;
import com.njt.entity.TerminID;
import com.njt.service.ClanskaKartaService;
import java.util.ArrayList;
import java.util.List;
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
@RequestMapping("/clanskaKarta")
@CrossOrigin
public class ClanskaKartaController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ClanskaKartaService clanskaKartaService;

    @RequestMapping(value = "/all", method = GET)
    public List<ClanskaKartaDTO> findAll() {
        List<ClanskaKarta> clanskeKarte = clanskaKartaService.findAll();

        List<ClanskaKartaDTO> clanskeKarteDTO = new ArrayList<>();
        for (ClanskaKarta clanskaKarta : clanskeKarte) {
            clanskeKarteDTO.add(mapiraj(clanskaKarta));
        }
        return clanskeKarteDTO;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public ClanskaKartaDTO findById(@PathVariable int id) {
        ClanskaKarta clanskaKarta = clanskaKartaService.findById(id);
        ClanskaKartaDTO clanskaKartaDTO = mapiraj(clanskaKarta);
        return clanskaKartaDTO;
    }

    @RequestMapping(value = "/new", method = POST)
    public ClanskaKartaDTO save(@RequestBody ClanskaKartaDTO clanskaKartaDTO) {
        ClanskaKarta clanskaKarta = modelMapper.map(clanskaKartaDTO, ClanskaKarta.class);
        for (Termin termin : clanskaKarta.getTermini()) {
            termin.setTerminID(new TerminID(0, clanskaKartaDTO.getTermini().get(clanskaKarta.getTermini().indexOf(termin)).getTerminID().getRedniBroj()));
        }
        clanskaKarta = clanskaKartaService.saveOrUpdate(clanskaKarta);
        return mapiraj(clanskaKarta);
    }

    @RequestMapping(value = "/update/{id}", method = PUT)
    public ClanskaKartaDTO update(@RequestBody ClanskaKartaDTO clanskaKartaDTO, @PathVariable int id) {
        ClanskaKarta clanskaKarta = modelMapper.map(clanskaKartaDTO, ClanskaKarta.class);

        if (clanskaKarta.getTermini() != null) {
            for (Termin termin : clanskaKarta.getTermini()) {
                termin.setTerminID(new TerminID(id, clanskaKartaDTO.getTermini().get(clanskaKarta.getTermini().indexOf(termin)).getTerminID().getRedniBroj()));
            }
        }
        clanskaKarta = clanskaKartaService.saveOrUpdate(clanskaKarta);
        return mapiraj(clanskaKarta);
    }

    @RequestMapping(value = "/search", method = GET)
    public List<ClanskaKartaDTO> search(@RequestParam(value = "korisnik", required = false) String korisnik,
            @RequestParam(value = "trening", required = false) String trening,
            @RequestParam(value = "status", required = false) String status) {

        List<ClanskaKarta> clanskeKarte = clanskaKartaService.search(korisnik, trening, status);

        List<ClanskaKartaDTO> clanskeKarteDTO = new ArrayList<>();

        for (ClanskaKarta clanskaKarta : clanskeKarte) {
            clanskeKarteDTO.add(mapiraj(clanskaKarta));
        }
        return clanskeKarteDTO;
    }

    private ClanskaKartaDTO mapiraj(ClanskaKarta clanskaKarta) {

        ClanskaKartaDTO clanskaKartaDTO = modelMapper.map(clanskaKarta, ClanskaKartaDTO.class);

        if (clanskaKarta.getTermini() != null) {
            for (TerminDTO terminDTO : clanskaKartaDTO.getTermini()) {
                TerminID terminID = clanskaKarta.getTermini().get(clanskaKartaDTO.getTermini()
                        .indexOf(terminDTO)).getTerminID();
                terminDTO.setTerminID(terminID);
                terminDTO.setClanskaKarta(clanskaKartaDTO);
            }
        }
        return clanskaKartaDTO;
    }
}
