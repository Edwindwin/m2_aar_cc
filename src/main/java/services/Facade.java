package services;

import dao.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class Facade {
    public List<EmployeMinimalDao> getAllPersonnes() {
        List<EmployeMinimalDao> liste=new ArrayList<>();
        liste.add(new EmployeMinimalDao(1,"SIMPSON Homer"));
        liste.add(new EmployeMinimalDao(2,"BOUVIER Marge"));
        liste.add(new EmployeMinimalDao(3,"SIMPSON Lisa"));
        liste.add(new EmployeMinimalDao(4,"SIMPSON Bart"));
        liste.add(new EmployeMinimalDao(5,"SIMPSON Maggie"));
        liste.add(new EmployeMinimalDao(6,"SIMPSON Hugo"));
        return liste;
    }

    public EmployeDetailsDao getDetailsEmploye(int id) {
        return new EmployeDetailsDao(1,"SIMPSON","Homer");
    }

    public EmployeDetailsDao createEmploye(String nom, String prenom,
                                           String adresse, LocalDate dateRec,
                                           int idService,String role){
        // TODO
        return new EmployeDetailsDao(33,nom,prenom);
    }


    public EmployeDetailsDao updateEmploye(int idMembre, String nom, String prenom, String adresse, LocalDate datefromString, int idService, String role) {
        // TODO
        return new EmployeDetailsDao(33,nom,prenom);
    }

    public List<ServiceMinimalDao> getServices() {
        List<ServiceMinimalDao> services=new ArrayList<>();
        services.add(new ServiceMinimalDao(1,"Direction"));
        services.add(new ServiceMinimalDao(2,"Comptabilité"));
        return services;
    }

    public List<EmployeMinimalDao> getEmployes(String filtre) {
        List<EmployeMinimalDao> employes=new ArrayList<>();
        employes.add(new EmployeMinimalDao(12,"Geronimo Dalton"));
        employes.add(new EmployeMinimalDao(13,"Nick Ita"));
        return employes;
    }

    public ServiceDetailsDao getDetailsService(int idService) {
        ServiceDetailsDao serviceDao=new ServiceDetailsDao();
        serviceDao.setId(2);
        serviceDao.setNom("Comptabilité");
        serviceDao.setMission("Chapeauter");
        serviceDao.setIdParent(1);
        serviceDao.setSousservices(new ArrayList<>());
        List<EmployeMinimalDao> employes=new ArrayList<>();
        employes.add(new EmployeMinimalDao(12,"Geronimo Dalton"));
        employes.add(new EmployeMinimalDao(13,"Nick Ita"));
        serviceDao.setEmployes(employes);
        return serviceDao;
    }

    public entities.Service createService(String nom, String mission, int parent) {
        // TODO
        return new entities.Service();
    }

    public entities.Service updateService(int idService, String nom, String mission, int idParent) {
              // TODO
        return new entities.Service();
    }

    public void deleteService(int idService) {
        // TODO
    }

    public void addSousService(int idService, int idSous) {
        // TODO
    }

    public void addEmployeService(int idService, int idEmp) {
        // TODO
    }

}
