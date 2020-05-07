package responsi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
public class LoginController {
    LoginModel lm;
    LoginView lv;

    public LoginController(LoginModel lm, LoginView lv) {
        this.lm = lm;
        this.lv = lv;

        String data[][] = lm.getAll();
        int jumlah = lm.getCount();

        lv.submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String negara = lv.Tnegara.getText();

                if(lm.masuk(negara)){
                    JOptionPane.showMessageDialog(null, "ANDA BERHASIL MASUK !!!");
                    MVCInput mvcm = new MVCInput();
                }
                else{
                    JOptionPane.showMessageDialog(null, "TIDAK TERDAFTAR!!");
                    lv.Tnegara.setText(null);
                }
            }
        });

        lv.register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String negara = lv.Tnegara.getText();
                lm.input(negara);
                lv.Tnegara.setText(null);
            }
        });
    }

}
