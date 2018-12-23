package net.eoapp.obligatorioandroid.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class BioOpenHelper extends SQLiteOpenHelper {

    private  Context context;


    public BioOpenHelper(@Nullable Context context) {
        super(context, BioDataBase.NOMBRE_BD, null, BioDataBase.VERSION);
        this.context = context;
    }

    public static SQLiteDatabase getDB(Context contextual){
        return new BioOpenHelper(contextual).getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(BioDataBase.tblProducto.CREAR_TABLA);
        sqLiteDatabase.execSQL(BioDataBase.tblPedido.CREAR_TABLA);

        /*Generamos los datos de prueba: 10 productos de 3 categoríaS*/
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (0,'Cosmeticos','Jabon de la descarga', 'Esta es la descripcion del jabon de la descarga',1,100.10);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (1,'Labiales','Jabon de la descarga', 'Esta es la descripcion del jabon de la descarga',1,100.10);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (2,'Ropa interior','Jabon de la descarga', 'Esta es la descripcion del jabon de la descarga',1,100.10);").toString());


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void eliminarBaseDatos() {

        context.deleteDatabase(BioDataBase.NOMBRE_BD);
    }


}
