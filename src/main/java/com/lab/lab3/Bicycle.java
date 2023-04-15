package com.lab.lab3;

import jakarta.persistence.*;

/*
Клас Bicycle помічен як Entity, назва відповідної до класу таблиці
 */
@Entity
@Table(name = "bicycles")
public class Bicycle {
    /*
    Поле класу id є первинним ключем таблиці, тому помічено анотацією @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) - первинний ключ встановлюється самостійно (auto_incremented)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    /*
    Поле model - колонка у таблиці баз даних з ім'ям model
    Якщо імена співпадають, вказувати параметр name необов'язково, проте бажано для наглядносі
     */
    @Column (name = "model")
    private String model;

    /*
    Поле color - колонка у таблиці баз даних з ім'ям color
    */
    @Column
    private String color;

    /*
    Відношення багато до одного із таблицею users - багато велосипедів до одного юзера,
    що пов'язане через user_id - звонішній ключ
    FetchType.LAZY дістає зв'язані об'єкти лише при використанні
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /*
    Конструктори
     */
    public Bicycle() {
    }

    public Bicycle(String model, String color) {
        this.model = model;
        this.color = color;
    }

    /*
    Гетери та сетери
     */
    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*
    Метод toString
     */
    @Override
    public String toString() {
        return color+' '+model;
    }
}
