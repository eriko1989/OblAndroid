package net.eoapp.obligatorioandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.eoapp.obligatorioandroid.EntidadesCompartidas.Constantes;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;

import java.io.FileReader;

public class activityDetalleProducto extends AppCompatActivity {

    dtProducto producto;
    DetalleProductoFragment frgDetalleProducto;
    CompraProductoFragment frgCompraProducto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        frgDetalleProducto = new DetalleProductoFragment(); //(DetalleProductoFragment)getSupportFragmentManager().findFragmentById(R.id.fgDetaleCompra);
        frgCompraProducto= new CompraProductoFragment(); // (CompraProductoFragment)getSupportFragmentManager().findFragmentById(R.id.fgDetaleCompra);

        Bundle extras = getIntent().getExtras();
        producto = (dtProducto)extras.getSerializable(Constantes.PRODUCTO_SELECTED);

        changeFragment(Constantes.DETALLE_PRODUCTO, false);

    }

    @Override
    protected void onStart() {
        super.onStart();

        if(producto != null) frgDetalleProducto.mostrarProducto(producto);
    }


    public void changeFragment(String constante, boolean addToBackStack)
    {
        Fragment fragmentToView = Constantes.COMPRA_PRODUCTO == constante ? frgCompraProducto : frgDetalleProducto;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.replace(R.id.frlZonaIntercambio, fragmentToView);
        if (addToBackStack) {
            transaction.addToBackStack(fragmentToView.getClass().getSimpleName());
        }

        transaction.commit();
    }


}
