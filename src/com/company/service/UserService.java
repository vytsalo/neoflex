package com.company.service;

import com.company.model.User;

import java.util.List;

public interface UserService {
    //CRUD options

    //Добавление объекта
    void add(User entity);
    //получить список объектов
    List<User> getList();
    //обновление
    void update(User entity);
    //поиск сущности по ID
    User findById(Integer entityId);
    //удаление сущности по ID
    void delete(Integer entityId);
    public void addAll(List<User> userList);
}
