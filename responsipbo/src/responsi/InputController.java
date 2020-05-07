package responsi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
public class InputController {
    InputModel inputModel;
    InputView  inputView;

    public InputController(InputModel inputModel, InputView inputView) {
        this.inputModel = inputModel;
        this.inputView = inputView;

        String data[][] = inputModel.getAll();
        inputView.table.setModel((new JTable(data,inputView.column)).getModel());

        inputView.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                super.mousePressed(e);

                int row = inputView.table.getSelectedRow();
                int col = inputView.table.getSelectedColumn();
                String idbarang = inputView.table.getValueAt(row, 0).toString();
                System.out.println(idbarang);
            }

        });

        inputView.Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hari = inputView.TFhari.getText();
                String terdeteksi = inputView.getTerdeteksi();
                String sembuh = inputView.getSembuh();
                String meninggal = inputView.getMeninggal();
                inputModel.insertmenu(hari,terdeteksi,sembuh,meninggal);
                String data[][]= inputModel.getAll();
                inputView.table.setModel((new JTable(data,inputView.column)).getModel());
            }
        });



    }
}
