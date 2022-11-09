package com.example.springfirstproject.Controller;

import com.example.springfirstproject.AService.IDepartementService;
import com.example.springfirstproject.AService.IEtudiantService;
import com.example.springfirstproject.entity.Departement;
import com.example.springfirstproject.entity.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Departements")
public class DepartementController {
    @Autowired
    private IDepartementService departementService ;
    @GetMapping("/getAllDepartements")
    public List<Departement> getAllDepartements()
    {
        return departementService.retrieveAllDepartements();
    }

    @PostMapping("/AddDepartement")
    public Departement AddDepartement( @RequestBody   Departement d )
    {
        return departementService.addDepartement(d) ;
    }

    @PutMapping("/UpdateDepartement")
    public Departement UpdateDepartement(@RequestBody Departement d)
    {
        return departementService.updateDepartement(d);
    }

    @GetMapping("/retrieve-Departement/{idD}")
    public Departement retrieveDepartement(@PathVariable("idD") Integer idD) {
        return departementService.retrieveDepartement(idD);
    }

    @DeleteMapping("/remove-Departement/{Departement-id}")
    public void removeDepartement(@PathVariable("Departement-id}") Integer Id) {
        departementService.removeDepartement(Id);
    }
}
