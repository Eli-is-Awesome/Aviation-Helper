package AviationApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DensityAltitudeView extends JPanel implements ActionListener
{
   private JButton bCalculate; // button to do calculation
   private JButton bReset; // button to reset form
   private JLabel lblDensAlt; // output for calculation
   private JLabel lblTemp; // label for Temperature
   private JLabel lblPressure; // label for Pressure
   private JLabel lblDensAltLabel; // label for Density Altitude
   private JTextField tfTemp; // temperture
   private JTextField tfPressure; // Pressure
   public Font font;
   
   public DensityAltitudeView()
   {
      setLayout( new GridLayout( 5, 2, 5, 9 ) ); // layout of buttons ( rows, columns, padding x, padding y )
      
      //create JButtons and JLabel
      bCalculate = new JButton( "Calculate" );
      bReset = new JButton( "Reset" );
      lblDensAlt = new JLabel( "0" );
      lblTemp = new JLabel( "Temperature: " );
      lblPressure = new JLabel( "Pressure: " );
      lblDensAltLabel = new JLabel( "Density Altitude: " );
      tfTemp = new JTextField ( "" );
      tfPressure = new JTextField ( "" );
      font = new Font( "Times New Roman", Font.BOLD, 16 );
      
      // add the controls to the contentPane
      lblTemp.setFont( font );
      lblTemp.setForeground( Color.WHITE );
      add( lblTemp );
      add( tfTemp );
      lblPressure.setFont( font );
      lblPressure.setForeground( Color.WHITE );
      add( lblPressure );
      add( tfPressure );
      lblDensAltLabel.setFont( font );
      lblDensAltLabel.setForeground( Color.WHITE );
      add( lblDensAltLabel );
      lblDensAlt.setForeground( Color.GREEN );
      add( lblDensAlt );
      add( bCalculate );
      add( bReset );
      
      // connect the buttons to the listener
      bCalculate.addActionListener( this );
      bReset.addActionListener( this );
      
      setBackground( Color.DARK_GRAY );
      setVisible( true );
   } // end contrsuctor
   
   public void actionPerformed( ActionEvent ae )
   {
      if( ae.getSource() == bCalculate )
      {
         double t = Double.parseDouble( tfTemp.getText() ); // convert temp string to double
         double p = Double.parseDouble( tfPressure.getText() ); // convert pressure to double
         double densityAltitude = AviationMath.densityAltitude( t, p ); // call DA Aviation Method
         lblDensAlt.setText( Double.toString( densityAltitude ) ); // convert double back to string and display in label
      }
      else
      {
         if( ae.getSource() == bReset )
         {
            lblDensAlt.setText( "0" );
            tfTemp.setText( "" );
            tfPressure.setText( "" );
         }
      }
   }
}