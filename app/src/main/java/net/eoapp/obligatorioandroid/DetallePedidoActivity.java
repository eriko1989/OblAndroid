package net.eoapp.obligatorioandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import net.eoapp.obligatorioandroid.EntidadesCompartidas.Constantes;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtPedido;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;

public class DetallePedidoActivity extends AppCompatActivity implements PedidoDetalleFragment.OnEntregarPedidoListener {

    dtPedido pedido;
    PedidoDetalleFragment fgDetallePedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pedido);

        Bundle extras = getIntent().getExtras();
        pedido = (dtPedido)extras.getSerializable(Constantes.PEDIDO_SELECTED);

        fgDetallePedido = (PedidoDetalleFragment) getSupportFragmentManager().findFragmentById(R.id.fgDetallePedido);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (pedido != null) fgDetallePedido.cargarPedido(pedido);
    }

    @Override
    public void onEntregarPedido(dtPedido pedido) {

    }
}