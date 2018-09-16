/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingcaculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PhuongHeo
 */
public class SwingCaculator extends JFrame implements ActionListener{

    /**
     * @param args the command line arguments
     */
    private JTextField tfFirst,tfSecond,tfResult;
    private JButton btnNhan,btnTram,btnTru,btnCan,btnXoa;
    private float first =0,second =0,result =0;
    
    public SwingCaculator()
    {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(6,2,10,4));
        
        cp.add(new JLabel("Frist Number"));
        tfFirst = new JTextField(first + "",8);
        tfFirst.setHorizontalAlignment(JTextField.RIGHT);
        cp.add(tfFirst);
        
        cp.add(new JLabel("Second Number"));
        tfSecond = new JTextField(second + "",8);
        tfSecond.setHorizontalAlignment(JTextField.RIGHT);
        cp.add(tfSecond);
        
        cp.add(new JLabel("Result"));
        tfResult = new JTextField(result + "",8);
        tfResult.setEditable(false);
        tfResult.setHorizontalAlignment(JTextField.RIGHT);
        cp.add(tfResult);
        
        btnNhan = new JButton("*");
        btnNhan.addActionListener(this);
        cp.add(btnNhan);
        
        btnTru = new JButton("-");
        btnTru.addActionListener(this);
        cp.add(btnTru);
        
        btnTram = new JButton("%");
        btnTram.addActionListener(this);
        cp.add(btnTram);
        
        btnCan = new JButton("sqrt");
        btnCan.addActionListener(this);
        cp.add(btnCan);
        
        btnXoa = new JButton("CLEAR");
        btnXoa.addActionListener(this);
        cp.add(btnXoa);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setTitle("Simple Caculator");
                
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
               new SwingCaculator();
            }
        });
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       String btnLabel = ae.getActionCommand();    
        try {
            first = Float.parseFloat(tfFirst.getText());
            second = Float.parseFloat(tfSecond.getText());
            
            switch (btnLabel) {
                case "*":
                    result = first * second;
                    tfResult.setText("" + result);
                    break;
                case "-":
                    result = first - second;
                    tfResult.setText("" + result);
                    break;
                case "sqrt":
                    result = (float) Math.sqrt(first);
                    //result = (float) Math.sqrt(second);
                    tfResult.setText("" + result);
                    break;
                case "/":
                    result = first / second;
                    tfResult.setText("" + result);
                    break;
                case "%":
                    result = first % second;
                    tfResult.setText("" + result);
                    break;
                case "CLEAR":
                    throw new NumberFormatException();
            }
        } catch (NumberFormatException nfe) {
            tfFirst.setText("0");
            tfSecond.setText("0");
            tfResult.setText("0");
        }
    }
    
}
