package responsi;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsipbo";
    static final String User = "root";
    static final String Pass = "";
    private static Connection connection;

    public static Connection getConnection(){
        if(connection == null){
            try{
                Class.forName(JDBC_DRIVER);
                connection = DriverManager.getConnection(DB_URL, User, Pass);
                System.out.println("Koneksi Berhasil");
            }catch(Exception e){
                System.out.println("Koneksi Gagal"+ e);
            }
        }
        return connection;
    }
}
