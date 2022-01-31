package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Bob");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Bilu");
        PetType saveCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality saveRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality saveSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality saveDentistry= specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Miguel");
        owner1.setLastName("Albuquerque");
        owner1.setAddress("Rua 123");
        owner1.setCity("Petrolina");
        owner1.setTelephone("123456");

        Pet miguelsPet = new Pet();
        miguelsPet.setPetType(saveDogPetType);
        miguelsPet.setOwner(owner1);
        miguelsPet.setBirthDate(LocalDate.now());
        miguelsPet.setName("Luke");
        owner1.getPets().add(miguelsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Filipe");
        owner2.setLastName("Albuquerque");
        owner2.setAddress("Rua Maluca");
        owner2.setCity("Lisboa");
        owner2.setTelephone("654321");

        Pet filipesPet = new Pet();
        filipesPet.setPetType(saveCatPetType);
        filipesPet.setOwner(owner2);
        filipesPet.setBirthDate(LocalDate.now());
        filipesPet.setName("Rambo");
        owner2.getPets().add(filipesPet);
        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(filipesPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Sneezy Kitty");

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(saveRadiology);


        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(saveSurgery);

        vetService.save(vet2);

        Vet vet3 = new Vet();
        vet3.setFirstName("Christinne");
        vet3.setLastName("Moura");
        vet3.getSpecialities().add(saveDentistry);

        System.out.println("Loaded Vets....");
    }
}
