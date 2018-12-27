package net.eoapp.obligatorioandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import net.eoapp.obligatorioandroid.Data.DataPedido;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;

import java.util.List;

public class CompraProductoFragment extends Fragment {

    TextView tvPrueba;
    dtProducto producto;
    AutoCompleteTextView atvNombre;

    public void setProducto(dtProducto producto) {
        this.producto = producto;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_compra_produto, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<String> nombres = DataPedido.getNombres(getContext());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_expandable_list_item_1,nombres);
        atvNombre = (AutoCompleteTextView) getView().findViewById(R.id.atvNombre);
        atvNombre.setAdapter(adapter);


    }
}
