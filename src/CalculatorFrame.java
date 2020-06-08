import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CalculatorFrame extends JFrame {
    private JTextField display;

    private double operand1 = 0;
    private double operand2 = 0;
    private String operator = "";

    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 300;

    public CalculatorFrame() {
        display = new JTextField("");
        display.setEditable(false);
        add(display, BorderLayout.NORTH);
        createButtonPanel();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    /**
     * Creates the button panel.
     */
    private void createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        buttonPanel.add(makeDigitButton("7"));
        buttonPanel.add(makeDigitButton("8"));
        buttonPanel.add(makeDigitButton("9"));
        buttonPanel.add(makeOperatorButton("/"));
        buttonPanel.add(makeDigitButton("4"));
        buttonPanel.add(makeDigitButton("5"));
        buttonPanel.add(makeDigitButton("6"));
        buttonPanel.add(makeOperatorButton("*"));
        buttonPanel.add(makeDigitButton("1"));
        buttonPanel.add(makeDigitButton("2"));
        buttonPanel.add(makeDigitButton("3"));
        buttonPanel.add(makeOperatorButton("-"));
        buttonPanel.add(makeDigitButton("0"));
        buttonPanel.add(makeDigitButton("."));
        buttonPanel.add(makeOperatorButton("="));
        buttonPanel.add(makeOperatorButton("+"));

        add(buttonPanel, BorderLayout.CENTER);
    }

    class DigitButtonListener implements ActionListener {
        private String digit;


        public DigitButtonListener(String aDigit) {
            digit = aDigit;
        }

        public void actionPerformed(ActionEvent event) {
            display.setText(display.getText() + digit);
        }
    }

    class OperatorListener implements ActionListener {
        private String op;

        public OperatorListener(String op) {
            this.op = op;
        }

        public void actionPerformed(ActionEvent event) {
            operand1 = Double.parseDouble(display.getText());
            operator = op;
            display.setText("");
        }
    }

    class EqualListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            operand2 = Double.parseDouble(display.getText());
            double ans = 0;
            if (operator.equals("+")) {
                ans = operand1 + operand2;
            }
            else if (operator.equals("-")) {
                ans = operand1 - operand2;
            }
            else if (operator.equals("/")) {
                ans = operand1 / operand2;
            }
            else if (operator.equals("*")) {
                ans = operand1 * operand2;
            }
            display.setText("" + ans);
        }
    }


    public JButton makeDigitButton(String digit) {
        JButton button = new JButton(digit);

        ActionListener listener = new DigitButtonListener(digit);
        button.addActionListener(listener);
        return button;
    }


    public JButton makeOperatorButton(String op) {
        JButton button = new JButton(op);
        if (op.equals("=")) {
            button.addActionListener(new EqualListener());
        }
        else {
            button.addActionListener(new OperatorListener(op));
        }
        return button;
    }
}
