package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {
    @Override
    public Set<PetType> findAll() {
        return super.findAll();

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public PetType save(PetType entity) {
        return super.save(entity);
    }

    @Override
    public void delete(PetType entity) {
        super.delete(entity);
    }

    @Override
    public PetType findById(Long id) {
        return super.findById(id);
    }
}