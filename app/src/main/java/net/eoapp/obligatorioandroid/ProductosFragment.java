package net.eoapp.obligatorioandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import net.eoapp.obligatorioandroid.Data.DataProducto;
import net.eoapp.obligatorioandroid.Data.GenericAdapter;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;

import java.util.List;

public class ProductosFragment extends Fragment {

    List<String> categrias;
    SQLiteDatabase db;
    Spinner spinner;
    ListView lvProductos;


    protected OnProductoSelectedListener listener;

    public static ProductosFragment newInstance(){
        return new ProductosFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof  OnProductoSelectedListener) listener = (OnProductoSelectedListener)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         return inflater.inflate(R.layout.fragment_productos, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        spinner = getActivity().findViewById(R.id.spCategorias);
        lvProductos = getActivity().findViewById(R.id.lvProductos);
        categrias = DataProducto.getCategorias(getActivity());

        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, categrias);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onCatSelected(categrias.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    void onCatSelected(String cat) {
        List<dtProducto> productos = DataProducto.getProductos(getActivity(),cat);

        GenericAdapter adapter = new GenericAdapter(getActivity(), R.layout.item_producto_list, productos);


        Class c = dtProducto.class;
        try {

            adapter.setMethodReference(R.id.tvNombreProducto, c.getMethod("getNombre"));
            adapter.setMethodReference(R.id.tvPrecioProducto, c.getMethod("getPrecio"));
        }
        catch (Exception e){}

        lvProductos.setAdapter(adapter);

    }

    public interface OnProductoSelectedListener{
        void onProductoSelected(dtProducto producto);

    }

}
