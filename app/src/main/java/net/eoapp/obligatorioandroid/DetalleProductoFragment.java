package net.eoapp.obligatorioandroid;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;

public class DetalleProductoFragment extends Fragment {

    protected  dtProducto producto = null;
    TextView tvCodigo ;
    TextView tvNombre ;
    TextView tvCategoria ;
    TextView tvDescripcion ;
    TextView tvPrecio;
    ImageView ivFoto;
    Button btnComprar;
    onComprarListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof onComprarListener){
            listener = (onComprarListener)context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvCodigo = (TextView)getView().findViewById(R.id.tvCodigo);
        tvCategoria = (TextView)getView().findViewById(R.id.tvCategoria);
        tvDescripcion = (TextView)getView().findViewById(R.id.tvDescripcion);
        tvNombre = (TextView)getView().findViewById(R.id.tvNombre);
        tvPrecio = (TextView)getView().findViewById(R.id.tvPrecio);
        ivFoto = (ImageView)getView().findViewById(R.id.ivImagen);
        btnComprar = (Button)getView().findViewById(R.id.btnComprar);

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (producto == null)
                    Toast.makeText(getActivity(), "Seleccione un producto", Toast.LENGTH_LONG).show();
                else
                    listener.onCompraClick(producto);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        if (producto != null) mostrarProducto(producto);
    }

    public interface onComprarListener {
            void onCompraClick(dtProducto producto);
    }

    public void mostrarProducto(dtProducto producto) {
        this.producto = producto;
        tvCodigo.setText(String.valueOf(producto.getIdProducto()));
        tvCategoria.setText(producto.getCategoría());
        tvDescripcion.setText(producto.getDescripcion());
        tvNombre.setText(producto.getNombre());
        tvPrecio.setText(String.valueOf(producto.getPrecio()));

        if (producto.getIdFoto() != 0)
            ivFoto.setImageResource(producto.getIdFoto());
    }




}
