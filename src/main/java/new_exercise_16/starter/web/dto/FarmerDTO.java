package new_exercise_16.starter.web.dto;

import new_exercise_16.starter.entity.Farm;

public class FarmerDTO {

    String name;
    String surname;
    int age;
    Farm farm;

    int farmId;
    
    public FarmerDTO() {
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

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public int getFarmId() {
        return farmId;
    }

    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }

    @Override
    public String toString() {
        return "FarmerDTO [name=" + name + ", surname=" + surname + ", age=" + age + ", farmId=" + farmId + "]";
    }

    
  

    
    
}
