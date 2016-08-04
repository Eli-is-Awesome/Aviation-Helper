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

public class JTabbedPaneFrame extends JFrame
{


   // set up GUI
   public JTabbedPaneFrame()
   {
      super( "Aviation Helper" );

      JTabbedPane tabbedPane = new JTabbedPane(); // create JTabbedPane

      // set up pane11 and add it to JTabbedPane
      DensityAltitudeView da = new DensityAltitudeView();
      JPanel densityAltitude = new JPanel(); // create first panel
      densityAltitude.setBackground( Color.DARK_GRAY );
      tabbedPane.addTab( "Density Altitude Calculator", null, densityAltitude, "Calculate Density Altitude" );
      densityAltitude.add( da ); // add label to panel

      // set up panel2 and add it to JTabbedPane
      JLabel label2 = new JLabel( "panel two", SwingConstants.CENTER );
      JPanel panel2 = new JPanel(); // create second panel
      panel2.add( label2 ); // add label to panel
      tabbedPane.addTab( "Crosswind/Headwind Calculator", null, panel2, "Calculate crosswinds/headwinds" );

      // set up panel3 and add it to JTabbedPane
      TrueAirspeedView tas = new TrueAirspeedView();
      JPanel trueAirspeed = new JPanel(); // create third panel
      trueAirspeed.setBackground( Color.BLUE );
      tabbedPane.addTab( "True Airspeed", null, trueAirspeed, "Calculate true airspeed" );
      // panel3.setBackground( Color.BLUE );
      trueAirspeed.add( tas );
      
      // set up pane14 and add it to JTabbedPane
      GroundSpeedView gs = new GroundSpeedView();
      JPanel groundSpeed = new JPanel(); // create fourth panel
      groundSpeed.setBackground( Color.GREEN );
      tabbedPane.addTab( "Groundspeed", null, groundSpeed, "Calculate groundspeed" );
      groundSpeed.add( gs ); // add label to panel
      
      // set up pane15 and add it to JTabbedPane
      JPanel fuelWeight = new JPanel(); // create fith panel
      FuelWeightView fw = new FuelWeightView();
      fuelWeight.setBackground( Color.GRAY );
      tabbedPane.addTab( "Fuel Weight", null, fuelWeight, "Calculate fuel weight" );
      fuelWeight.add( fw ); // add label to panel

      // set up pane16 and add it to JTabbedPane
      JPanel basicConversionPanel = new JPanel(); // create coversion panel
      GeneralCalculationsView ftm = new GeneralCalculationsView();
      basicConversionPanel.setBackground( Color.WHITE );
      tabbedPane.addTab( "Aviation Unit Conversion Calculator", null, basicConversionPanel, "Convert basic aviation units" );
      basicConversionPanel.add( ftm ); // add feet to meters
      
      
      add( tabbedPane ); // add JTabbedPane to frame
   } // end JTabbedPaneFrame constructor
} // end class JTabbedPaneFrame