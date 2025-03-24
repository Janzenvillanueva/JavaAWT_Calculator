/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javaawt_calculatorui;

/**
 *
 * @author chen
 */
import java.awt.*;  
import java.awt.event.*; 

public class JavaAWT_CalculatorUI extends Frame implements ActionListener {   
    private final TextField display;  
    private final Button[] numButtons = new Button[10];  
    private final Button add, sub, mul, div, eq, clr;  
    private double num1, num2, result;  
    private String operator;    

    public JavaAWT_CalculatorUI() {  
        setLayout(new BorderLayout());  
        setTitle("Calculator");
        setSize(300, 300);  
        setVisible(true);  
        setBackground(Color.LIGHT_GRAY);

        display = new TextField();  
        display.setEditable(false); 
        display.setBackground(Color.WHITE);
        display.setForeground(Color.BLACK);
        display.setFont(new Font("Verdana", Font.PLAIN, 24)); 
        add(display, BorderLayout.NORTH);  

        Panel panel = new Panel();  
        panel.setLayout(new GridLayout(4, 4, 5, 5));  
        
        for (int i = 0; i < 10; i++) {  
            numButtons[i] = new Button(String.valueOf(i));  
            numButtons[i].setBackground(Color.PINK);  
            numButtons[i].setForeground(Color.BLACK); 
            numButtons[i].addActionListener(this);  
        }  

        add = new Button("+");  
        sub = new Button("-");  
        mul = new Button("×");  
        div = new Button("÷");  
        eq = new Button("=");  
        clr = new Button("C");  
        
        Button[] operators = {add, sub, mul, div, eq, clr};  
        for (Button operatorButton : operators) {
            operatorButton.setBackground(Color.PINK); 
            operatorButton.setForeground(Color.BLACK); 
            operatorButton.setFont(new Font("Verdana", Font.BOLD, 18));  
            operatorButton.addActionListener(this);
        }
  
        panel.add(numButtons[7]); panel.add(numButtons[8]); panel.add(numButtons[9]); panel.add(div);  
        panel.add(numButtons[4]); panel.add(numButtons[5]); panel.add(numButtons[6]); panel.add(mul);  
        panel.add(numButtons[1]); panel.add(numButtons[2]); panel.add(numButtons[3]); panel.add(sub);  
        panel.add(numButtons[0]); panel.add(clr); panel.add(eq); panel.add(add);  

        add(panel, BorderLayout.CENTER);  

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }  

    public void actionPerformed(ActionEvent e) {  
        String cmd = e.getActionCommand();  

        if (cmd.charAt(0) >= '0' && cmd.charAt(0) <= '9') {  
            display.setText(display.getText() + cmd);  
        } else if (cmd.equals("+") || cmd.equals("-") || cmd.equals("×") || cmd.equals("÷")) {  
            num1 = Double.parseDouble(display.getText());  
            operator = cmd;  
            display.setText("");  
        } else if (cmd.equals("=")) {  
            num2 = Double.parseDouble(display.getText());  

            switch (operator) {  
                case "+": result = num1 + num2; break;  
                case "-": result = num1 - num2; break;  
                case "×": result = num1 * num2; break;  
                case "÷":  
                    if (num2 == 0) {  
                        display.setText("Error!");  
                        return;  
                    }  
                    result = num1 / num2;  
                    break;  
            }  
            display.setText(String.valueOf(result));  
        } else if (cmd.equals("C")) {  
            display.setText("");  
            num1 = num2 = result = 0;  
        }  
    }  

    public static void main(String[] args) {  
        new JavaAWT_CalculatorUI();  
    }  
}  
