import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class BmiCalculator {

    private JPanel MainPanel;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JCheckBox Male;
    private JCheckBox femaleCheckBox;
    private JSlider HeightSlider;
    private JCheckBox largeCheckBox;
    private JCheckBox mediumCheckBox;
    private JCheckBox smallCheckBox;
    private JTextField weightTextField;
    private JButton submitButton;
    private JButton clearButton;
    private JLabel LastName;
    private JTextField AgeTextField;
    private int   weight;
    private int age;
    private int height;
    private String weightText;
    private String ageText;
    private double bodyFrameSlimness;

    public BmiCalculator() {

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double bmi=weight/(Math.pow(height,2));
                double idealWeight= (height-100+(age/10))*0.9*bodyFrameSlimness;
                JOptionPane.showMessageDialog(null,"Your BMI is : "+bmi + "\nYour ideal weight is: "+ idealWeight);
                System.out.println(weightText+"\n"+height+"\n"+ageText);
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
        AgeTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ageText= AgeTextField.getText();

            }
        });
        weightTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                weightText=weightTextField.getText();
                weight=Integer.parseInt(weightText);
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
