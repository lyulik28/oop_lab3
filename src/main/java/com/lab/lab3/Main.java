package com.lab.lab3;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {


//        UserService userService = new UserService();
//        User user = new User("Masha",26);
//        userService.saveUser(user);
//        Auto ferrari = new Auto("Ferrari", "red");
//        user.addAuto(ferrari);
//        Auto ford = new Auto("Ford", "black");
//        ford.setUser(user);
//        user.addAuto(ford);
//        userService.updateUser(user);
//        user.setName("Sasha");
//        userService.updateUser(user);
//         userService.deleteUser(user);

        /*
            Відбувається підключення до бази даних
            Створюються об'єкти юзер, автомобіль, велосипед та мотоцикл
            Усі транспорті засоби додаються до юзера
            Юзер зберігається у базу даних
            Через CascadeType.ALL трансопртні засоби також автоматично зберігаються
            Сесія завершується
         */
        UserService userService = new UserService();
        User user = new User("User", 40);
        Auto auto1 = new Auto("Volvo", "black");
        Auto auto2 = new Auto("Jaguar", "white");
        Auto auto3 = new Auto("Range Rover", "white");
        Bicycle bicycle = new Bicycle("aa", "bb");
        Motorbike motorbike = new Motorbike("aa", "bb");
        user.addBicycle(bicycle);
        user.addMotorbike(motorbike);
        user.addAuto(auto1);
        user.addAuto(auto2);
        user.addAuto(auto3);
        userService.saveUser(user);


        /*
        Знаходження юзера за id
        Виведення на екран автомобілів юзера
         */
        User userFind = userService.findUser(11);
        for (int i=0; i<userFind.getAutos().size(); i++){
            System.out.println(userFind.getAutos().get(i));
        }
    }
}


