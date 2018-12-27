package net.eoapp.obligatorioandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import net.eoapp.obligatorioandroid.Data.DataPedido;
import net.eoapp.obligatorioandroid.Data.DataProducto;
import net.eoapp.obligatorioandroid.Data.GenericAdapter;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtPedido;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;

import java.util.List;

public class ListadoPedidosFragment extends Fragment {

    ListView lvPedidos;
    EditText etCliente;
    TextView tvTotal;

    protected ListadoPedidosFragment.OnPedidoSelectedListener listener;

    public static ProductosFragment newInstance(){
        return new ProductosFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ListadoPedidosFragment.OnPedidoSelectedListener) listener = (ListadoPedidosFragment.OnPedidoSelectedListener)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pedidos_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        etCliente = (EditText) getActivity().findViewById(R.id.etCliente);
        lvPedidos = (ListView) getActivity().findViewById(R.id.lvPedidos);
        tvTotal = (TextView) getActivity().findViewById(R.id.tv_total_lista_pedido);

        etCliente.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == 6969) {
                    new getPedidos().execute(etCliente.getText().toString().trim());
                    ocultarTeclado();
                    return true;
                }
                return false;
            }
        });

        lvPedidos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onPedidoSelected((dtPedido)parent.getItemAtPosition(position));
            }
        });

        new getPedidos().execute("");
    }


    public void refresh(){
        new getPedidos().execute(etCliente.getText().toString().trim());
    }

    public interface OnPedidoSelectedListener {
        void onPedidoSelected(dtPedido producto);
    }

    protected void ocultarTeclado(){
        InputMethodManager gestorMetodoEntrada = (InputMethodManager)etCliente.getContext().getSystemService(getActivity().INPUT_METHOD_SERVICE);
        gestorMetodoEntrada.hideSoftInputFromWindow(etCliente.getWindowToken(), 0);
    }


    class getPedidos extends AsyncTask<String, Boolean, List<dtPedido>> {

        @Override
        protected List<dtPedido> doInBackground(String... strings) {
            return DataPedido.getPedidos(getActivity(), strings[0]);
        }

        @Override
        protected void onPostExecute(List<dtPedido> pedidos) {
            try {
                GenericAdapter<dtPedido> adapter = new GenericAdapter<>(getActivity(), R.layout.item_listado_pedido, pedidos, dtPedido.class);

                adapter.setMethodReference(R.id.tv_id_pedido_item, "getId");
                adapter.setMethodReference(R.id.tv_cliente_pedido_item, "getCliente");
                adapter.setMethodReference(R.id.tv_monto_pedido_item, "getTotal");
                adapter.setMethodReference(R.id.tv_fecha_pedido_item, "getFecha");

                lvPedidos.setAdapter(adapter);

                double total = 0;
                for(dtPedido p : pedidos){
                    total += p.getTotal();
                }

                total = Math.round(total*100);
                total = total / 100;

                tvTotal.setText(String.valueOf(total));
            }
            catch (Exception e){
                Toast.makeText(getActivity(), "Ocurrió un error al cargar los pedidos", Toast.LENGTH_LONG).show();
            }
        }
    }

}
