package view;

import javax.swing.*;
import java.awt.*;

public class ErrorView extends JFrame {
    public ErrorView(String message){
        JLabel errorLabel=new JLabel(message,new ImageIcon("src/main/java/utils/icons/errorIcon.png"),JLabel.CENTER);
        errorLabel.setVerticalTextPosition(JLabel.BOTTOM);
        errorLabel.setHorizontalTextPosition(JLabel.CENTER);
        errorLabel.setFont(new Font("OpenSans",Font.BOLD,16));
        this.add(errorLabel);
        this.setTitle("Error!");
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}