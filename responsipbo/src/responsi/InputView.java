package responsi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
//import sun.security.x509.CertificateSubjectName;
public class InputView extends JFrame{
    JLabel LjuduLatas = new JLabel("BERITA TERKINI COVID-19");
    JLabel LjuduLatas1 = new JLabel("TAMBAH DATA PENYEBARAN");
    JLabel Lhari = new JLabel("Hari : ");
    JLabel Lterdeteksi= new JLabel("Terdeteksi : ");
    JLabel Lsembuh = new JLabel("Sembuh :");
    JLabel lmeninggal = new JLabel("Meninggal :");

    JTextField TFhari = new JTextField();
    JTextField TFterdeteksi= new JTextField();
    JTextField TFsembuh = new JTextField();
    JTextField TFmeninggal = new JTextField();
    JButton Submit = new JButton("Input");
    JButton Edit = new JButton("Edit");

    JScrollPane panel;
    JTable table;
    DefaultTableModel tableModel;
    String column[] = {"hari","terdeteksi","sembuh","meninggal"};

    public InputView(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(550, 500);

        tableModel = new DefaultTableModel(column,0);
        table = new JTable(tableModel);
        panel = new JScrollPane(table);
        panel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(LjuduLatas);
        LjuduLatas.setBounds(144, 5, 280, 20);
        add(LjuduLatas1);
        LjuduLatas1.setBounds(144, 30, 280, 20);
        add(Lhari);
        Lhari.setBounds(140,55,90,20);
        add(TFhari);
        TFhari.setBounds(250,55,120,20);
        add(Lterdeteksi);
        Lterdeteksi.setBounds(140,80,90,20);
        add(TFterdeteksi);
        TFterdeteksi.setBounds(250,80,120,20);
        add(Lsembuh);
        Lsembuh.setBounds(140, 105, 90, 20);
        add(TFsembuh);
        TFsembuh.setBounds(250, 105, 120, 20);
        add(lmeninggal);
        lmeninggal.setBounds(140, 130, 90, 20);
        add(TFmeninggal);
        TFmeninggal.setBounds(250, 130, 120, 20);
        add(Submit);
        Submit.setBounds(90, 200, 90, 20);
        add(Edit);
        Edit.setBounds(330, 200, 90, 20);
        add(panel);
        panel.setBounds(20, 250, 480, 300);


        Edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MVCUpdate mvcu = new MVCUpdate();
                dispose();
            }
        });
    }

    public String getTerdeteksi(){
        return TFterdeteksi.getText();
    }
    public String getSembuh(){
        return TFsembuh.getText();
    }
    public String getMeninggal(){
        return TFmeninggal.getText();
    }
    public String getHari()
    {
        return TFhari.getText();
    }
}
