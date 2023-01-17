package ru.mishkin.core.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity  //в Spring JPA обозначает что данный класс является сущностью (объектом);
@Data   //заменяет собой явное написание геттеров, сеттеров, методы toString(), hashCode(), equals();
@AllArgsConstructor  //автоматическое создание конструкторов с аргументами и без них соответственно;
@NoArgsConstructor  //автоматическое создание конструкторов с аргументами и без них соответственно;
@Table(name = "user")   //казываем название таблицы в базе данных, куда будут записываться наши объекты (при совпадении названий класса и таблицы - необязательно, но в нашем случае, создастся таблица с именем указанный нами);

public class User {

    @Id //обозначения поля-ключа таблицы (в SQL - это PRIMARY KEY)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //помогает нам автоматически генерировать id;
    @Column(name = "id")    //явно привязываем поле объекта к полям таблицы SQL (при совпадении названий полей объекта и названий столбцов таблицы - необязательно)
    private int id;
    @Column(name = "name")
    private String name;



}
