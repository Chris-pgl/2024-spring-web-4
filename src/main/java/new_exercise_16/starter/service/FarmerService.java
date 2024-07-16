package new_exercise_16.starter.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import new_exercise_16.starter.entity.Farmer;
import new_exercise_16.starter.repo.FarmerRepo;

@Service
public class FarmerService {

    @Autowired
    FarmerRepo repo;


    public List<Farmer> getAllFarmer(){
        return repo.findAll();
    }

    public Optional<Farmer> getFarmerById(int id){
        return repo.findById(id);
    }

    public void saveFarmer(Farmer e){
        repo.save(e);
    }

    public void deleteFarmer(Farmer e){
        repo.delete(e);
    }
    
}
