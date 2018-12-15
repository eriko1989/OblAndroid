package net.eoapp.obligatorioandroid;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.eoapp.obligatorioandroid.Data.BioOpenHelper;


public class MainActivity extends AppCompatActivity {

    SQLiteDatabase baseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseDatos = BioOpenHelper.getDB(this);


    }
}
