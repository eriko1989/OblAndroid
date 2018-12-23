package net.eoapp.obligatorioandroid;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;

public class DetalleProductoFragment extends Fragment {

    protected  dtProducto producto = null;

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public dtProducto getProducto() {
        return producto;
    }

    public void setProducto(dtProducto producto) {
        this.producto = producto;
    }
}
