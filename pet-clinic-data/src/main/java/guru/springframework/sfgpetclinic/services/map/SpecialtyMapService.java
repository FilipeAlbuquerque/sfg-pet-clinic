package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtyMapService extends AbstractMapService<Speciality, Long> implements SpecialtyService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(Speciality entity) {
        return super.save(entity);
    }

    @Override
    public void deleteById(Long object) {
        super.deleteById(object);
    }

    @Override
    public void delete(Speciality entity) {
        super.delete(entity);
    }
}