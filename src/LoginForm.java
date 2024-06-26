import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginForm extends JFrame{
    private JPanel mainPanel;
    private JTextField textFieldUN;
    private JPasswordField passwordFieldPW;
    private JButton registerButton;
    private JButton loginButton;
    static List<Person> personList;
    private Person currentUser;


    public LoginForm() {
        setContentPane(mainPanel);
        setSize(400,400);
        setVisible(true);
        setTitle("Bank Login");
        personList = new ArrayList<>();
        personList.add(new Person(32454,"marcpogz","admane127","marcpogz@gmail.com","Marc","Pogz","D","0909090909"));
        personList.add(new Person(545545,"janedoe","doejane21","janedoe@gmail.com","Jane","Doe","Guo","093030303030"));

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String un = textFieldUN.getText();
                    String pw = passwordFieldPW.getText();
                    System.out.println(pw);
                    currentUser = Person.getPerson(personList,un,pw);
                    if(currentUser==null){
                        throw new RuntimeException("invalid");
                    }
                    System.out.println(currentUser);
                }
                catch (RuntimeException ru){
                    textFieldUN.setText("");
                    passwordFieldPW.setText("");
                    loginButton.setBackground(Color.red);
                    MessageBox dialog = new MessageBox("invalid username or password");
                    dialog.pack();
                    dialog.setVisible(true);

                }
            }
        });
    }


    public static void main(String[] args) {
       LoginForm lf = new LoginForm();

    }
}

