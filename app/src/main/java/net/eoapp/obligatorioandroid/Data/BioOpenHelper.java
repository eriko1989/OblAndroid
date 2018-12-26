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


        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (0,'Cosmeticos','Jabon de la descarga', 'Esta es la descripcion del jabon de la descarga',1,99.99);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (1,'Cosmeticos','Producto 1', 'Esta es la descripcion del jabon de la descarga',1,100.00);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (2,'Cosmeticos','Producto 2', 'Esta es la descripcion del jabon de la descarga',1,200.00);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (3,'Cosmeticos','Producto 3', 'Esta es la descripcion del jabon de la descarga',1,199.99);").toString());

        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (4,'Labiales','Carmin', 'Esta es la descripcion del jabon de la descarga',1,89.99);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (5,'Labiales','Azul francia', 'Esta es la descripcion del jabon de la descarga',1,69.99);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (6,'Labiales','Arcoiris', 'Esta es la descripcion del jabon de la descarga',1,59.99);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (7,'Labiales','Tipo negra', 'Esta es la descripcion del jabon de la descarga',1,200.00);").toString());


        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (8,'Ropa interior','Pa tu hermana', 'Esta es la descripcion del jabon de la descarga',1,449.99);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (9,'Ropa interior','Pa tu tía', 'Esta es la descripcion del jabon de la descarga',1,739.99);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (10,'Ropa interior','Pa tu vieja', 'Esta es la descripcion del jabon de la descarga',1,629.99);").toString());


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void eliminarBaseDatos() {

        context.deleteDatabase(BioDataBase.NOMBRE_BD);
    }


}
