package responsi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
public class UpdateView extends JFrame {
    JLabel Lhari = new JLabel("Hari : ");
    JLabel Lterdeteksi= new JLabel("Terdeteksi : ");
    JTextField TFterdeteksi= new JTextField();
    JButton Cari = new JButton("Cari terdeteksi");
    JButton Kembali = new JButton("Kembali");
    JLabel Lsembuh = new JLabel("sembuh : ");
    JLabel Lmeninggal = new JLabel("meninggal : ");
    JTextField TFhari = new JTextField();
    JTextField TFsembuh = new JTextField();
    JTextField TFmeninggal = new JTextField();


    JButton Edit = new JButton("Edit");

    JScrollPane panel;
    JTable table;
    DefaultTableModel tableModel;
    String column[] = {"hari","terdeteksi","sembuh","meninggal"};

    public UpdateView(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600, 500);

        tableModel = new DefaultTableModel(column,10);
        table = new JTable(tableModel);
        panel = new JScrollPane(table);
        panel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        add(Lhari);
        Lhari.setBounds(20,5,90,20);
        add(TFhari);
        TFhari.setBounds(110,5,120,20);
        add(Cari);
        Cari.setBounds(113, 30, 110, 20);
        add(panel);
        panel.setBounds(20, 70, 480, 60);
        add(Lterdeteksi);
        Lterdeteksi.setBounds(20, 170, 90, 20);
        add(TFterdeteksi);
        TFterdeteksi.setBounds(110, 170, 120, 20);
        add(Lsembuh);
        Lsembuh.setBounds(20, 195, 90, 20);
        add(TFsembuh);
        TFsembuh.setBounds(110, 195, 120, 20);
        add(Lmeninggal);
        Lmeninggal.setBounds(20, 225, 90, 20);
        add(TFmeninggal);
        TFmeninggal.setBounds(110, 225, 120, 20);
        add(Edit);
        Edit.setBounds(80, 260, 90, 20);
        add(Kembali);
        Kembali.setBounds(205, 260, 90, 20);

        Kembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                MVCInput mvi = new MVCInput();
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
    public String getHari_cari(){
        return TFhari.getText();
    }
}