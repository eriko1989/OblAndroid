package net.eoapp.obligatorioandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import net.eoapp.obligatorioandroid.Data.DataPedido;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.Constantes;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtPedido;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;

public class activityDetalleProducto extends AppCompatActivity implements DetalleProductoFragment.onComprarListener, CompraProductoFragment.onConfirmarListener {

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


    @Override
    public void onCompraClick(dtProducto producto) {

        frgCompraProducto.setProducto(producto);
        this.changeFragment(Constantes.COMPRA_PRODUCTO, true);
    }


    @Override
    public void onConfirmarListener(dtPedido pedido) {
        try {
                DataPedido.setPedido(this, pedido);
                Toast.makeText(this, "Compra confirmada!", Toast.LENGTH_LONG).show();

                changeFragment(Constantes.DETALLE_PRODUCTO, false);

            }catch (Exception e){
                Toast.makeText(this,"Error al confirmar la compra.", Toast.LENGTH_LONG).show();
            }

    }
}
