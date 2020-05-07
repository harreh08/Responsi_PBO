package responsi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class InputModel {
    private String hari;
    private String terdeteksi;
    private String sembuh;
    private String meninggal;

    public String getTerdeteksi() {
        return terdeteksi;
    }

    public void setTerdeteksi(String nama) { this.terdeteksi = terdeteksi;
    }

    public String getSembuh() {
        return sembuh;
    }

    public void setSembuh(String sembuh) {
        this.sembuh = this.sembuh;
    }
    public String getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(String meninggal) {
        this.meninggal = this.meninggal;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }


    Connection koneksi;
    Statement statement;
    ResultSet resultSet;

    public void insertmenu(String hari, String terdeteksi, String sembuh, String meninggal){
        try{
            String query = "INSERT INTO korban (hari,terdeteksi,sembuh,meninggal)VALUES"
                    +"('"+hari+"','"+terdeteksi+"','"+sembuh+"','"+meninggal+"')";

            statement = database.getConnection().createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil Ditambahkan");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
        }
    }

    public int getCount(){
        int count = 0;
        try{
            String query = "SELECT count(*) as count from korban";
            Statement statement = database.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);

            if(result.next()){
                count = result.getInt("count");
            }
        }catch(Exception sql){
            System.out.println(sql.getMessage());
        }
        return count;
    }
    public String[][] getAll(){
        String[][] data = new String[this.getCount()][6];
        try{
            String query = "SELECT * FROM korban";
            statement = database.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);

            int i =0;
            while(result.next()){
                data[i][0]= result.getString("hari");
                data[i][1]= result.getString("terdeteksi");
                data[i][2]= result.getString("sembuh");
                data[i][3]= result.getString("meninggal");
                System.out.println(data[i][0]);
                i++;
            }
        }catch(Exception sql){
            System.out.println(sql.getMessage());
        }
        return data;
    }
}
