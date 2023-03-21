import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument.BranchElement;

class Calculator implements ActionListener{
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons=new JButton[10];
    JButton[] functionButtons=new JButton[9];
    JButton addButton,subButton,mulButton,divButton;

    JButton decButton,equButton,clrButton,delButton,negButton;
    JPanel panel;

    Font myFont =new Font("Ink Free",Font.BOLD,30);
    
    double n=0,m=0,result=0; 
    char operator;

    Calculator(){
        frame=new JFrame("Calculator"); //Title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,500);
        frame.setLayout(null);

        textField=new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        clrButton=new JButton("AC");
        delButton=new JButton("Del");
        equButton=new JButton("=");
        negButton=new JButton("(-)");

        functionButtons[0]=addButton;
        functionButtons[1]=subButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=equButton;
        functionButtons[5]=clrButton;
        functionButtons[6]=delButton;
        functionButtons[7]=decButton;
        functionButtons[8]=negButton;
        
        for(int i=0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for(int i=0;i<10;i++){
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel =new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(divButton); 
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);

        panel.setBackground(Color.CYAN);
        frame.setBackground(Color.ORANGE);
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
        
    }
    public static void main(String[] args) {
        Calculator cal=new Calculator();
        
    }
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<10;i++){
            if(e.getSource()==numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addButton){
            n=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }
        if(e.getSource()==subButton){
            n=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
        if(e.getSource()==mulButton){
            n=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if(e.getSource()==divButton){
            n=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if(e.getSource()==equButton){
            m=Double.parseDouble(textField.getText());

            switch(operator){
                case '+':
                    result=n+m;
                    break;
                case '-':
                    result=n-m;
                    break;
                case '*':
                    result=n*m;
                    break;
                case '/':
                    result=n/m;
                    break;    

            }
            textField.setText(String.valueOf(result));
            n=result;

        }
        if(e.getSource()==clrButton){
            textField.setText("");

        }
        if(e.getSource()==delButton)
        {
            String str=textField.getText();
            textField.setText("");
            for(int i=0;i<str.length()-1;i++){
                textField.setText(textField.getText()+str.charAt(i));
            }
            
        }
        if(e.getSource()==negButton)
        {
            double temp=Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
            
        }     
    }
}