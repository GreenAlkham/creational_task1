package org.example;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    //Создание класса Person с необходимыми для хранения полями
    protected final String name;
    protected final String surname;
    private int age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    //проверка наличия возраста
    public boolean hasAge() {
        if (this.age > 0)
            return true;
        return false;
    }

    //проверка наличия адреса
    public boolean hasAddress() {
        if (this.address != null)
            return true;
        return false;
    }

    //Методы для возврата значений
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    //Метод для возврата возраста при его наличии
    public OptionalInt getAge() {
        if (hasAge())
            return OptionalInt.of(age);
        return OptionalInt.empty();
    }

    //Метод возврата адреса при его наличии
    public String getAddress() {
        if (hasAddress())
            return address;
        return null;
    }

    //Сеттер для смены адреса
    public void setAddress(String address) {
        this.address = address;
    }

    //Метод для увеличения возраста на 1 год, если возраст известен
    public void happyBirthday() {
        if (hasAge())
            this.age++;
    }

    @Override
    public String toString() {
        if (!hasAddress() && !hasAge())
            return this.name + " " + this.surname;
        else if (hasAddress() && !hasAge())
            return this.name + " " + this.surname + " " + this.address;
        else if (!hasAddress() && hasAge())
            return this.name + " " + this.surname + " " + this.age;
        return this.name + " " + this.surname + " " + this.age + " " + this.address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getAge(), getAddress());
    }

    //Метод для возврата полузаполненного билдера для ребенка (фамилия и адрес заполняются от родителя)
    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().surname(this.surname).address(this.address);
    }
}
