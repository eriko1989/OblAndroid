package net.eoapp.obligatorioandroid;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.eoapp.obligatorioandroid.Data.BioOpenHelper;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;


public class MainActivity extends AppCompatActivity implements  ProductosFragment.OnProductoSelectedListener {

    public static final String PRODUCTO_SELECTED = "PRODUCTO_SELECTED";
    ProductosFragment productosFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productosFragment = (ProductosFragment)getSupportFragmentManager().findFragmentById(R.id.fgMain);
    }


    @Override
    public void onProductoSelected(dtProducto producto) {
        Intent i = new Intent(getApplicationContext(), activityDetalleProducto.class);
        i.putExtra(PRODUCTO_SELECTED, producto);
        startActivity(i);
    }


}
