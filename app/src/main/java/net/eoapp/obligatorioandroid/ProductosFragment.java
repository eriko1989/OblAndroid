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
import android.widget.Toast;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, categrias);
        spinner.setAdapter(adapter);

        //Evento de selección de uno de los items del spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                onCatSelected(categrias.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Evento click en cada item del listView
        lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onProductoSelected((dtProducto)parent.getItemAtPosition(position));
            }
        });
    }


    void onCatSelected(String cat) {
        try {
            List<dtProducto> productos = DataProducto.getProductos(getActivity(),cat);
            GenericAdapter adapter = new GenericAdapter<dtProducto>(getActivity(), R.layout.item_producto_list, productos, dtProducto.class);

            adapter.setMethodReference(R.id.tvNombreProducto, "getNombre");
            adapter.setMethodReference(R.id.tvPrecioProducto, "getPrecio");

            lvProductos.setAdapter(adapter);
        }
        catch (Exception e){
            Toast.makeText(getActivity(), "Ocurrió un error al cargar los productos", Toast.LENGTH_LONG).show();
        }

    }

    public interface OnProductoSelectedListener{
        void onProductoSelected(dtProducto producto);
    }

}
