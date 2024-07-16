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

import new_exercise_16.starter.entity.Farm;
import new_exercise_16.starter.service.FarmService;
import new_exercise_16.starter.web.dto.FarmDTO;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/farm/")
public class FarmController {

    @Autowired
    FarmService service;


    @GetMapping("add")
    public ResponseEntity<Void> addFarm(){
        Farm f1 = new Farm("Farming", "unknow");
        Farm f2 = new Farm("Farming2", "unknow2");

        service.saveFarm(f1);
        service.saveFarm(f2);

        return ResponseEntity.ok().build();
    }
    

    @PostMapping("create")
    public ResponseEntity<Farm> create(@RequestBody FarmDTO farm) {
        Farm f = new Farm(farm.getName(), farm.getCity());
        service.saveFarm(f);

        return ResponseEntity.ok(f);
    }

    @GetMapping("all")
    public ResponseEntity<List<Farm>> getAllFarm(){
        List<Farm> list = service.getAllFarm();

        return ResponseEntity.ok(list);
    }

    @PatchMapping("update/{id}")
    public ResponseEntity<Farm> updateFarm(@PathVariable int id, @RequestBody FarmDTO dto){
        Optional<Farm> optF = service.getFarmById(id);
        if(optF.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Farm f = optF.get();
        f.update(dto);
        service.saveFarm(f);

        return ResponseEntity.ok(f);
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<String> deletefarm(@PathVariable int id){
        Optional<Farm> optF = service.getFarmById(id);
        if(optF.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Farm farm = optF.get();
        service.deleteFarm(farm);

        return ResponseEntity.ok("Farm cancellata");
    }

 }
    




