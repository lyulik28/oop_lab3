package com.lab.lab3;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    private int age;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autos;

    /*
    Відношення один до багатьох
    mappedBy - це ім'я атрибуту зіставлення асоціації на стороні-власника
    CascadeType.ALL - операції save, persists, merge, refresh, видалення зв'язаних об'єктів,
     відключення зв'язаних об'єктів
     orphanRemoval вказує, що залишені сутності слід видалити
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bicycle> bicycles;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Motorbike> motorbikes;


    public User() {
    }


    public User(String name, int age) {
        this.name = name;
        this.age = age;
        autos = new ArrayList<>();
        bicycles = new ArrayList<>();
        motorbikes = new ArrayList<>();
    }


    public void addAuto(Auto auto) {
        auto.setUser(this);
        autos.add(auto);
    }


    public void removeAuto(Auto auto) {
        autos.remove(auto);
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public List<Auto> getAutos() {
        return autos;
    }


    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }


    /*
    Гетер для поля bicycles
     */
    public List<Bicycle> getBicycles() {
        return bicycles;
    }

    /*
    Сетер для поля bicycles
     */
    public void setBicycles(List<Bicycle> autos) {
        this.bicycles = bicycles;
    }

    /*
    Метод addBicycle приймає Bicycle bicycle
    Встановлює bicycle юзера
    Додає bicycle до списку bicycles
     */
    public void addBicycle(Bicycle bicycle) {
        bicycle.setUser(this);
        bicycles.add(bicycle);
    }

    /*
    Метод removeBicycle приймає Bicycle bicycle
    Вилучає bicycle зі списку bicycles
     */
    public void removeBicycle(Bicycle bicycle) {
        bicycles.remove(bicycle);
    }

    /*
    Гетер для поля motorbikes
     */
    public List<Motorbike> getMotorbike() {
        return motorbikes;
    }

    /*
    Сетер для поля motorbikes
     */
    public void setMotorbike(List<Motorbike> motorbike) {
        this.motorbikes = motorbike;
    }

    /*
    Метод addMotorbike приймає Motorbike motorbike
    Встановлює об'єкту motorbike юзера
    Додає motorbike до списку motorbikes
     */
    public void addMotorbike(Motorbike motorbike) {
        motorbike.setUser(this);
        motorbikes.add(motorbike);
    }

    /*
    Метод removeMotorbike приймає Motorbike motorbike
    Вилучає motorbike зі списку motorbikes
     */
    public void removeMotorbike(Motorbike motorbike) {
        motorbikes.remove(motorbike);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age;
    }

    /*
    Метод getInfo
    Зписує у рядок результат функції toString об'єкту User
    Додає до рядку кожен автомобіль, велосипед, мотоцикл юера
    Повертає рядок
     */
    public String getInfo(){
        String string = this.toString();
        string += ". Autos: ";
        for (int i=0; i<this.getAutos().size(); i++){
            string += this.getAutos().get(i)+", ";
        }
        string+="bicycle: ";
        for(int i=0; i<this.getBicycles().size(); i++){
            string+=this.getBicycles().get(i)+", ";
        }
        string+="motorbikes: ";
        for(int i=0; i<this.getMotorbike().size(); i++){
            string+=this.getMotorbike().get(i)+", ";
        }
        return string;
    }

}

