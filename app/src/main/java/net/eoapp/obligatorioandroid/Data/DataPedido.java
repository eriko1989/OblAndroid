package net.eoapp.obligatorioandroid.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import net.eoapp.obligatorioandroid.EntidadesCompartidas.Constantes;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtPedido;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;

import java.util.ArrayList;
import java.util.List;

public class DataPedido {

    public static List<dtPedido> getPedidos(Context context, String cliente){
        SQLiteDatabase db = BioOpenHelper.getDB(context);
        Cursor cursor = null;
        List<dtPedido> pedidos = new ArrayList();
        try{
            cursor = db.query(BioDataBase.PEDIDO,BioDataBase.tblPedido.COLUMNAS,BioDataBase.tblPedido.COL_CLIENTE + " LIKE '%"+ cliente +"%' " , null,null,null,BioDataBase.tblPedido._ID);
            while (cursor.moveToNext())
            {
                dtProducto prod = new dtProducto();
                prod.setIdProducto(cursor.getInt(cursor.getColumnIndex(BioDataBase.tblPedido.COL_ID_PRODUCTO)));

                pedidos.add(new dtPedido(
                        prod,
                        cursor.getInt(cursor.getColumnIndex(BioDataBase.tblPedido.COL_CANTIDAD)),
                        cursor.getInt(cursor.getColumnIndex(BioDataBase.tblPedido.COL_ENTREGADO)) == 1,
                        cursor.getInt(cursor.getColumnIndex(BioDataBase.tblPedido.COL_PREPAGADO)) == 1,
                        cursor.getString(cursor.getColumnIndex(BioDataBase.tblPedido.COL_CLIENTE)),
                        cursor.getString(cursor.getColumnIndex(BioDataBase.tblPedido.COL_FECHA)),
                        cursor.getInt(cursor.getColumnIndex(BioDataBase.tblPedido._ID)),
                        cursor.getDouble(cursor.getColumnIndex(BioDataBase.tblPedido.COL_TOTAL))
                ));}

        }catch (Exception e){
            Log.e(Constantes.ERROR_DB,e.getMessage());
        }
        finally {
            if (cursor != null) cursor.close();
            if (db != null && db.isOpen()) db.close();
        }

        return  pedidos;
    }
}
