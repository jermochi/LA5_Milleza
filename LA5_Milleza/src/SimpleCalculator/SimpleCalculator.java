package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {
    private JPanel pMain;
    private JButton btnCompute;
    private JTextField tfNumber2;
    private JTextField tfNumber1;
    private JComboBox cbOperations;
    private JTextField resf;
    SimpleCalculator(){
        char[] ops = {'+','-','*','/'};
        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int a = 0, b= 0, result = 0;
                try{
                    a = Integer.parseInt(tfNumber1.getText());
                    b = Integer.parseInt(tfNumber2.getText());
                }catch(NumberFormatException x) {
                    JOptionPane.showMessageDialog(null,"Enter a valid number");
                }
                if(cbOperations.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null,"Choose an operation");
                }else if(cbOperations.getSelectedIndex() == 1){
                    result = a + b;
                }else if(cbOperations.getSelectedIndex() == 2){
                    result = a - b;
                }else if(cbOperations.getSelectedIndex() == 3){
                    result = a * b;
                }else{
                    try{
                        result = a / b;
                    }catch(ArithmeticException x) {
                        JOptionPane.showMessageDialog(null, "Cannot divide by zero");
                    }
                }
                resf.setText(String.valueOf(result));
            }
        });
    }
    public static void main(String[] args) {
        SimpleCalculator fr = new SimpleCalculator();
        fr.setContentPane(fr.pMain);
        fr.setTitle("Simple Calculator");
        fr.setSize(600,150);
        fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}
