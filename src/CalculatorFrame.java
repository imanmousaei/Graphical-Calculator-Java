import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CalculatorFrame extends JFrame
{  
   private JTextField display;

   private static final int FRAME_WIDTH = 300;
   private static final int FRAME_HEIGHT = 300;

   public CalculatorFrame()
   {
      display = new JTextField("");
      display.setEditable(false);           
      add(display, BorderLayout.NORTH);
      createButtonPanel();
      setSize(FRAME_WIDTH, FRAME_HEIGHT);
   }
      
   /**
      Creates the button panel.
   */
   private void createButtonPanel()
   {      
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
   
   class DigitButtonListener implements ActionListener
   {
      private String digit;
      

      public DigitButtonListener(String aDigit)
      {
         digit = aDigit;
      }
      
      public void actionPerformed(ActionEvent event)
      {  
         display.setText(display.getText() + digit);
      }        
   }


   public JButton makeDigitButton(String digit)
   {
      JButton button = new JButton(digit);
      
      ActionListener listener = new DigitButtonListener(digit);
      button.addActionListener(listener);  
      return button;    
   } 


   public JButton makeOperatorButton(String op)
   {
      JButton button = new JButton(op);
      return button;    
   }     
}
