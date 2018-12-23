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
    DetalleProductoFragment detalleFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productosFragment = (ProductosFragment)getSupportFragmentManager().findFragmentById(R.id.fgMain);
        detalleFragment = (DetalleProductoFragment)getSupportFragmentManager().findFragmentById(R.id.fgDetaleCompra);
    }


    @Override
    public void onProductoSelected(dtProducto producto) {
        if (detalleFragment == null || !detalleFragment.isAdded()){
            Intent i = new Intent(getApplicationContext(), activityDetalleProducto.class);
            i.putExtra(PRODUCTO_SELECTED, producto);
            startActivity(i);
        }
        else{
            detalleFragment.mostrarProducto(producto);
        }
    }


}
