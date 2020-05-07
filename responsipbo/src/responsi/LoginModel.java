package responsi;
import java.sql.*;
import javax.swing.JOptionPane;
public class LoginModel {
    private String negara;

    public String getUsername() {
        return negara;
    }

    public void setUsername(String negara) {
        this.negara = negara;
    }


    public boolean masuk(String negara)
    {
        try
        {
            String query = "SELECT * FROM pandemi WHERE negara = '"+negara+"'";
            Statement statement = database.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            if(result.next())
            {
                System.out.println("Berhasil Masuk !!!");
                return true;
            }
        }catch(Exception sql){
            System.out.println(sql.getMessage());
        }

        return false;
    }
    public int getCount(){
        int count = 0;
        try{
            String query = "SELECT count(*) as count from pandemi";
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
        String[][] data = new String[this.getCount()][2];
        try{
            String query = "SELECT * FROM pandemi";
            Statement statement = database.getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);

            int i =0;
            while(result.next()){
                data[i][0]= result.getString("negara");
                i++;
            }
        }catch(Exception sql){
            System.out.println(sql.getMessage());
        }
        return data;
    }

    public void input(String negara)
    {
        try
        {
            String query = "INSERT INTO pandemi (negara) VALUES "+" ('"+negara+"')";
            Statement statement = database.getConnection().createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil Ditambahkan");
            JOptionPane.showMessageDialog(null, "Berhasil Di daftarkan");
        }catch(Exception sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, "Username telah terdaftar");
        }
    }
}
