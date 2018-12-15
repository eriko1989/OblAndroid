package net.eoapp.obligatorioandroid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.eoapp.obligatorioandroid.EntidadesCompartidas.Producto;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Comentario de prueba : lo ves erik??? asd

        Producto p = new Producto();
    }
}
