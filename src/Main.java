import javax.swing.JFrame;

public class Main
{  
   public static void main(String[] args)
   {  
      JFrame frame = new CalculatorFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Calculator");
      frame.setVisible(true);
   }
}
