package net.eoapp.obligatorioandroid;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import net.eoapp.obligatorioandroid.Data.DataPedido;
import net.eoapp.obligatorioandroid.Data.GenericAdapter;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtPedido;

import java.nio.channels.AsynchronousChannelGroup;
import java.util.List;

public class ListadoPedidosActivity extends AppCompatActivity implements ListadoPedidosFragment.OnPedidoSelectedListener {

    ListadoPedidosFragment fgListadoPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_pedidos);
        fgListadoPedidos = (ListadoPedidosFragment) getSupportFragmentManager().findFragmentById(R.id.fgListadoPedido);

    }

    @Override
    public void onPedidoSelected(dtPedido producto) {
        Toast.makeText(this, "Llamar a fragment detalle ", Toast.LENGTH_LONG).show();
    }

}
