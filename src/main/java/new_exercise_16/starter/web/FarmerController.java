package new_exercise_16.starter.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import new_exercise_16.starter.entity.Farm;
import new_exercise_16.starter.entity.Farmer;
import new_exercise_16.starter.service.FarmService;
import new_exercise_16.starter.service.FarmerService;
import new_exercise_16.starter.web.dto.FarmerDTO;

@RestController
@RequestMapping("/farmer/")
@CrossOrigin(origins = "http://localhost:5173")
public class FarmerController {


    @Autowired
    FarmerService fService;

    @Autowired
    FarmService farmservice;

    @GetMapping("add")
    public ResponseEntity<Void> addFarmer(){

        Farm farm1 = new Farm("FarmCorn", "Edimburg");
        Farm farm2 = new Farm("FarmGran", "Italy");
        Farm farm3 = new Farm("FarmCurry", "Japan");

        farmservice.saveFarm(farm1);
        farmservice.saveFarm(farm2);
        farmservice.saveFarm(farm3);

        
        Farmer f1 = new Farmer("Gino", "Ginetto", 22, farm1);
        Farmer f2 = new Farmer("Pino", "pinetto", 22,farm2);
        Farmer f3 = new Farmer("Rino", "rinetto", 27,farm3);

        fService.saveFarmer(f1);
        fService.saveFarmer(f2);
        fService.saveFarmer(f3);
        
        return ResponseEntity.ok().build();

    }


    @PostMapping("create")
    public ResponseEntity<Farmer> createFarmer (@RequestBody FarmerDTO dto){
        Optional<Farm> optFarm = farmservice.getFarmById(dto.getFarmId());
        if(optFarm.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        
        Farm farm = optFarm.get();
        Farmer farmer = new Farmer(dto);

        farmer.setFarm(farm);
        fService.saveFarmer(farmer);

        return ResponseEntity.ok(farmer);

    }

    @GetMapping("all")
    public ResponseEntity<List<Farmer>> getAllFarmer(){
        List<Farmer> list = fService.getAllFarmer();

        return ResponseEntity.ok().body(list);
    }
    

    @PatchMapping("update/{id}")
    public ResponseEntity<Farmer> updateFarmer(@PathVariable int id, @RequestBody FarmerDTO dto){
        Optional<Farmer> optFar = fService.getFarmerById(id);
        if(optFar.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Farmer f = optFar.get();
        f.update(dto);
        fService.saveFarmer(f);

        return ResponseEntity.ok(f);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteFarmer(@PathVariable int id){
        Optional<Farmer> optFar = fService.getFarmerById(id);
        if(optFar.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Farmer f = optFar.get();
        fService.deleteFarmer(f);
        return ResponseEntity.ok("Contadino cancellato.");
    }
}
