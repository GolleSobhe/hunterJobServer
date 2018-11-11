package com.hunter.job.controller;

import com.hunter.job.domain.Entreprise;
import com.hunter.job.dto.EntrepriseDto;
import com.hunter.job.services.EntrepriseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by telly on 28/01/18.
 */
@RestController
@RequestMapping("/entreprise")
public class EntrepriseController{


    @Autowired
    private EntrepriseService entrepriseService;

    @GetMapping(value = "/all")
    @ApiOperation(value = "retourne la liste de toutes les entreprises")
    public List<Entreprise> getAll(){
        return entrepriseService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "retourne une entreprise")
    public Entreprise getById(@PathVariable Long id){
        return entrepriseService.findById(id);
    }

    @PostMapping(value = "/new")
    public Entreprise save(@Valid @RequestBody EntrepriseDto entrepriseDto){
        Entreprise entreprise = new Entreprise(entrepriseDto);
        return entrepriseService.save(entreprise);
    }
}
