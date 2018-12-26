package net.eoapp.obligatorioandroid.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GenericAdapter<T> extends BaseAdapter
{
    private Context context = null;
    private List<T> objetos = null;
    private Class c;

    int layout = 0;

    Map<Integer, Method> metodos = null;

    public GenericAdapter(Context context, int layout, List<T> objetos, Class type){
        this.context = context;
        this.objetos = objetos;

        this.layout = layout;
        this.c = type;

        metodos = new HashMap();
    }

    public void setMethodReference(int view, String method) throws Exception {
        try{
            if (!metodos.containsKey(view))
                metodos.put(view, c.getMethod(method));
        }
        catch (Exception e){
            throw e;
        }
    }

    public void removeMethodReference(int view){
        if (!metodos.containsKey(view)){
            metodos.remove(view);
        }
    }

    @Override
    public int getCount() {
        return objetos.size();
    }

    @Override
    public Object getItem(int position) {
        return objetos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = null;
        ObjetoViewHolder vhObjeto = null;

        if (convertView == null){
            LayoutInflater inflador = LayoutInflater.from(context);
            v = inflador.inflate(layout, parent, false);

            vhObjeto = new ObjetoViewHolder(v);
            v.setTag(vhObjeto);
        }
        else{
            v = convertView;
            vhObjeto = (ObjetoViewHolder)v.getTag();
        }

        vhObjeto.enlazarObjeto(objetos.get(position));

        return v;
    }



    protected class ObjetoViewHolder {

        Map<Integer, View> views = null;


        public ObjetoViewHolder(View vista){
            views = new HashMap();

            for (Map.Entry<Integer, Method> entry : metodos.entrySet())
            {
                views.put(entry.getKey(), vista.findViewById(entry.getKey()));
            }
        }

        public void enlazarObjeto(Object object){
            for (Map.Entry<Integer, View> entry : views.entrySet())
            {
                try {
                    Method m = metodos.get(entry.getKey());
                    View v = entry.getValue();

                    String data = String.valueOf(m.invoke(object));

                    ((TextView)v).setText(data);
                }
                catch (Exception e){

                }

            }
        }

    }
}
