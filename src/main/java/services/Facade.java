package services;

import dao.*;
import entities.Employee;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class Facade {

    @PersistenceContext
    private EntityManager em;

    //DONE
    public List<EmployeMinimalDao> getAllPersonnes() {
        List<EmployeMinimalDao> liste = new ArrayList<>();

        this.em.createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList()
                .forEach(e -> liste.add(new EmployeMinimalDao(e.getId(), e.getName() + " " + e.getFirstName())));

        return liste;
    }

    //DONE
    public EmployeDetailsDao getDetailsEmploye(int id) {
        Employee e = this.em.find(Employee.class, id);
        return new EmployeDetailsDao(e.getId(), e.getName(), e.getFirstName());
    }

    //DONE
    public EmployeDetailsDao createEmploye(String nom, String prenom, String adresse, LocalDate dateRec, int idService, String role) {
        val employeeService = this.em.find(entities.Service.class, idService);
        if (employeeService == null) return null;

        Employee employee = new Employee();
        employee.setName(nom);
        employee.setFirstName(prenom);
        employee.setAddress(adresse);
        employee.setJoinDate(dateRec);
        employee.setRole(role);
        employee.setService(employeeService);

        this.em.persist(employee);

        return new EmployeDetailsDao(employee.getId(), employee.getName(), employee.getFirstName());
    }

    //DONE
    public EmployeDetailsDao updateEmploye(int idMembre, String nom, String prenom, String adresse, LocalDate datefromString, int idService, String role) {
        Employee e = this.em.find(Employee.class, idMembre);
        e.setName(nom);
        e.setFirstName(prenom);
        e.setAddress(adresse);
        e.setJoinDate(datefromString);
        e.setRole(role);

        if (idService != e.getService().getId()) {
            val service = this.em.find(entities.Service.class, idService);
            if (service != null) e.setService(service);
        }

        this.em.merge(e);

        return new EmployeDetailsDao(33,nom,prenom);
    }

    //DONE
    public List<ServiceMinimalDao> getServices() {
        List<ServiceMinimalDao> services=new ArrayList<>();

        this.em.createQuery("SELECT s FROM Service s", entities.Service.class)
                .getResultList()
                .forEach(s -> services.add(new ServiceMinimalDao(s.getId(), s.getName())));

        return services;
    }

    //DONE
    public List<EmployeMinimalDao> getEmployes(String filtre) {
        List<EmployeMinimalDao> employes=new ArrayList<>();

        this.em.createQuery("SELECT e FROM Employee e WHERE :filtre", Employee.class)
                .getResultList()
                .forEach(e -> employes.add(new EmployeMinimalDao(e.getId(), e.getName() + " " + e.getFirstName())));

        return employes;
    }


    //DONE
    public ServiceDetailsDao getDetailsService(int idService) {

        val service = this.em.find(entities.Service.class, idService);
        if (service == null) return null;

        List<ServiceMinimalDao> subservices = new ArrayList<>();
        service.getSubService().forEach(s -> subservices.add(new ServiceMinimalDao(s.getId(), s.getName())));

        List<EmployeMinimalDao> employes = new ArrayList<>();
        service.getEmployees().forEach(e -> employes.add(new EmployeMinimalDao(e.getId(), e.getName() + " " + e.getFirstName())));

        return new ServiceDetailsDao(
                service.getId(),
                service.getName(),
                service.getDescription(),
                service.getParentService() == null ? 0 : service.getParentService().getId(),
                subservices,
                employes
        );
    }

    //DONE
    public entities.Service createService(String nom, String mission, int parent) {
        entities.Service service = new entities.Service();
        service.setName(nom);
        service.setDescription(mission);
        service.setParentService(parent == 0 ? null : this.em.find(entities.Service.class, parent));
        this.em.persist(service);
        return service;
    }

    //DONE
    public entities.Service updateService(int idService, String nom, String mission, int idParent) {
        val service = this.em.find(entities.Service.class, idService);
        service.setName(nom);
        service.setDescription(mission);
        if (service.getParentService() != null && service.getParentService().getId() != idParent) {
            val parentService = this.em.find(entities.Service.class, idParent);
            if (parentService != null) service.setParentService(parentService);
        }

        this.em.merge(service);

        return service;
    }

    //DONE
    public void deleteService(int idService) {
        val service = this.em.find(entities.Service.class, idService);
        if (service != null) {
            this.em.remove(service);
        }
    }

    //DONE
    public void addSousService(int idService, int idSous) {
        val service = this.em.find(entities.Service.class, idService);
        val sousService = this.em.find(entities.Service.class, idSous);

        if (service != null && sousService != null) {
            service.getSubService().add(sousService);
        }
    }

    //DONE
    public void addEmployeService(int idService, int idEmp) {
        val service = this.em.find(entities.Service.class, idService);
        val emp = this.em.find(Employee.class, idEmp);

        if (service != null && emp != null) {
            service.getEmployees().add(emp);
        }
    }
}
