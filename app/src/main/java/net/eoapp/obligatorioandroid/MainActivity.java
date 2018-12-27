package net.eoapp.obligatorioandroid;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import net.eoapp.obligatorioandroid.Data.BioOpenHelper;
import net.eoapp.obligatorioandroid.Data.DataPedido;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.Constantes;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtPedido;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;


public class MainActivity extends AppCompatActivity implements  ProductosFragment.OnProductoSelectedListener, DetalleProductoFragment.onComprarListener, CompraProductoFragment.onConfirmarListener {

    ProductosFragment productosFragment;
    DetalleProductoFragment detalleFragment;
    CompraProductoFragment frgCompraProducto;
    Button btnComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productosFragment = (ProductosFragment) getSupportFragmentManager().findFragmentById(R.id.fgMain);
        detalleFragment = new DetalleProductoFragment();
        frgCompraProducto = new CompraProductoFragment();

        changeFragment(Constantes.DETALLE_PRODUCTO, false);
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
                Intent i = new Intent(getApplicationContext(), ListadoPedidosActivity.class);
                startActivity(i);
                return true;
        }

        return false;
    }



    public void changeFragment(String constante, boolean addToBackStack)
    {
        int scree = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

        if ((scree == Configuration.SCREENLAYOUT_SIZE_XLARGE || scree == Configuration.SCREENLAYOUT_SIZE_LARGE)
                && getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {

            Fragment fragmentToView = detalleFragment;
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.replace(R.id.frlZonaIntercambioMain, fragmentToView);
            if (addToBackStack) {
                transaction.addToBackStack(fragmentToView.getClass().getSimpleName());
            }

            transaction.commit();
        }
    }


    @Override
    public void onCompraClick(dtProducto producto) {

        frgCompraProducto.setProducto(producto);
        this.changeFragment(Constantes.COMPRA_PRODUCTO, true);
    }

    @Override
    public void onConfirmarListener(dtPedido pedido) {
        try {
            DataPedido.setPedido(this, pedido);
        }catch (Exception e){
            Toast.makeText(this,"Error al confirmar la compra", Toast.LENGTH_LONG).show();
        }

    }
}
