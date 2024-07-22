package new_exercise_16.starter.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import new_exercise_16.starter.web.dto.FarmerDTO;

@Entity
public class Farmer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;

    @Column(nullable=false, length=65)
    String name;

    @Column(nullable=false, length=65)
    String surname;

    @Column(nullable=false)
    int age;
  
    @ManyToOne(cascade= CascadeType.ALL)
    //@JoinColumn("farm_id")
    Farm farm;
  
    public Farmer() {
    }

    public Farmer(String name, String surname, int age, Farm farm) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.farm = farm;
    }

    public Farmer(FarmerDTO farmerDto) {

        update(farmerDto);
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Farmer [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + "]";
    }

  
    public void update(FarmerDTO dto){
        setName(dto.getName());
        setSurname(dto.getSurname());
        setAge(dto.getAge());
        setFarm(dto.getFarm());
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    
    
}
