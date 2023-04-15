package com.lab.lab3.controller;

import com.lab.lab3.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {


    /*
    Метод при переході на localhost:8086 (не стандартний 8080, адже в мене цей порт зайнят)
    Повертає сторінку home
    Підключається до бази даних, дістає всіх юзерів та записує у лист
    Записує у модель лист з інформацію отриману через метод getInfo() класу User
     */
    @GetMapping("/")
    public String mainPage(Model model){
        UserService userService = new UserService();
        List<User> users = userService.findAllUsers();
        List<String> string = new ArrayList<>();
        for(int i=0; i<users.size(); i++){
            string.add(users.get(i).getInfo());
        }
        model.addAttribute("string", string);
        return "home";
    }

    /*
    Метод приймає параметри @RequestParam String name, @RequestParam int age, @RequestParam String carModel
            , @RequestParam String carColor, @RequestParam String bicycleModel, @RequestParam String bicycleColor
            , @RequestParam String motorbikeModel, @RequestParam String motorbikeColor
     Пареметри отримуються через форму з методом post та через url
     Створює нового юзера з машиною, велосипедом та мотоциклом, записує у БД
     Перезапускає сторінку
     */
    @PostMapping("/")
    public String add(@RequestParam String name, @RequestParam int age, @RequestParam String carModel
            , @RequestParam String carColor, @RequestParam String bicycleModel, @RequestParam String bicycleColor
            , @RequestParam String motorbikeModel, @RequestParam String motorbikeColor){

        UserService userService = new UserService();
        User user = new User(name, age);
        Auto auto = new Auto(carModel, carColor);
        Bicycle bicycle = new Bicycle(bicycleModel, bicycleColor);
        Motorbike motorbike = new Motorbike(motorbikeModel, motorbikeColor);
        user.addAuto(auto);
        user.addBicycle(bicycle);
        user.addMotorbike(motorbike);
        userService.saveUser(user);

        return "redirect:/";
    }

    /*
    Метод приймає int id
    Підключається до бази даних, видаляє юзера та завершую сесію
    Через те, що методів put та delete немає у html
    для виконання функції у home.html також прописан script
     */
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id){
        UserService userService = new UserService();
        User user = userService.findUser(id);
        userService.deleteUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/auto/{id}")
    public String deleteAuto(@PathVariable("id") int id){
        UserService userService = new UserService();
        userService.deleteAuto(userService.findAutoById(id));
        return "redirect:/";
    }

    @DeleteMapping("/bicycle/{id}")
    public String deleteBicycle(@PathVariable("id") int id){
        UserService userService = new UserService();
        userService.deleteBicycle(userService.findBicycleById(id));
        return "redirect:/";
    }

    @DeleteMapping("/motorbike/{id}")
    public String deleteMotorbike(@PathVariable("id") int id){
        UserService userService = new UserService();
        userService.deleteMotorbike(userService.findMotorbikeById(id));
        return "redirect:/";
    }
}
