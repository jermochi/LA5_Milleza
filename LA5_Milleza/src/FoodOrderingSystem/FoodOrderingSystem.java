package FoodOrderingSystem;

import javax.swing.*;
import java.util.HashMap;

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
        HashMap<JCheckBox, Double> food = new HashMap<>();
        food.put(cbPizza, 100.0);
        food.put(cbBurger, 80.0);
        food.put(cbFries, 65.0);
        food.put(cbSoftDrinks, 55.0);
        food.put(cbTea, 50.0);
        food.put(cbSundae, 40.0);

        HashMap<JRadioButton, Double> discounts = new HashMap<>();
        discounts.put(rbNone, 0.0);
        discounts.put(rb5, 0.05);
        discounts.put(rb10, 0.10);
        discounts.put(rb15, 0.15);

        orderButton.addActionListener(_ -> {
            double total = 0;
            for(JCheckBox btn : food.keySet()){
                if(btn.isSelected()){
                    total += food.get(btn);
                }
            }
            for(JRadioButton btn : discounts.keySet()) {
                if (btn.isSelected()) {
                    total -= total * discounts.get(btn);
                }
            }
            if(total == 0.0){
                JOptionPane.showMessageDialog(null, "Select an item");
            }else{
                JOptionPane.showMessageDialog(null, "Total is: " + String.format("%.2f", total));
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
