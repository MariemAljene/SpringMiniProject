package com.example.springfirstproject.Controller;

import com.example.springfirstproject.AService.IContratService;
import com.example.springfirstproject.entity.Contrat;
import com.example.springfirstproject.entity.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Contrats")
public class ContratController {
    @Autowired
    private IContratService  iContratService ;
    @GetMapping("/getAllContrats")
    public List<Contrat> getAllContrat()
    {
        return iContratService.retrieveAllContrats();
    }

    @PostMapping("/AddContrat")
    public Contrat AddContrat( @RequestBody Contrat c )
    {
        return iContratService.addContrat(c) ;
    }



    @GetMapping("/retrieve-contrat/{idE}")
    public Contrat retrieveContrat(@PathVariable("idE") Integer idE) {
        return iContratService.retrieveContrat(idE);
    }
    @PutMapping("/UpdateContrat")
    public Contrat UpdateContrat(@RequestBody Contrat c)
    {
        return iContratService.updateContrat(c);
    }


    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeContrat(@PathVariable("etudiant-id") Integer etudiantId) {
        iContratService.removeContrat(etudiantId);
    }
    @PutMapping("/affConET/{nomE}/{prenomE}")
    public Contrat affectContratToEtudiant(@PathVariable int idContrat, @PathVariable("nomE") String nomE,@PathVariable("prenomE") String PrenomE){
        return iContratService.affectContratToEtudiant(idContrat,nomE,PrenomE);
    }
    @GetMapping(value = "/getnbContratsValides/{startDate}/{endDate}")
    public Integer getnbContratsValides(@PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                        Date startDate,
                                        @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                        Date endDate) {

        return iContratService.nbContratsValides(startDate, endDate);
    }
    @GetMapping("/chiffreaffaire/{id}/{startDate}/{endDate}")
    public float getchiffredaffaire(@PathVariable("IdUniv")int IdUniv,@PathVariable("startDate")Date startDate ,@PathVariable("endDate" )Date endDate){
        return iContratService.getMontantContartEntreDeuxDate(IdUniv,startDate,endDate);
    }


}
