package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrderingSystem extends JFrame {
    private JPanel pMain;
    private JRadioButton rbNone;
    private JCheckBox cbPizza;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JCheckBox cbBurger;
    private JCheckBox cbFries;
    private JCheckBox cbSoftDrinks;
    private JCheckBox cbTea;
    private JCheckBox cbSundae;
    private JButton orderButton;

    FoodOrderingSystem(){
        JCheckBox[] food = {cbPizza, cbBurger, cbFries, cbSoftDrinks, cbTea, cbSundae};
        int arr[] = {100,80,65,55,50,40};
        JRadioButton[] discount = {rbNone, rb5, rb10, rb15};
        double disc[] = {0,0.5,0.10,0.15};
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total = 0,ctr = 0;
                for(JCheckBox btn : food){
                    if(btn.isSelected()){
                        total += arr[ctr];
                    }
                    ctr++;
                }
                ctr = 0;
                for(JRadioButton btn : discount) {
                    if (btn.isSelected()) {
                        total = total + (int) (total * (disc[ctr]));
                    }
                }
                JOptionPane.showMessageDialog(null,"Total is: " + total);
            }
        });
    }
    public static void main(String[] args) {
        FoodOrderingSystem fr = new FoodOrderingSystem();
        fr.setContentPane(fr.pMain);
        fr.setTitle("Food Ordering System");
        fr.setSize(400,450);
        fr.setDefaultCloseOperation(EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}
