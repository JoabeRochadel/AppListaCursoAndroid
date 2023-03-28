package devandroid.joabe.applistacurso.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.joabe.applistacurso.database.AppListaVipDb;
import devandroid.joabe.applistacurso.model.Person;
import devandroid.joabe.applistacurso.view.MainActivity;

public class PersonController extends AppListaVipDb {

    SharedPreferences preferences;
    public static final String NAME_PREFERENCES = "pref_listavip";
    SharedPreferences.Editor listaVip;

    public PersonController(MainActivity mainActivity) {
        super(mainActivity);
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
        listaVip.putString("cursoSolicitado", person.getRequestedCourse());

        listaVip.apply();

        ContentValues data = new ContentValues();
        data.put("name", person.getName());
        data.put("secondName", person.getSecondName());
        data.put("nameCourse", person.getNameCourse());
        data.put("numberContact", person.getNumberContact());
        data.put("requestedCourse", person.getRequestedCourse());

        saveObject("LISTAVIP", data);
    }

    public Person Find(Person person) {

        person.setName(preferences.getString("primeiroNome", ""));
        person.setSecondName(preferences.getString("segundoNome", ""));
        person.setNameCourse(preferences.getString("nomeCurso", ""));
        person.setNumberContact(preferences.getString("numeroContato", ""));
        person.setNumberContact(preferences.getString("cursoSolicitado", ""));

        return person;
    }

    public void Clean() {
        listaVip.clear();
        listaVip.apply();
    }

    public void alterData(Person person) {
        ContentValues data = new ContentValues();

        data.put("id", person.getId());
        data.put("name", person.getName());
        data.put("secondName", person.getSecondName());
        data.put("nameCourse", person.getNameCourse());
        data.put("numberContact", person.getNumberContact());
        data.put("requestedCourse", person.getRequestedCourse());

        AlterData("LISTAVIP", data);
    }

    public void delete(int id) {
        DeleteData("LISTAVIP", id);
    }
}
