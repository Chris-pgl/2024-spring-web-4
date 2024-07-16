package new_exercise_16.starter.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import new_exercise_16.starter.entity.Farm;

@Repository
public interface  FarmRepo extends JpaRepository<Farm, Integer>{
    
}
