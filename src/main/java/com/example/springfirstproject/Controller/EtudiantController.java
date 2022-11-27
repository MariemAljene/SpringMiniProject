package com.example.springfirstproject.Controller;

import com.example.springfirstproject.AService.IEtudiantService;
import com.example.springfirstproject.entity.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")

public class EtudiantController  {
    @Autowired
 private IEtudiantService EtudiantService ;


@GetMapping("/getAllEtudiant")
public List<Etudiant> getAllEtudiant()
{

    return EtudiantService.retrieveAllEtudiants();
}

@PostMapping ("/AddEtudiant")
public Etudiant AddEtudiant( @RequestBody  Etudiant e )
{

    return EtudiantService.addEtudiant(e) ;
}

  @PutMapping("/UpdateEtudiant")
   public Etudiant UpdateEtudiant(@RequestBody Etudiant e)
   {

       return EtudiantService.updateEtudiant(e);
   }

    @GetMapping("/retrieve-etudiant/{idE}")
    public Etudiant retrieveEtudiant(@PathVariable("idE") Integer idE) {

    return EtudiantService.retrieveEtudiant(idE);
    }

    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Integer etudiantId) {
       EtudiantService.removeEtudiant(etudiantId);
    }
    @GetMapping("/retrieve-etudiantById/{idDepart}")
   public  List<Etudiant> findByIdEtudiantDepartement(Integer idDepart)
    {
        return EtudiantService.findBydepartementIdDepart(idDepart) ;

    }
    @PutMapping(value = "/affecter-etudiant-departement/{etudiantID}/{departementID}")
    public void affecterEtudiantToDepartement(@PathVariable("etudiantID") Integer etudiantID,
                                              @PathVariable("departementID")Integer departementID)
    {
        EtudiantService.assignEtudiantToDepartement(etudiantID,departementID);
    }
    @PutMapping(value = "/affecter-etudiant-Contrat-equipe/{e}/{idContrat}/{EquipeID}")
    public void addAndAssignEtudiantToEquipeAndContract(@PathVariable("e") Etudiant e,
                                              @PathVariable("idContrat")Integer idContrat ,
                                                        @PathVariable("EquipeID")Integer EquipeId      )
    {
        EtudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,EquipeId);
    }

    @GetMapping("/getEtudientSecurite")
   public List<Etudiant> AfficherLesContratsDeLaSpecialiteSecurite()
    {

        return EtudiantService.AfficherLesContratsDeLaSpecialiteSecurite();
    }
}
