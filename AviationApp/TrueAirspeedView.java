package AviationApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TrueAirspeedView extends JPanel implements ActionListener
{
   private JTextField txtIAS; // user input for Indicated Airspeed
   private JTextField txtALT; // user input for Altitude
   private JLabel lblTAS; // labe for True Airspeed
   private JLabel lblIAS;
   private JLabel lblALT;
   private JLabel lblTASlabel;
   private JButton bCalc; // do the calculation
   private JButton bReset; // reset the fields
   public Font font;
   
   public TrueAirspeedView()
   {
      setLayout( new GridLayout( 5, 2, 5, 9 ) );
      
      txtIAS = new JTextField( "" );
      txtALT = new JTextField( "" );
      lblIAS = new JLabel( "Indicated Airspeed: " );
      lblALT = new JLabel( "Altitude: " );
      lblTASlabel = new JLabel( "True Airspeed: " );
      lblTAS = new JLabel( "0" );
      bCalc = new JButton( "Calculate" );
      bReset = new JButton( "Reset" );
      font = new Font( "Times New Roman", Font.BOLD, 16 );
      
      lblIAS.setFont( font );
      lblIAS.setForeground( Color.WHITE );
      add( lblIAS );
      add( txtIAS );
      lblALT.setFont( font );
      lblALT.setForeground( Color.WHITE );
      add( lblALT );
      add( txtALT );
      lblTASlabel.setFont( font );
      lblTASlabel.setForeground( Color.WHITE );
      add( lblTASlabel );
      lblTAS.setForeground( Color.GREEN );
      add( lblTAS );
      add( bCalc );
      add( bReset );
      
      bCalc.addActionListener( this );
      bReset.addActionListener( this );
      
      setBackground( Color.BLUE );
      setVisible( true );
   }
   
   public void actionPerformed( ActionEvent ae )
   {
     if( ae.getSource() == bCalc )
     {
        // get data from txtField(s) & convert to numeric type
        double ias = Double.parseDouble( txtIAS.getText() );
        double alt = Double.parseDouble( txtALT.getText() );
        // call appropriate AviationMath method
        int trueAirspeed = (int) AviationMath.trueAirspeed( ias, alt );
        // convert result toString & store string in appropriate JLabel
        lblTAS.setText( Integer.toString( trueAirspeed ) + " knots" );
     }
     else
     {
        if( ae.getSource() == bReset )
        {
            txtIAS.setText( "" );
            txtALT.setText( "" );
            lblTAS.setText( "0" );
        }
     }
   }
}