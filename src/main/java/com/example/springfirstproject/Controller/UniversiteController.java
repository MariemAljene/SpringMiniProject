package com.example.springfirstproject.Controller;

import com.example.springfirstproject.AService.IEtudiantService;
import com.example.springfirstproject.AService.IUniversiteService;
import com.example.springfirstproject.entity.Etudiant;
import com.example.springfirstproject.entity.Universite;
import com.example.springfirstproject.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Universites")
public class UniversiteController {
    @Autowired
    private IUniversiteService UniversiteService ;


    @GetMapping("/getAllUniversites")
    public List<Universite> getAllUniversites()
    {

        return UniversiteService.retrieveAllUniversites();
    }

    @PostMapping("/AddUniversite")
    public Universite AddUniversite( @RequestBody Universite U )
    {

        return UniversiteService.addUniversite(U) ;
    }

    @PutMapping("/UpdateUniversite")
    public Universite UpdateUniversite(@RequestBody Universite U)
    {

        return UniversiteService.updateUniversite(U);
    }

    @GetMapping("/retrieve-Universites/{idU}")
    public Universite retrieveUniversite(@PathVariable("idE") Integer idU)
    {
        return UniversiteService.retrieveUniversite(idU);
    }

    @DeleteMapping("/remove-Universite/{Universite-id}")
    public void removeUniversite(@PathVariable("Universite-id") Integer UniversiteId)
    {
        UniversiteService.removeUniversite(UniversiteId);
    }
    @PutMapping(value = "/affecter-Universite-departement/{Universite-ID}/{departementID}")
    public void affecterUniversiteToDepartement(@PathVariable("UniversiteID") Integer UniversiteID,
                                              @PathVariable("departementID")Integer departementID)
    {
        UniversiteService.assignUniversiteToDepartement(UniversiteID,departementID);
    }
}
