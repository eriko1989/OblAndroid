package net.eoapp.obligatorioandroid.Data;

import android.provider.BaseColumns;

public final class BioDataBase{


    public static final String NOMBRE_BD = "BioDataBase.sqlite3";
    public static final int VERSION = 1;

    public static final String PRODUCTO = "Producto";
    public static final String PEDIDO = "Pedido";

    private BioDataBase() {

    }

    public static abstract class tblProducto implements BaseColumns {

        public static final String COL_CODIGO = "Codigo";
        public static final String COL_CATEGORIA = "Categoria";
        public static final String COL_NOMBRE = "Nombre";
        public static final String COL_DESCRIPCION = "Descripcion";
        public static final String COL_ID_FOTO = "UrlFoto";
        public static final String COL_PRECIO = "Precio";

        //public static final String[] COLUMNAS = { COL_CODIGO, COL_CATEGORIA, COL_NOMBRE, COL_DESCRIPCION, COL_ID_FOTO, COL_PRECIO};

        public static final String CREAR_TABLA = new StringBuilder("CREATE TABLE ").append(PRODUCTO).append(" (")
                                                    .append(COL_CODIGO).append(" INTEGER NOT NUL PRIMARY KEY AUTOINCREMENT, ")
                                                    .append(COL_CATEGORIA).append(" VARCHAR(50) NOT NULL, ")
                                                    .append(COL_NOMBRE).append(" VARCHAR(100) NOT NULL, ")
                                                    .append(COL_DESCRIPCION).append(" VARCHAR(300) NOT NULL, ")
                                                    .append(COL_ID_FOTO).append(" INTEGER NOT NULL, ")
                                                    .append(COL_PRECIO).append(" DOUBLE NOT NULL ); ").toString();


        public static final String ELIMINAR_TABLA = new StringBuilder("DROP TABLE IF EXISTS ").append(PRODUCTO).append(" ;").toString();

        public static final String VACIAR_TABLA= new StringBuilder("TRUNCATE TABLE IF EXISTS ").append(PRODUCTO).append(" ;").toString();
    }

    public static abstract class tblPedido implements BaseColumns {

        public static final String COL_ID_PRODUCTO = "IdProducto";
        public static final String COL_CANTIDAD = "Categoria";
        public static final String COL_TOTAL = "Total";
        public static final String COL_ENTREGADO = "Entregado";
        public static final String COL_PREPAGADO = "Prepagado";
        public static final String COL_CLIENTE = "Cliente";


        //public static final String[] COLUMNAS = { _ID, COL_ID_PRODUCTO, COL_CANTIDAD,COL_TOTAL,COL_ENTREGADO,COL_CLIENTE};


        public static final String CREAR_TABLA = new StringBuilder("CREATE TABLE ").append(PEDIDO).append(" (")
                .append(_ID).append(" INTEGER NOT NUL PRIMARY KEY AUTOINCREMENT, ")
                .append(COL_ID_PRODUCTO).append(" INTEGER NOT NULL, ")
                .append(COL_CANTIDAD).append(" INTEGER NOT NULL, ")
                .append(COL_TOTAL).append(" DOUBLE NOT NULL, ")
                .append(COL_ENTREGADO).append(" BIT NOT NULL DEFAULT 0, ")
                .append(COL_PREPAGADO).append(" BIT NOT NULL DEFAULT 0, ")
                .append("FOREIGN KEY (").append(COL_ID_PRODUCTO).append(") REFERENCES ").append(PRODUCTO).append("(")
                .append(tblProducto.COL_CODIGO).append(") ); " ).toString();


        public static final String ELIMINAR_TABLA = new StringBuilder("DROP TABLE IF EXISTS ").append(PEDIDO).append(" ;").toString();

        public static final String VACIAR_TABLA= new StringBuilder("TRUNCATE TABLE IF EXISTS ").append(PEDIDO).append(" ;").toString();
    }


}
