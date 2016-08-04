package AviationApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FuelWeightView extends JPanel implements ActionListener
{
   private JTextField txtGallons; // user input for gallons of fuel
   private JLabel lblFuelWeight;
   private JLabel lblGallons;
   private JLabel lblWeight;
   private JButton bCalc; // do the calculation
   private JButton bReset; // reset the fields
   public Font font;
   
   public FuelWeightView()
   {
      setLayout( new GridLayout( 4, 2, 5, 9 ) );
      
      txtGallons = new JTextField();
      lblFuelWeight = new JLabel( "0" );
      lblGallons = new JLabel( "Gallons: " );
      lblWeight = new JLabel( "Weight (lbs): " );
      bCalc = new JButton( "Calculate" );
      bReset = new JButton( "Reset" );
      font = new Font( "Times New Roman", Font.BOLD, 16 );
      
      lblGallons.setFont( font );
      lblGallons.setForeground( Color.WHITE );
      add( lblGallons );
      add( txtGallons );
      lblWeight.setFont( font );
      lblWeight.setForeground( Color.WHITE );
      add( lblWeight );
      lblFuelWeight.setFont( font );
      lblFuelWeight.setForeground( Color.WHITE );
      add( lblFuelWeight );
      add( bCalc );
      add( bReset );
      
      bCalc.addActionListener( this );
      bReset.addActionListener( this );
      
      setBackground( Color.GRAY );
      setVisible( true );
   }
   
   public void actionPerformed( ActionEvent ae )
   {
     if( ae.getSource() == bCalc )
     {
        // get data from txtField(s) & convert to numeric type
        float gallons = Float.parseFloat( txtGallons.getText() );
        // call appropriate AviationMath method
        float weight = AviationMath.fuelWeight( gallons );
        // convert result toString & store string in appropriate JLabel
        lblFuelWeight.setText( Float.toString( weight ) );
     }
     else
     {
        if( ae.getSource() == bReset )
        {
            txtGallons.setText( "0" );
            lblFuelWeight.setText( "0" );
        }
     }
   }
}