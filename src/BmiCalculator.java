import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class BmiCalculator {

    private JPanel MainPanel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JSlider HeightSlider;
    private JRadioButton largeRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton smallRadioButton;
    private JTextField weightTextField;
    private JButton submitButton;
    private JButton clearButton;
    private JLabel LastName;
    private JTextField ageTextField;
    private JPanel weightPanel;
    private JPanel genderPanel;
    private int   weight;
    private double age;
    private int height;
    private String weightText;
    private String ageText;
    private double bodyFrameSlimness;
    ButtonGroup genderGroup;
    ButtonGroup bodyFrameGroup;

    public BmiCalculator()
    {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genderGroup=new ButtonGroup();
                genderGroup.add(maleRadioButton);
                genderGroup.add(femaleRadioButton);

                bodyFrameGroup=new ButtonGroup();
                bodyFrameGroup.add(largeRadioButton);
                bodyFrameGroup.add(mediumRadioButton);
                bodyFrameGroup.add(smallRadioButton);


                double heightInCm=height*0.01;
                double bmi=weight/(Math.pow(heightInCm,2));
                double idealWeight= (height-100+(age/10))*0.9*bodyFrameSlimness;
                JOptionPane.showMessageDialog(null,"Your BMI is : "+bmi+"\nAnd you body status is: "+weightStatus(bmi)+ "\n\nYour ideal weight is: "+ idealWeight+"\nAnd your Actual Weight is: "+weight);

            }
        });


        HeightSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                height= HeightSlider.getValue();
            }
        });

        largeRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                bodyFrameSlimness=1.1;
            }
        });
        mediumRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                bodyFrameSlimness=1;
            }
        });
        smallRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                bodyFrameSlimness=0.9;
            }
        });


        ageTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ageText= ageTextField.getText();
               age =Integer.parseInt(ageText);
            }
        });

        weightTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                weightText=weightTextField.getText();
                weight=Integer.parseInt(weightText);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstNameTextField.setText("");
                lastNameTextField.setText("");
                ageTextField.setText("");
                weightTextField.setText("");

                genderGroup.clearSelection();
                bodyFrameGroup.clearSelection();

                HeightSlider.setValue(140);



            }
        });
    }


    public String weightStatus(double bmi)
    {
        if (bmi<15)
        {
            return "Anorexic ";
        }
        if (bmi>=15 && bmi<=18.5)
        {
            return "Underweight ";
        }
        if (bmi>=18.5 && bmi<=24.9)
        {
            return "Normal ";
        }
        if (bmi>=25 && bmi<=29.9)
        {
            return "Overweight  ";
        }
        if (bmi>=30 && bmi<=35)
        {
            return "Obese  ";
        }
        if (bmi>=35)
        {
            return "Extreme Obese  ";
        }
        return "";
    }

     public static void main(String[] args) {
        JFrame frame =new JFrame("BMI Calculator");
        frame.setContentPane(new BmiCalculator().MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
