package devandroid.joabe.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.joabe.applistacurso.R;
import devandroid.joabe.applistacurso.model.Person;

public class MainActivity extends AppCompatActivity {

    Person person1;
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

        person1 = new Person("Joabe", "Rochadel", "Android Development", "+554899090-5555");

        editFirstName = findViewById(R.id.editFirstName);
        editSecondName = findViewById(R.id.editSecondName);
        editCourse = findViewById(R.id.editCourse);
        editContact = findViewById(R.id.editContact);

        buttonClean = findViewById(R.id.buttonClean);
        buttonSave = findViewById(R.id.buttonSave);
        buttonFinish = findViewById(R.id.buttonFinish);

        editFirstName.setText(person1.getName());
        editSecondName.setText(person1.getSecondName());
        editCourse.setText(person1.getNameCourse());
        editContact.setText(person1.getNumberContact());

        buttonClean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editFirstName.setText("");
                editSecondName.setText("");
                editCourse.setText("");
                editContact.setText("");
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte Sempre!", Toast.LENGTH_LONG).show();
            }
        });

        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                person1.setName(editFirstName.getText().toString());
                person1.setSecondName(editSecondName.getText().toString());
                person1.setNumberContact(editContact.getText().toString());
                person1.setNameCourse(editCourse.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo: " + person1.toString(), Toast.LENGTH_LONG).show();
            }
        });


    }
}