package net.eoapp.obligatorioandroid;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
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

public class ListadoPedidosActivity extends AppCompatActivity {

    ListView lvPedidos;
    EditText etCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_pedidos);

            etCliente = (EditText) findViewById(R.id.etCliente);
            lvPedidos = (ListView) findViewById(R.id.lvPedidos);

            lvPedidos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    onPedidoClick(parent, view, position, id);
                }
            });


//            etCliente.OnEditorActionListener(new TextView.OnEditorActionListener(){
//                @Override
//                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//
//
//
//                    return false;
//                }
//            });

            new getPedidos().execute("");
    }

    public void onPedidoClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Abrir activity detalle pedido", Toast.LENGTH_LONG).show();
    }


    class getPedidos extends AsyncTask<String, Boolean, List<dtPedido>> {

        @Override
        protected List<dtPedido> doInBackground(String... strings) {
            return DataPedido.getPedidos(ListadoPedidosActivity.this, strings[0]);
        }

        @Override
        protected void onPostExecute(List<dtPedido> pedidos) {
            try {
                GenericAdapter<dtPedido> adapter = new GenericAdapter<>(ListadoPedidosActivity.this, R.layout.item_listado_pedido, pedidos, dtPedido.class);

                adapter.setMethodReference(R.id.tv_id_pedido_item, "getId");
                adapter.setMethodReference(R.id.tv_cliente_pedido_item, "getCliente");
                adapter.setMethodReference(R.id.tv_monto_pedido_item, "getTotal");
                adapter.setMethodReference(R.id.tv_fecha_pedido_item, "getFecha");

                lvPedidos.setAdapter(adapter);
            }
            catch (Exception e){
                Toast.makeText(ListadoPedidosActivity.this, "Ocurrió un error al cargar los pedidos", Toast.LENGTH_LONG).show();
            }
        }
    }

}
