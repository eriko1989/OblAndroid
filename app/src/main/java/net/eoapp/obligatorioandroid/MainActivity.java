package net.eoapp.obligatorioandroid;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import net.eoapp.obligatorioandroid.Data.BioOpenHelper;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.Constantes;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;


public class MainActivity extends AppCompatActivity implements  ProductosFragment.OnProductoSelectedListener {

    ProductosFragment productosFragment;
    DetalleProductoFragment detalleFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productosFragment = (ProductosFragment) getSupportFragmentManager().findFragmentById(R.id.fgMain);
        detalleFragment = (DetalleProductoFragment) getSupportFragmentManager().findFragmentById(R.id.fgDetaleCompra);
    }


    @Override
    public void onProductoSelected(dtProducto producto) {
        if (detalleFragment == null || !detalleFragment.isAdded()) {
            Intent i = new Intent(getApplicationContext(), activityDetalleProducto.class);
            i.putExtra(Constantes.PRODUCTO_SELECTED, producto);
            startActivity(i);
        } else {
            detalleFragment.mostrarProducto(producto);
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mniVerPedidos:
                Toast.makeText(this, "Abrir activity lista pedidos", Toast.LENGTH_SHORT).show();
                return true;
        }

        return false;
    }



}
