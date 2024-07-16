package new_exercise_16.starter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import new_exercise_16.starter.entity.Farm;
import new_exercise_16.starter.repo.FarmRepo;

@Service
public class FarmService {
    
    @Autowired
    FarmRepo repo;

    public List<Farm>  getAllFarm(){
        return repo.findAll();
    }

    public Optional<Farm> getFarmById(int id){
        return repo.findById(id);
    }

    public void saveFarm(Farm f){
        repo.save(f);
    }

    public void deleteFarm(Farm e){
        repo.delete(e);
    }
}
