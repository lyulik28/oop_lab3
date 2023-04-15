package com.lab.lab3;

import java.util.List;
import com.lab.lab3.User;


public class UserService {


    private UserDao usersDao = new UserDao();


    public UserService() {
    }


    public User findUser(int id) {
        return usersDao.findById(id);
    }


    public void saveUser(User user) {
        usersDao.save(user);
    }


    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void deleteBicycle(Bicycle bicycle) {
        usersDao.deleteB(bicycle);
    }

    public void deleteAuto(Auto auto) {
        usersDao.deleteA(auto);
    }

    public void deleteMotorbike(Motorbike motorbike) {
        usersDao.deleteM(motorbike);
    }


    public void updateUser(User user) {
        usersDao.update(user);
    }


    public List<User> findAllUsers() {
        return usersDao.findAll();
    }


    public Auto findAutoById(int id) {
        return usersDao.findAutoById(id);
    }

    public Bicycle findBicycleById(int id) {
        return usersDao.findBicycleById(id);
    }

    public Motorbike findMotorbikeById(int id) {
        return usersDao.findMotorbikeById(id);
    }


}

