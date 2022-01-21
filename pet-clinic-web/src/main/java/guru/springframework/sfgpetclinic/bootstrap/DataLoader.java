package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import guru.springframework.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Bob");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Bilu");
        PetType saveCatPetType = petTypeService.save(cat);


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

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
