package responsi;
import java.sql.*;
public class UpdateModel {
    private String hari_cari;
    private String terdeteksi;
    private String sembuh;
    private String meninggal;

    public String getHari_cari() {
        return hari_cari;
    }

    public void setHari_cari(String hari_cari) {
        this.hari_cari = hari_cari;
    }


    public String getTerdeteksi() {
        return terdeteksi;
    }

    public void setTerdeteksi(String terdeteksi) {
        this.terdeteksi = terdeteksi;
    }

    public String getSembuh() {
        return sembuh;
    }

    public void setSembuh(String sembuh) {
        this.sembuh = sembuh;
    }

    public String getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(String meninggal) {
        this.meninggal = meninggal;
    }


    Statement statement;
    ResultSet resultSet;
    Connection koneksi;

    public void updateMenu(String hari, String terdeteksi, String sembuh, String meninggal){
        try{
            String query = "UPDATE korban SET terdeteksi ='"+terdeteksi+"', sembuh ='"+sembuh+"', meninggal ='"+meninggal+"'  WHERE `hari`='"+hari+"'";
            statement = database.getConnection().createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil di Edit");
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
            Statement statement = database.getConnection().createStatement();
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

    public int getCariAltul(String hariCari){
        try{
            int banyakdata = 0;
            statement = database.getConnection().createStatement();
            String query = "SELECT * FROM `korban` WHERE `hari`='"+hariCari+"'";
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                banyakdata++;
            }
            return banyakdata;
        } catch(SQLException ex){
            System.out.println("DATA TIDAK ADA");
            ex.printStackTrace();
        } finally {
            if (statement != null) {

            }
        }
        return 0;
    }

    public String[][] cariData(String searchHari){
        int indexbaris = 0;
        String viewCari[][] = new String[getCariAltul(searchHari)][6];
        try{
            statement = database.getConnection().createStatement();
            String cquery = "SELECT * FROM `korban` WHERE `hari`='"+searchHari+"'";
            resultSet = statement.executeQuery(cquery);

            while (resultSet.next()) {
                viewCari[indexbaris][0] = resultSet.getString("hari");
                viewCari[indexbaris][1] = resultSet.getString("terdeteksi");
                viewCari[indexbaris][2] = resultSet.getString("sembuh");
                viewCari[indexbaris][3] = resultSet.getString("meninggal");
            }
            return viewCari;
        }catch(SQLException e){
            System.out.println("CARI TIDAK DIDAPATKAN");
            e.printStackTrace();
        }
        return null;
    }
}
