package AviationApp;

// Demonstrating JTabbedPane.
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class AviationCalculator extends JFrame
{
   public static void main( String args[] )
   {
      JTabbedPaneFrame tabbedPaneFrame = new JTabbedPaneFrame();
      tabbedPaneFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      tabbedPaneFrame.setSize( 1024, 400 ); // set frame size
      tabbedPaneFrame.setVisible( true ); // display frame
   } // end main
} // end class AviationCalculator