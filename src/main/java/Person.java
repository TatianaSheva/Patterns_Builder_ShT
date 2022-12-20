package main.java;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }


    //Все данные о человеке должны быть доступны через соответствующие методы (например, String getName()),
    // поля класса не должны быть public.

    //----------------------------------------------------------------------------------------------------
    //ИМЯ
    public String getName() {
        return name;
    }

    //----------------------------------------------------------------------------------------------------
    //ФАМИЛИЯ
    public String getSurname() {
        return surname;
    }

    //----------------------------------------------------------------------------------------------------
    //ВОЗРАСТ
    // Возраст человека может быть неизвестен, в этом случае метод boolean hasAge() должен вернуть false,
    // иначе - true.
    public boolean hasAge() {
        return age >= 0;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    //Если возраст человека известен, то с момента создания объекта он может быть изменён
    // только увеличением на единицу через вызов метода happyBirthday().
    public void happyBirthday() {
        if (hasAge()) age++;
    }

    //----------------------------------------------------------------------------------------------------
    //АДРЕС
    //Может быть известен (в этом случае метод boolean hasAddress() должен вернуть true,
    // иначе - false) и выставлен в любой через setAddress(String city).
    public boolean hasAddress() {
        return address != null;
    }

    public String getAddress() {
        return address;
    }

    public String setAddress(String address) {
        this.address = address;
        return this.address;
    }


    //----------------------------------------------------------------------------------------------------
    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name) && surname.equals(person.surname) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}

