package devandroid.joabe.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import devandroid.joabe.applistacurso.R;
import devandroid.joabe.applistacurso.model.Person;

public class MainActivity extends AppCompatActivity {
    Person person;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        person = new Person();
    }
}