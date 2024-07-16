package new_exercise_16.starter.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import new_exercise_16.starter.entity.Farmer;
import new_exercise_16.starter.service.FarmerService;
import new_exercise_16.starter.web.dto.FarmerDTO;

@RestController
@RequestMapping("/farmer/")
public class MainController {


    @Autowired
    FarmerService fService;

    @GetMapping("add")
    public ResponseEntity<Void> addFarmer(){
        
        Farmer f1 = new Farmer("Gino", "Ginetto", 25);
        Farmer f2 = new Farmer("Pino", "pinetto", 22);
        Farmer f3 = new Farmer("Rino", "rinetto", 27);

        fService.saveFarmer(f1);
        fService.saveFarmer(f2);
        fService.saveFarmer(f3);
        
        return ResponseEntity.ok().build();

    }


    @PostMapping("create")
    public ResponseEntity<Farmer> createFarmer (@RequestBody FarmerDTO dto){
        Farmer e = new Farmer(dto.getName(), dto.getSurname(), dto.getAge());
        fService.saveFarmer(e);
        return ResponseEntity.ok(e);
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


    @GetMapping("delete/{id}")
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
