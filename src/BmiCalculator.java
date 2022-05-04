import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class BmiCalculator {

    private JPanel MainPanel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JCheckBox maleCheckBox;
    private JCheckBox femaleCheckBox;
    private JSlider HeightSlider;
    private JCheckBox largeCheckBox;
    private JCheckBox mediumCheckBox;
    private JCheckBox smallCheckBox;
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
    CheckboxGroup cbg = new CheckboxGroup();

    public BmiCalculator() {

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double heightInCm=height*0.01;
                double bmi=weight/(Math.pow(heightInCm,2));
                double idealWeight= (height-100+(age/10))*0.9*bodyFrameSlimness;
                JOptionPane.showMessageDialog(null,"Your BMI is : "+bmi + "\nYour ideal weight is: "+ idealWeight);


            }
        });


        HeightSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                height= HeightSlider.getValue();
            }
        });

        largeCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                bodyFrameSlimness=1.1;
            }
        });
        mediumCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                bodyFrameSlimness=1;
            }
        });
        smallCheckBox.addItemListener(new ItemListener() {
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

                femaleCheckBox.setSelected(false);
                maleCheckBox.setSelected(false);

                HeightSlider.setValue(140);

                largeCheckBox.setSelected(false);
                mediumCheckBox.setSelected(false);
                smallCheckBox.setSelected(false);

            }
        });
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
