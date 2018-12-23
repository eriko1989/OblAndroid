package net.eoapp.obligatorioandroid;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.eoapp.obligatorioandroid.Data.BioOpenHelper;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;


public class MainActivity extends AppCompatActivity implements  ProductosFragment.OnProductoSelectedListener {

    SQLiteDatabase baseDatos;
    ProductosFragment productosFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseDatos = BioOpenHelper.getDB(this);

        productosFragment = (ProductosFragment)getSupportFragmentManager().findFragmentById(R.id.fgMain);




    }


    @Override
    public void onProductoSelected(dtProducto producto) {
        //aca nos avisa que se selecciono un producto, esto es para que iniciemos la
        //actividad del detalle
    }
}
