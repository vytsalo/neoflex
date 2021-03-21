package com.company.service.impl;

import com.company.model.User;
import com.company.service.UserService;

import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {


    private static List<User> userList = Arrays.asList(
            new User(1,"Ivan","Ivanov", "Ivanovich"),
            new User(2,"Petr","Petrov", "Petrovich"),
            new User(3,"Sergei","Sidorov", "Vladimirovich"),
            new User(4,"Dmitriy","Korobov", "Ilich"),
            new User(5,"Alexander","Pushkin", "Sergeevich"));


    @Override
    public List<User> getList() {
        return userList;
    }

    @Override
    public void update(User entity) {
        //todo
    }

    @Override
    public User findById(Integer entityId) {
        return userList.stream()
                .filter(user -> user.getId() == entityId)
                .reduce((a, b) -> {
                    throw new IllegalStateException("Несколько элементов: " + a + ", " + b);
                })
                .get();

    }

    @Override
    public void delete(Integer entityId) {
        //todo
    }

    public List<User> getAll() {
        return userList;
    }

    //Добавляем один элемент
    public void add(User user) {

        userList.add(user);

    }

    //Добавляем все элементы
    public void addAll(List<User> userList) {

        this.userList.addAll(userList);

    }


}
