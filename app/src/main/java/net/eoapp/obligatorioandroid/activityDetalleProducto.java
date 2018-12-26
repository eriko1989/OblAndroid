package net.eoapp.obligatorioandroid;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.eoapp.obligatorioandroid.EntidadesCompartidas.Constantes;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;

import java.io.FileReader;

public class activityDetalleProducto extends AppCompatActivity {

    dtProducto producto;
    DetalleProductoFragment frgDetalleProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
        frgDetalleProducto = (DetalleProductoFragment)getSupportFragmentManager().findFragmentById(R.id.fgDetaleCompra);


        Bundle extras = getIntent().getExtras();
        producto = (dtProducto)extras.getSerializable(Constantes.PRODUCTO_SELECTED);


    }

    @Override
    protected void onStart() {
        super.onStart();

        if(producto != null) frgDetalleProducto.mostrarProducto(producto);
    }
}
