package net.eoapp.obligatorioandroid.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import net.eoapp.obligatorioandroid.R;

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


        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (0,'Cosmeticos','Pinta uñas', 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed qui.',"+ R.drawable.cosmeticos1 +",99.99);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (1,'Cosmeticos','Kit Cosmeticos Wow!', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.',"+ R.drawable.cosmeticos2 +",1500.00);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (2,'Cosmeticos','Kit Cosmeticos Oh my gosh!', 'But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoid.',"+R.drawable.cosmeticos3+",200.00);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (3,'Cosmeticos','Sombreador', 'Brick quiz whangs jumpy veldt fox. Bright vixens jump; dozy fowl quack. Quick wafting zephyrs vex bold Jim. Quick zephyrs blow, vexing daft Jim. Sex-charged fop blew my junk TV quiz. How quickly daft jumping zebras vex.',"+ R.drawable.cosmeticos4 +",399.99);").toString());

        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (4,'Labiales','Ai Labiu', 'Li Europan lingues es membres del sam familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On.',"+R.drawable.labiales1+",225.99);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (5,'Labiales','Uh la Labial','The European languages are members of the same family. Their separate existence is a myth. For science, music, sport, etc, Europe uses the same vocabulary. The languages only differ in their grammar, their pronunciation and their most common words. Everyone realizes why a new common language would.',"+R.drawable.labiales2+",123.99);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (6,'Labiales','Labial rouge', 'Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows by their place and supplies it with the necessary.',"+R.drawable.labiales3+",432.99);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (7,'Labiales','Labialette', 'A wonderful serenity has taken possession of my entire soul, like these sweet mornings of spring which I enjoy with my whole heart. I am alone, and feel the charm of existence in this spot, which was created for the bliss of souls like mine. I am so happy, my dear friend.',"+R.drawable.labiales4+",200.00);").toString());


        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (8,'Ropa interior','Naherma', ' Samsa was a travelling salesman - and above it there hung a picture that he had recently cut out of an illustrated magazine and housed in a nice, gilded frame. It showed a lady fitted out with a fur hat and',"+R.drawable.ropa1+",449.99);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (9,'Ropa interior','Guarda', 'The quick, brown fox jumps over a lazy dog. DJs flock by when MTV ax quiz prog. Junk MTV quiz graced by fox whelps. Bawds jog, flick quartz, vex nymphs. Waltz, bad nymph, for quick jigs vex! Fox nymphs grab quick-jived waltz',"+R.drawable.ropa2+",739.99);").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PRODUCTO).append(" VALUES (10,'Ropa interior','Socconete', 'Cozy sphinx waves quart jug of bad milk. A very bad quack might jinx zippy fowls. Few quips galvanized the mock jury box. Quick brown dogs jump over the lazy fox. The jay, pig, fox, zebra, and my wolves quack! Blowzy red vixens fight for a quick jump.',"+R.drawable.ropa3+",629.99);").toString());


        //_ID, COL_ID_PRODUCTO, COL_CANTIDAD,COL_TOTAL,COL_ENTREGADO,COL_CLIENTE
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PEDIDO)
                .append(" VALUES (null, 0, 1, 299.99, 0, 1, 'Pedro Picapiedra', '25/12/2018 14:58:00');").toString());
        sqLiteDatabase.execSQL(new StringBuilder("INSERT INTO ").append(BioDataBase.PEDIDO)
                .append(" VALUES (null, 0, 1, 299.99, 0, 1, 'Juan Antonio', '25/12/2018 14:58:00');").toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void eliminarBaseDatos() {

        context.deleteDatabase(BioDataBase.NOMBRE_BD);
    }


}
