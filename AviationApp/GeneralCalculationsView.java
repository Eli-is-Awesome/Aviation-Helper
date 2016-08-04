package AviationApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GeneralCalculationsView extends JPanel implements ActionListener
{
   private JButton bFTM;
   private JButton bMTF;
   private JLabel lblFeet;
   private JLabel lblMeters;
   private JTextField tfMeters;
   private JTextField tfFeet;
   public Font font;
   
   public GeneralCalculationsView()
   {
      setLayout( new GridLayout( 5, 2, 5, 9 ) ); // layout of buttons ( rows, columns, padding, padding )
      
      //create JButtons and JLabel
      bFTM = new JButton( "Feet to Meters" );
      bMTF = new JButton( "Meters to Feet" );
      lblFeet = new JLabel( "Feet: " );
      lblMeters = new JLabel( "Meters: " );
      tfMeters = new JTextField( "" );
      tfFeet = new JTextField ( "" );
      font = new Font( "Times New Roman", Font.BOLD, 16 );
      
      
      // add the controls to the contentPane
      lblFeet.setFont( font );
      add( lblFeet );
      add( tfFeet );
      lblMeters.setFont( font );
      add( lblMeters );
      add( tfMeters );
      add( bFTM );
      add( bMTF );
      
      // connect the buttons to the listener
      bFTM.addActionListener( this );
      bMTF.addActionListener( this );
      
      setBackground( Color.WHITE );
      setVisible( true );
   } // end of constructor
   
   public void actionPerformed( ActionEvent ae )
   {
      if( ae.getSource() == bFTM )
      {
         try
         {
            float f = Float.parseFloat( tfFeet.getText() ); 
            float feetToMeters = AviationMath.feetToMeters( f );
            tfMeters.setText( Float.toString( feetToMeters ) );
         }
         catch( NumberFormatException nfe )
         {
            tfMeters.setText( tfFeet.getText() + " is not a number" );
         }
      }
      else
      {
         if( ae.getSource() == bMTF )
         {
            try
            {
               float m = Float.parseFloat( tfMeters.getText() );
               float metersToFeet = AviationMath.metersToFeet( m );
               tfFeet.setText( Float.toString( metersToFeet ) );
            }
            catch( NumberFormatException nfe )
            {
               tfFeet.setText( tfMeters.getText() + " is not a number" );
            } 
         }
      }
   }
}