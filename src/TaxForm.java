import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaxForm extends JFrame {
    private JPanel MainPanel;
    private JTextField inputIncome;
    private JButton calculateButton;
    private JLabel netIncome_text;
    private JTextField inputDeduction;
    private JTextField inputTaxrate;
    TaxForm(){
        setContentPane(MainPanel);
        setVisible(true);
        setSize(400,400);
        netIncome_text.setForeground(Color.red);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TaxCalc taxCalc;
                try {
                    taxCalc = new TaxCalc(Double.parseDouble(inputIncome.getText()), Double.parseDouble(inputDeduction.getText()), Double.parseDouble(inputTaxrate.getText()));
                    netIncome_text.setText(String.valueOf(taxCalc.getNetIncome()));
                }
                catch (RuntimeException re){
                    System.out.println("Invalid input");
                }
                finally {
                    taxCalc = null;
                    System.out.println("taxCalc garbage");
                }


            }
        });
    }

    public static void main(String[] args) {
        new TaxForm();
    }
}
