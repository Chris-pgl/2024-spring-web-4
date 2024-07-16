package new_exercise_16.starter.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import new_exercise_16.starter.web.dto.FarmDTO;

@Entity
public class Farm {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    @Column(nullable=false)
    String name;

    @Column(nullable=false)
    String city;

    @OneToMany(mappedBy="farm")
    @JsonIgnore
    List<Farmer> farmers;

    public Farm() {
    }

    public Farm(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Farmer> getFarmers() {
        return farmers;
    }

    public void setFarmers(List<Farmer> farmers) {
        this.farmers = farmers;
    }

    public Farm(String name, String city, List<Farmer> farmers) {
        this.name = name;
        this.city = city;
        this.farmers = farmers;
    }


    public void update(FarmDTO dto){
        setName(dto.getName());
        setCity(dto.getCity());
    }

    
}
