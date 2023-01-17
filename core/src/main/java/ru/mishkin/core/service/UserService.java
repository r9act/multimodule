package ru.mishkin.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mishkin.core.bean.User;
import ru.mishkin.core.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service    //метка для Spring, указывающая, что класс является бином и сервисным классом.
public class UserService {

    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void save (String name){
        User user = new User();
        user.setName(name);
        userRepository.save(user);
    }

    public Optional<User> findByName(String name){
        return userRepository.findByName(name);
    }

    @Autowired  //внедрение нашего UserRepository, позволяющая использовать его методы без создания экземпляра класса.
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }
}

//Над классом вешаем аннотацию @Service - метка для Spring, указывающая, что класс является бином и сервисным классом.
// Далее объявляем приватное поле с типом нашего UserRepository, создаем его сеттер и вешаем аннотацию @Autowired - внедрение нашего UserRepository,
// позволяющая использовать его методы без создания экземпляра класса. И два метода:
//
//findAll() - вытянуть все записи из таблицы и запихнуть их в коллекцию (в моем случае List).
//save() - здесь также все просто, принимаем параметры (в нашем случае только имя юзера),
// создаем объект User, сетаем ему наше имя и передаем весь объект в метод save() нашего UserRepository для создании новой записи в БД.
//На этом наш первый модуль готов!