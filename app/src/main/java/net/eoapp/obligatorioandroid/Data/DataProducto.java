package net.eoapp.obligatorioandroid.Data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ListView;

import net.eoapp.obligatorioandroid.EntidadesCompartidas.Constantes;
import net.eoapp.obligatorioandroid.EntidadesCompartidas.dtProducto;

import java.util.ArrayList;
import java.util.List;

public class DataProducto {

    public static List<String> getCategorias(Context context){
        SQLiteDatabase db = BioOpenHelper.getDB(context);
        Cursor cursor = null;
        List<String> categorias = new ArrayList();

        try {

            cursor = db.query(BioDataBase.PRODUCTO,
                    new String[]{BioDataBase.tblProducto.COL_CATEGORIA},
                    null,
                    null,
                    BioDataBase.tblProducto.COL_CATEGORIA,
                    null,
                    BioDataBase.tblProducto.COL_CATEGORIA);


            while (cursor.moveToNext()) {
                categorias.add(cursor.getString(0));
            }


        }
        catch (Exception e){
            Log.e(Constantes.ERROR_DB, e.getMessage());
        }
        finally {
            if (cursor != null) cursor.close();
            if (db != null && db.isOpen()) db.close();
        }

        return categorias;
    }




    public static List<dtProducto> getProductos(Context context, String cat){
        SQLiteDatabase db = BioOpenHelper.getDB(context);
        Cursor cursor = null;
        List<dtProducto> productos = new ArrayList();
        try{
            cursor = db.query(BioDataBase.PRODUCTO,BioDataBase.tblProducto.COLUMNAS,BioDataBase.tblProducto.COL_CATEGORIA + " = ? " , new String[]{cat},null,null,BioDataBase.tblProducto.COL_NOMBRE);
            while (cursor.moveToNext())
            {

                productos.add(new dtProducto(
                        cursor.getInt(cursor.getColumnIndex(BioDataBase.tblProducto._ID)),
                        cursor.getString(cursor.getColumnIndex(BioDataBase.tblProducto.COL_CATEGORIA)),
                        cursor.getString(cursor.getColumnIndex(BioDataBase.tblProducto.COL_NOMBRE)),
                        cursor.getString(cursor.getColumnIndex(BioDataBase.tblProducto.COL_DESCRIPCION)),
                        cursor.getInt(cursor.getColumnIndex(BioDataBase.tblProducto.COL_ID_FOTO)),
                        cursor.getDouble(cursor.getColumnIndex(BioDataBase.tblProducto.COL_PRECIO))
                ));}

        }catch (Exception e){
            Log.e(Constantes.ERROR_DB,e.getMessage());
        }
        finally {
            if (cursor != null) cursor.close();
            if (db != null && db.isOpen()) db.close();
        }
        return  productos;
    }

    public static dtProducto getProducto(Context context, int id){
        SQLiteDatabase db = BioOpenHelper.getDB(context);
        Cursor cursor = null;
        dtProducto producto = null;
        try{
            cursor = db.query(BioDataBase.PRODUCTO,BioDataBase.tblProducto.COLUMNAS,BioDataBase.tblProducto._ID + " = ? " , new String[]{ String.valueOf(id) },null,null,null);
            while (cursor.moveToNext()) {

                producto = new dtProducto(
                        cursor.getInt(cursor.getColumnIndex(BioDataBase.tblProducto._ID)),
                        cursor.getString(cursor.getColumnIndex(BioDataBase.tblProducto.COL_CATEGORIA)),
                        cursor.getString(cursor.getColumnIndex(BioDataBase.tblProducto.COL_NOMBRE)),
                        cursor.getString(cursor.getColumnIndex(BioDataBase.tblProducto.COL_DESCRIPCION)),
                        cursor.getInt(cursor.getColumnIndex(BioDataBase.tblProducto.COL_ID_FOTO)),
                        cursor.getDouble(cursor.getColumnIndex(BioDataBase.tblProducto.COL_PRECIO))
                );
            }

        }catch (Exception e){
            Log.e(Constantes.ERROR_DB,e.getMessage());
        }
        finally {
            if (cursor != null) cursor.close();
            if (db != null && db.isOpen()) db.close();
        }
        return  producto;
    }

}
