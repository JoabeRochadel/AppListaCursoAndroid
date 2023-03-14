package devandroid.joabe.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.joabe.applistacurso.R;
import devandroid.joabe.applistacurso.controller.PersonController;
import devandroid.joabe.applistacurso.model.Person;

public class MainActivity extends AppCompatActivity {

    public static final String NAME_PREFERENCES = "pref_listavip";
    PersonController personController;
    Person person;
    EditText editFirstName;
    EditText editSecondName;
    EditText editCourse;
    EditText editContact;
    Button buttonClean;
    Button buttonSave;
    Button buttonFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personController = new PersonController(MainActivity.this);
        person = new Person();
        personController.Find(person);

        editFirstName = findViewById(R.id.editFirstName);
        editSecondName = findViewById(R.id.editSecondName);
        editCourse = findViewById(R.id.editCourse);
        editContact = findViewById(R.id.editContact);

        buttonClean = findViewById(R.id.buttonClean);
        buttonSave = findViewById(R.id.buttonSave);
        buttonFinish = findViewById(R.id.buttonFinish);

        editFirstName.setText(person.getName());
        editSecondName.setText(person.getSecondName());
        editCourse.setText(person.getNameCourse());
        editContact.setText(person.getNumberContact());

        buttonClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editFirstName.setText("");
                editSecondName.setText("");
                editCourse.setText("");
                editContact.setText("");

                personController.Clean();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person.setName(editFirstName.getText().toString());
                person.setSecondName(editSecondName.getText().toString());
                person.setNumberContact(editContact.getText().toString());
                person.setNameCourse(editCourse.getText().toString());

                personController.Save(person);
            }
        });

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre!", Toast.LENGTH_LONG).show();

            }
        });
    }
}