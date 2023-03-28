package devandroid.joabe.applistacurso.model;

import androidx.annotation.NonNull;

public class Person {
    private int id;
    private String name;
    private String secondName;
    private String nameCourse;
    private String numberContact;
    private String requestedCourse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public String getNumberContact() {
        return numberContact;
    }

    public void setNumberContact(String numberContact) {
        this.numberContact = numberContact;
    }

    public String getRequestedCourse() {
        return requestedCourse;
    }

    public void setRequestedCourse(String requestedCourse) {
        this.requestedCourse = requestedCourse;
    }


    @Override
    public String toString() {
        return "Pessoa{" +
                "Primeiro nome='" + name + '\'' +
                ", Segundo nome='" + secondName + '\'' +
                ", Curso matriculado'" + nameCourse + '\'' +
                ", Telefone de contato='" + numberContact + '\'' +
                ", Curso Solicitado='" + requestedCourse + '\'' +
                '}';
    }
}
