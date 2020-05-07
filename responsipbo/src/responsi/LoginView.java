package responsi;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class LoginView extends JFrame{
    JLabel Lnegara = new JLabel("Negara     : ");
    JTextField Tnegara = new JTextField();
    JButton submit, register;

    public LoginView(){
        setTitle("COVID-19");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600,400);

        submit = new JButton ("MASUK");
        register = new JButton("REGISTER");
        add(Lnegara);
        Lnegara.setBounds(160, 120, 90, 20);
        add(Tnegara);
        Tnegara.setBounds(260, 120, 120, 20);
        add(submit);
        submit.setBounds(160,230, 100, 30);
        add(register);
        register.setBounds(280,230,100,30);
    }

    public String getUsername()
    {
        return Tnegara.getText();
    }



}
