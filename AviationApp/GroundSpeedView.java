package AviationApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GroundSpeedView extends JPanel implements ActionListener
{
   private JButton bCalculate; // button to do calculation
   private JButton bReset; // button to reset form
   private JLabel lblGroundSpeed; // output for calculation
   private JLabel lblWindDir;
   private JLabel lblDesiredCourse;
   private JLabel lblWindSpeed;
   private JLabel lblAirSpeed;
   private JLabel lblGS;
   private JTextField tfWindDir; // wind direction
   private JTextField tfDesiredCourse; // desired course
   private JTextField tfWindSpeed; // wind speed
   private JTextField tfAirSpeed; // air speed
   public Font font;
   
   public GroundSpeedView()
   {
      setLayout( new GridLayout( 7, 2, 5, 9 ) ); // layout of buttons ( rows, columns, padding x, padding y )
      
      //create JButtons and JLabel
      bCalculate = new JButton( "Calculate" );
      bReset = new JButton( "Reset" );
      lblGroundSpeed = new JLabel( "0" );
      lblWindDir = new JLabel( "Wind Direction: " );
      lblDesiredCourse = new JLabel( "Desired Course: " );
      lblWindSpeed = new JLabel( "Wind Speed: " );
      lblAirSpeed = new JLabel( "Airspeed: " );
      lblGS = new JLabel( "Ground Speed: " );
      tfWindDir = new JTextField ( "" );
      tfDesiredCourse = new JTextField ( "" );
      tfWindSpeed = new JTextField( "" );
      tfAirSpeed = new JTextField( "" );
      font = new Font( "Times New Roman", Font.BOLD, 16 );
      
      // add the controls to the contentPane
      lblWindDir.setFont( font );
      add( lblWindDir );
      add( tfWindDir );
      lblDesiredCourse.setFont( font );
      add( lblDesiredCourse );
      add( tfDesiredCourse );
      lblWindSpeed.setFont( font );
      add( lblWindSpeed );
      add( tfWindSpeed );
      lblAirSpeed.setFont( font );
      add( lblAirSpeed );
      add( tfAirSpeed );
      lblGS.setFont( font );
      add( lblGS );
      lblGroundSpeed.setFont( font );
      add( lblGroundSpeed );
      add( bCalculate );
      add( bReset );
      
      // connect the buttons to the listener
      bCalculate.addActionListener( this );
      bReset.addActionListener( this );
      
      setBackground( Color.GREEN );
      setVisible( true );
   } // end contrsuctor
   
   public void actionPerformed( ActionEvent ae )
   {
      if( ae.getSource() == bCalculate )
      {
         double wd = Double.parseDouble( tfWindDir.getText() ); // convert string to double
         double dc = Double.parseDouble( tfDesiredCourse.getText() ); // convert string to double
         double ws = Double.parseDouble( tfWindSpeed.getText() );
         double as = Double.parseDouble( tfAirSpeed.getText() );
         double groundSpeed = AviationMath.groundSpeedCalc( wd, dc, ws, as ); // call Ground Speed Method
         lblGroundSpeed.setText( Double.toString( groundSpeed ) ); // convert double back to string and display in label
      }
      else
      {
         if( ae.getSource() == bReset )
         {
            lblGroundSpeed.setText( "0" );
            tfWindDir.setText( "" );
            tfDesiredCourse.setText( "" );
            tfWindSpeed.setText( "" );
            tfAirSpeed.setText( "" );
         }
      }
   }
}