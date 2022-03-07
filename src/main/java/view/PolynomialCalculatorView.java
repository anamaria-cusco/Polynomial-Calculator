package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PolynomialCalculatorView extends JFrame {


    private JTextField polynomial1TextField;
    private JTextField polynomial2TextField;
    private final JTextField resultTextField;
    private final JButton additionBtn;
    private final JButton subtractionBtn;
    private final JButton multiplicationBtn;
    private final JButton divisionBtn;
    private final JButton integrationBtn;
    private final JButton derivativeBtn;
    private final JButton resetBtn;



    public PolynomialCalculatorView(){
         JPanel contentPanel=new JPanel();
         JPanel resetPanel;
         JPanel polinomyalsPanel;
         JPanel operationsPanel;
         JLabel polynomial1Label;
         JLabel resultLabel;
         JLabel operationLabel;
         JLabel polynomial2Label;

        contentPanel.setLayout(new BorderLayout());

        polinomyalsPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        polinomyalsPanel.setSize(600,300);
        polinomyalsPanel.setBackground(new Color(174,130,170));
        polynomial1Label=new JLabel("Polinomul 1:");
        polynomial1Label.setFont(new Font("OpenSans",Font.BOLD,20));
        polynomial1Label.setLabelFor(polynomial1TextField);
        polynomial1TextField=new JTextField(35);
        polynomial2Label=new JLabel("Polinomul 2:");
        polynomial2Label.setFont(new Font("OpenSans",Font.BOLD,20));
        polynomial2Label.setLabelFor(polynomial2TextField);
        polynomial2TextField=new JTextField(35);
        resultLabel=new JLabel("Rezultat:");
        resultLabel.setFont(new Font("OpenSans",Font.BOLD,20));
        resultTextField=new JTextField(50);


        resetPanel=new JPanel();
        resetPanel.setBackground(Color.GRAY);
        resetBtn=new JButton("Reset");
        resetBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        resetBtn.setFont(new Font("OpenSans",Font.BOLD,20));
        resetPanel.add(resetBtn);



        polinomyalsPanel.add(polynomial1Label);
        polinomyalsPanel.add(polynomial1TextField);
        polinomyalsPanel.add(polynomial2Label);
        polinomyalsPanel.add(polynomial2TextField);
        polinomyalsPanel.add(resultLabel);
        polinomyalsPanel.add(resultTextField);



        contentPanel.add(resetPanel,BorderLayout.NORTH);
        contentPanel.add(polinomyalsPanel,BorderLayout.CENTER);

        operationsPanel=new JPanel(new GridLayout(2,3));
        operationLabel=new JLabel("Alegeti operatia:");
        operationLabel.setFont(new Font("OpenSans",Font.BOLD,20));


        additionBtn=new JButton(new ImageIcon("src/main/java/utils/icons/additionIcon.png"));
        subtractionBtn=new JButton(new ImageIcon("src/main/java/utils/icons/subtractionIcon.png"));
        multiplicationBtn=new JButton(new ImageIcon("src/main/java/utils/icons/multiplicationIcon.png"));
        divisionBtn=new JButton(new ImageIcon("src/main/java/utils/icons/divisionIcon.png"));
        integrationBtn=new JButton(new ImageIcon("src/main/java/utils/icons/integrationIcon.png"));
        derivativeBtn=new JButton(new ImageIcon("src/main/java/utils/icons/derivativeIcon.png"));

        polinomyalsPanel.add(operationLabel);
        operationsPanel.add(additionBtn);
        operationsPanel.add(subtractionBtn);
        operationsPanel.add(multiplicationBtn);
        operationsPanel.add(divisionBtn);
        operationsPanel.add(integrationBtn);
        operationsPanel.add(derivativeBtn);

       contentPanel.add(operationsPanel,BorderLayout.SOUTH);


        this.setTitle("Polynomial Calculator");
        this.setContentPane(contentPanel);
        this.setSize(620,500);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }



    public void addResetListener(ActionListener a){
        resetBtn.addActionListener(a);
    }
    public void addAdditionListener(ActionListener a){
        additionBtn.addActionListener(a);
    }
    public void addSubtractionListener(ActionListener a){
        subtractionBtn.addActionListener(a);
    }
    public void addMultiplicationListener(ActionListener a){
        multiplicationBtn.addActionListener(a);
    }
    public void addDivisionListener(ActionListener a){
        divisionBtn.addActionListener(a);
    }
    public void addIntegrationListener(ActionListener a){
        integrationBtn.addActionListener(a);
    }
    public void addDerivativeListener(ActionListener a){
        derivativeBtn.addActionListener(a);
    }

    public JTextField getPolynomial1TextField() {
        return polynomial1TextField;
    }


    public String getPolynomial1(){
        return  polynomial1TextField.getText();
    }

    public JTextField getPolynomial2TextField() {
        return polynomial2TextField;
    }

    public String getPolynomial2(){
        return  polynomial2TextField.getText();
    }

    public JTextField getResultTextField() {
        return resultTextField;
    }




}
