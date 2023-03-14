package devandroid.joabe.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.joabe.applistacurso.model.Person;
import devandroid.joabe.applistacurso.view.MainActivity;

public class PersonController {

    SharedPreferences preferences;
    public static final String NAME_PREFERENCES = "pref_listavip";
    SharedPreferences.Editor listaVip;

    public PersonController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NAME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_CONTROLLER", "Controller iniciada!");

        return super.toString();
    }

    public void Save(Person person) {
        Log.d("MVC_CONTROLLER", "Salvo! " + person.toString());

        listaVip.putString("primeiroNome", person.getName());
        listaVip.putString("segundoNome", person.getSecondName());
        listaVip.putString("nomeCurso", person.getNameCourse());
        listaVip.putString("numeroContato", person.getNumberContact());

        listaVip.apply();
    }

    public Person Find(Person person) {

        person.setName(preferences.getString("primeiroNome", ""));
        person.setSecondName(preferences.getString("segundoNome", ""));
        person.setNameCourse(preferences.getString("nomeCurso", ""));
        person.setNumberContact(preferences.getString("numeroContato", ""));

        return person;
    }

    public void Clean() {
        listaVip.clear();
        listaVip.apply();
    }
}
