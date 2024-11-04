package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeapYearChecker extends JFrame {
    private JPanel pMain;
    private JButton checkYearButton;
    private JTextField yearTextField;

    LeapYearChecker(){
        checkYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int yr = 0;
                if(yearTextField.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter a year");
                    return;
                }
                try{
                     yr = Integer.parseInt(yearTextField.getText());
                }catch(NumberFormatException x) {
                    JOptionPane.showMessageDialog(null,"Enter a valid year");
                }
                if((yr % 4 == 0 && yr % 100 !=0) || yr %400 == 0){
                    JOptionPane.showMessageDialog(null,"Leap Year");
                }else{
                    JOptionPane.showMessageDialog(null,"Not a Leap Year");
                }
            }
        });
    }
    public static void main(String[] args) {
        LeapYearChecker fr = new LeapYearChecker();
        fr.setContentPane(fr.pMain);
        fr.setTitle("Leap Year Checker");
        fr.setSize(300,150);
        fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}
