package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

/**
 * Created by jt on 7/21/18.
 */
public abstract class AbstractMapService<T extends BaseEntity , ID extends Long > {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object){
        if(object  != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    public Long getNextId(){
        Long nextId;

        try {
            return Collections.max(map.keySet()) +1;
        } catch (NoSuchElementException e) {
            nextId = 1L;
        }
        return nextId;
    }
}