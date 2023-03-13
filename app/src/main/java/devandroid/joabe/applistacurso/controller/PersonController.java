package devandroid.joabe.applistacurso.controller;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import devandroid.joabe.applistacurso.model.Person;
import devandroid.joabe.applistacurso.view.MainActivity;

public class PersonController {

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_CONTROLLER", "Controller iniciada!");

        return super.toString();
    }

    public void Salvar(Person person1) {
        Log.d("MVC_CONTROLLER", "Salvo! " + person1.toString());
    }
}
