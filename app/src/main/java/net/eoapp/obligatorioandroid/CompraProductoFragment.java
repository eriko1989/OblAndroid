package net.eoapp.obligatorioandroid;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import net.eoapp.obligatorioandroid.Data.DataPedido;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtPedido;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;

import java.util.Date;

public class CompraProductoFragment extends Fragment {

    TextView tvCodigo;
    TextView tvCategoria;
    TextView tvNombre;
    TextView tvPrecio;
    EditText etCantidad;
    EditText etCliente;
    dtProducto producto;
    AutoCompleteTextView atvNombre;
    Button btnConfirmar;
    dtPedido pedido;
    onConfirmarListener listener;
    CheckBox chkPrepago;

    public void setProducto(dtProducto producto) {
        this.producto = producto;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_compra_produto, container, false);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

       ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1,DataPedido.getNombres(getContext()));
        atvNombre = (AutoCompleteTextView) getView().findViewById(R.id.atvNombre);
        atvNombre.setAdapter(adapter);

        tvCategoria = (TextView)getView().findViewById(R.id.tvCategoria);
        tvCategoria.setText(producto.getCategoría());
        tvCategoria.setEnabled(false);

        tvNombre = (TextView)getView().findViewById(R.id.tvNombre);
        tvNombre.setText(producto.getNombre());
        tvNombre.setEnabled(false);

        tvPrecio = (TextView)getView().findViewById(R.id.tvPrecio);
        tvPrecio.setText(String.valueOf(producto.getPrecio()));
        tvPrecio.setEnabled(false);

        tvCodigo = (TextView)getView().findViewById(R.id.tvCodigo);
        tvCodigo.setText(String.valueOf(producto.getIdProducto()));
        tvCodigo.setEnabled(false);



        btnConfirmar = (Button)getView().findViewById(R.id.btnConfirmar);
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etCantidad = (EditText) getView().findViewById(R.id.etCantidad);
                int cantidad = Integer.parseInt(String.valueOf(etCantidad.getText()));
                etCliente = (EditText) getView().findViewById(R.id.etCliente);
                String cliente = String.valueOf(etCliente.getText());
                chkPrepago = (CheckBox)getView().findViewById(R.id.cbPrepago);
                boolean prepago = chkPrepago.isChecked();
                double total = (producto.getPrecio()*cantidad);

                String s = new Date().toString();

                pedido = new dtPedido(producto, cantidad,false,prepago,cliente, new Date().toString(),0, total);

                listener.onConfirmarListener(pedido);
            }
        });


    }

    public interface onConfirmarListener {

        void onConfirmarListener(dtPedido pedido);

    }


}
