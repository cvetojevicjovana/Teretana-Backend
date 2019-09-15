/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.njt.controller;

import com.njt.dto.KorisnikDTO;
import com.njt.entity.Korisnik;
import com.njt.service.KorisnikService;
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
@RequestMapping("/korisnik")
@CrossOrigin
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = "/all", method = GET)
    public List<KorisnikDTO> findAll() {
        List<Korisnik> korisnici = korisnikService.findAll();
        List<KorisnikDTO> korisniciDTO = korisnici.stream()
                .map(korisnik -> modelMapper.map(korisnik, KorisnikDTO.class))
                .collect(Collectors.toList());
        return korisniciDTO;

    }

    @RequestMapping(value = "/{id}", method = GET)
    public KorisnikDTO findById(@PathVariable int id) {
        Korisnik korisnik = korisnikService.findById(id);
        KorisnikDTO korisnikDTO = modelMapper.map(korisnik, KorisnikDTO.class);
        return korisnikDTO;
    }

    @RequestMapping(value = "/new", method = POST)
    public Korisnik save(@RequestBody KorisnikDTO korisnikDTO) {
        Korisnik korisnik = modelMapper.map(korisnikDTO, Korisnik.class);
        korisnikService.saveOrUpdate(korisnik);
        return korisnik;
    }

    @RequestMapping(value = "/update", method = PUT)
    public Korisnik update(@RequestBody KorisnikDTO korisnikDTO) {
        Korisnik korisnik = modelMapper.map(korisnikDTO, Korisnik.class);
        korisnikService.saveOrUpdate(korisnik);
        return korisnik;
    }

    @RequestMapping(value = "/search", method = GET)
    public List<KorisnikDTO> search(@RequestParam(value = "id", required = false, defaultValue = "0") int id,
            @RequestParam(value = "imePrezime", required = false) String imePrezime,
            @RequestParam(value = "radnik", required = false) String radnik) {

        List<Korisnik> korisnici = korisnikService.search(id, imePrezime, radnik);
        List<KorisnikDTO> korisniciDTO = korisnici.stream()
                .map(k -> modelMapper.map(k, KorisnikDTO.class))
                .collect(Collectors.toList());
        return korisniciDTO;
    }
}
