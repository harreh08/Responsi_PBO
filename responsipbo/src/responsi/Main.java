package responsi;

public class Main {

    public static void main(String[] args) {
        LoginView lv = new LoginView();
        LoginModel lm = new LoginModel();
        LoginController lc = new LoginController(lm, lv);

    }
}
