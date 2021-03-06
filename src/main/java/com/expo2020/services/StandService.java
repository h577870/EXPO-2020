package com.expo2020.services;

import com.expo2020.models.Stand;
import com.expo2020.repositories.StandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/***
 * @author christian foleide og kristoffer davidsen
 *  Klasse og "service" som utfører CRUD-operasjoner på databasen.
 */

@Service("standService")
@Transactional
public class StandService implements IStandService {

    @Autowired
    private StandRepository standRepository;

    /**
     * Finner stand på id.
     * @param id
     * @return stand
     */
    public Optional<Stand> findById(Long id) {
        return standRepository.findById(id);
    }

    /**
     * Finner alle stands.
     * @return Liste av stands.
     */
    public List<Stand> findAll() {
        return (List<Stand>) standRepository.findAll();
    }

    /**
     * Teller antall stands.
     * @return antall stands.
     */
    public Long count() {
        return standRepository.count();
    }

    /**
     * Legger til ny stand i database.
     * @param entity
     */
    public void save(Stand entity) {
        standRepository.save(entity);
        System.out.println("Added entity to database: " + entity.toString());
    }

    /**
     * Sletter stand fra database.
     * @param id
     */
    public void delete(Long id) {
        Optional<Stand> stand = standRepository.findById(id);
        if (stand.isPresent()) {
            System.out.println(stand.toString());
            standRepository.deleteById(id);
        }
    }
}
