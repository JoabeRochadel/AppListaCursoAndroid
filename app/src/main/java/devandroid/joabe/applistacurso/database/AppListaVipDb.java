package devandroid.joabe.applistacurso.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import devandroid.joabe.applistacurso.model.Person;

public class AppListaVipDb extends SQLiteOpenHelper {

    private static final String DB_NAME = "listavip.db";
    private static final int DB_VERSION = 1;
    Cursor cursor;
    SQLiteDatabase db;

    public AppListaVipDb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SqlTableListaVip = "CREATE TABLE LISTAVIP (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "                           name TEXT, " +
                "                           secondName TEXT, " +
                "                           nameCourse TEXT, " +
                "                           numberContact TEXT, " +
                "                           requestedCourse REAL)";

        db.execSQL(SqlTableListaVip);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveObject(String table, ContentValues data) {
        db.insert(table, null, data);
    }

    public List<Person> ListData() {
        List<Person> listPerson = new ArrayList<>();
        Person reg;

        String sSql = "SELECT * FROM LISTAVIP";

        cursor = db.rawQuery(sSql, null);

        if (cursor.moveToFirst()) {

            do {
                reg = new Person();

                reg.setName(cursor.getString(0));
                reg.setSecondName(cursor.getString(1));
                reg.setNameCourse(cursor.getString(2));
                reg.setNumberContact(cursor.getString(3));
                reg.setRequestedCourse(cursor.getString(4));

                listPerson.add(reg);
            }
            while (cursor.moveToNext());
        } else {
            throw new RuntimeException("Ocorreu um erro -> Não há registros na tabela Person");
        }
        return listPerson;
    }

    public void AlterData(String table, ContentValues data) {
        int id = data.getAsInteger("id");

        db.update(table, data, "id=?", new String[]{Integer.toString(id)});
    }

    public void DeleteData(String table, int id) {
        db.delete(table, "id=?", new String[]{Integer.toString(id)});
    }
}
