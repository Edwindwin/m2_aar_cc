package controleurs;

import entities.Service;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import services.Facade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class Controleur {

    @Autowired
    Facade facade;

    Logger logger=Logger.getLogger("controleurs");

    /*************************** ACCUEIL ************************************/
    @RequestMapping("/")
    public String accueil(@RequestParam(required = false) String filtre, Model model) {
        logger.info("accueil "+filtre);
        model.addAttribute("services", facade.getServices());
        model.addAttribute("employes", facade.getEmployes(filtre));
        return "accueil";
    }

    /************************************* GESTION SERVICES **************************/
    @GetMapping("/service/{idService}")
    public String detailsService(@PathVariable int idService, Model model){
        logger.info("details service "+idService);
        model.addAttribute("details", facade.getDetailsService(idService));
        model.addAttribute("tousservices", facade.getServices());
        model.addAttribute("tousemployes", facade.getEmployes(null));
        // TODO les autres données nécessaires
        return "detailsService";
    }

    @PostMapping("/service/{idService}")
    public String modifService(@PathVariable int idService, @RequestParam String nom,@RequestParam  String mission,@RequestParam  int idParent, Model model){
        logger.info("modif service "+idService+" "+nom+" "+mission+" "+idParent);
        model.addAttribute("details", facade.updateService(idService,nom,mission,idParent));
        // TODO les autres données nécessaires
        return detailsService(idService,model);
    }

    @GetMapping("/nouveauservice")
    public String nouveauService(Model model) {
        logger.info("nouveau service (accès)");
        model.addAttribute("services", facade.getServices());
        return "nouveauService";
    }

    @PostMapping("/nouveauservice")
    public String creerService(@RequestParam String nom,@RequestParam  String mission,@RequestParam  int idParent, Model model){
         logger.info("nouveau service "+nom+" "+mission+" "+idParent);
         Service service=facade.createService(nom,mission,idParent);
         return detailsService(service.getId(),model);
    }

    // suppression
    @PostMapping("/supprservice/{idService}")
    public String suppression(@PathVariable int idService, Model model){
        logger.info("suppression service "+idService);
        facade.deleteService(idService);
        return accueil(null,model);
    }

    // ajout sous service
    @PostMapping("/ajoutsousservice/{idService}")
    public String ajoutSous(@PathVariable int idService, @RequestParam int idSous, Model model){
        logger.info("ajout sous service "+idService+" "+idSous);
        facade.addSousService(idService,idSous);
        return detailsService(idService,model);
    }

    // ajout employe service
    @PostMapping("/ajoutemployeservice/{idService}")
    public String ajoutEmpServ(@PathVariable int idService, @RequestParam int idEmp, Model model){
        logger.info("ajout employe service "+idService+" "+idEmp);
        facade.addEmployeService(idService,idEmp);
        return detailsService(idService,model);
    }

    /************************************* GESTION PERSONNEL **************************/
    @GetMapping("/employe/{idEmploye}")
    public String detailsEmploye(@PathVariable int idEmploye, Model model){
        logger.info("details "+idEmploye);
        model.addAttribute("details", facade.getDetailsEmploye(idEmploye));
        model.addAttribute("tousservices", facade.getServices());
        // TODO les autres données nécessaires
        return "detailsEmploye";
    }

    // accès à la page de saisie
    @GetMapping("/nouvelemploye")
    public String ajoutMembre(Model model){
        logger.info("ajout employe (accès)");
        model.addAttribute("tousservices", facade.getServices());
        return "nouvelEmploye";
    }

    // création d'une personne
    @PostMapping("/nouvelemploye")
    public String ajoutMembre(@RequestParam String nom,
                              @RequestParam String prenom,
                              @RequestParam String adresse,
                              @RequestParam String dateRec,
                              @RequestParam int idService,
                              @RequestParam String role,
                              Model model){
        logger.info("ajout employe "+nom+" "+prenom+" "+adresse+" "+dateRec+" "+idService+" "+role);

        val e = facade.createEmploye(nom,prenom,adresse,datefromString(dateRec),idService,role);
        return detailsEmploye(e.getId(), model);
    }

    // modification d'une personne
    @PostMapping("/employe/{idEmploye}")
    public String majMembre(@PathVariable int idEmploye,
                            @RequestParam String nom,
                            @RequestParam String prenom,
                            @RequestParam String adresse,
                            @RequestParam String dateRec,
                            @RequestParam int idService,
                            @RequestParam String role,
                              Model model){
        logger.info("maj membre "+idEmploye+" "+nom+" "+prenom+" "+adresse+" "+dateRec+" "+idService+" "+role);
        facade.updateEmploye(idEmploye,nom,prenom,adresse,datefromString(dateRec),idService,role);
        return detailsEmploye(1,model);
    }



    /*********************************************** FONCTIONS UTILITAIRES *******************************/

    private LocalDate datefromString(String dateS) {
        LocalDate ld=null;
        if ((dateS!=null)&&(!dateS.equals(""))) {
            ld=LocalDate.parse(dateS, DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return ld;
    }

}
