package net.eoapp.obligatorioandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.eoapp.obligatorioandroid.Data.DataProducto;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtPedido;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;

public class PedidoDetalleFragment extends Fragment {

    dtPedido pedido;
    TextView tv_id;
    TextView tv_cliente;
    TextView tv_fecha;
    TextView tv_producto;
    TextView tv_cantidad;
    TextView tv_monto;
    TextView tv_pago;

    Button btn_entrgar;
    protected PedidoDetalleFragment.OnEntregarPedidoListener listener;

    public static ProductosFragment newInstance(){
        return new ProductosFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PedidoDetalleFragment.OnEntregarPedidoListener) listener = ( PedidoDetalleFragment.OnEntregarPedidoListener)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle_pedido, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tv_id = (TextView) getActivity().findViewById(R.id.tv_id_pedido);
        tv_cliente = (TextView) getActivity().findViewById(R.id.tv_cliente_pedido);
        tv_fecha = (TextView) getActivity().findViewById(R.id.tv_fecha_pedido);
        tv_producto = (TextView) getActivity().findViewById(R.id.tv_prodcuto_pedido);
        tv_cantidad = (TextView) getActivity().findViewById(R.id.tv_cantidad_pedido);
        tv_monto = (TextView) getActivity().findViewById(R.id.tv_monto_pedido);
        tv_pago = (TextView) getActivity().findViewById(R.id.tv_pagado_pedido);

        btn_entrgar = (Button) getActivity().findViewById(R.id.btn_entregar);

        btn_entrgar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (pedido == null)
                    Toast.makeText(getActivity(), "Seleccione un pedido", Toast.LENGTH_SHORT).show();
                else
                    listener.onEntregarPedido(pedido);
            }
        });
    }

    public void cargarPedido(dtPedido pedido){
        this.pedido = pedido;

        tv_id.setText(String.valueOf(pedido.getId()));
        tv_cliente.setText(pedido.getCliente());
        tv_fecha.setText(pedido.getFecha());
        tv_producto.setText(pedido.getElProducto().getNombre());
        tv_cantidad.setText(String.valueOf(pedido.getCantidad()));
        tv_monto.setText(String.valueOf(pedido.getTotal()));
        tv_pago.setText(pedido.isPrepagado() ? "Si" : "No");
    }

    public void clean(){
        this.pedido = null;

        tv_id.setText("");
        tv_cliente.setText("");
        tv_fecha.setText("");
        tv_producto.setText("");
        tv_cantidad.setText("");
        tv_monto.setText("");
        tv_pago.setText("");
    }

    public interface OnEntregarPedidoListener{
        void onEntregarPedido(dtPedido pedido);
    }




}
