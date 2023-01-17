//Исходя из основ DAO (Data Access Object) разделяем работу с БД на слои.
// Создадим интерфейс UserRepository для обращения непосредственно к базе

package ru.mishkin.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mishkin.core.bean.User;

import java.util.Optional;

@Repository     //Чтобы Spring понимал что это бин и для чего он нужен
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByName(String name);
}

//Вот и весь интерфейс. Унаследуется от интерфейса JPARepository, у которого уже имеются необходимые нам методы findAll() и save().
// Указываем в качестве первого аргумента - тип объекта (в нашем случае User), второго - тип нашего ID - Integer,
// класс-обертка примитива int (мы его помечали аннотацией @Id).
// Чтобы Spring понимал что это бин и для чего он нужен, вешаем аннотацию @Repository.
