package responsi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
public class UpdateController {
    UpdateModel updateModel;
    UpdateView updateView;

    public UpdateController(UpdateModel updateModel, UpdateView updateView) {
        this.updateModel = updateModel;
        this.updateView = updateView;
        updateView.Cari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(updateView.TFhari.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Hari tersebut tidak ada !");
                }
                else{
                    String hariCari = updateView.TFhari.getText();
                    viewTableUpdate(hariCari);
                    updateView.Edit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            String terdeteksi = updateView.TFterdeteksi.getText();
                            String sembuh = updateView.TFsembuh.getText();
                            String meninggal = updateView.TFmeninggal.getText();
                            updateModel.updateMenu(hariCari,terdeteksi,sembuh,meninggal);
                            viewTableUpdate(hariCari);
                            updateView.TFterdeteksi.setText("");
                            updateView.TFsembuh.setText("");
                            updateView.TFmeninggal.setText("");
                        }
                    });

                }
            }
        });



    }

    private void viewTableUpdate(String hariCari){
        String dataAltul[][] = updateModel.cariData(hariCari);
        updateView.table.setModel((new JTable(dataAltul, updateView.column)).getModel());
    }
}