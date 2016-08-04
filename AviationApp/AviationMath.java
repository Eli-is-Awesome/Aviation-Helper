package AviationApp;

public class AviationMath
{
   public static float fuelWeight( float gallons )
   {
      return gallons * 6.0f; // Avgas 6 lbs per gallon
   }
  
   public static double densityAltitude( double t, double p )
   {
      double part1 = Math.pow( (17.326 * p)/(459.67 + t), 0.235 ); // first part of DA equation
      double densityAltitude = 145442.16 * (1 - part1); // finish DA equation
      return densityAltitude;
   }
  
   public static float trueAirspeed(double ias, double alt )
   {
      // true airspeed is indicated airspeed (IAS) increased by 2% per thousand feet of altitude
      // Example: IAS = 180 knots, altitude = 10000 feet. TAS = 180 + (180 * 0.02) * (10000 / 1000)
      // TAS in the example is 216 knots
      double trueAirspeed = (ias * 0.02) * (alt / 1000) + ias;
      return (int) trueAirspeed;
   }
  
   public static float feetToMeters( float f )
   {
      final float FTOMCF = 0.3048f;      
      float meters = f * FTOMCF;
      return meters;
   }
  
   public static float metersToFeet( float m )
   {
      final float MTOFF = 3.2808f;
      float feet = m * MTOFF;
      return feet;
   }
  
   public static double groundSpeedCalc( double wd, double dc, double ws, double as )
   {
      final double WINDIR = wd + 180; // calculate wind direcxtion
      final double WTANGLE = dc - WINDIR; // calculate wind to track angle
      double rWTANGLE = Math.toRadians( WTANGLE );
      double sinWCA = ws * Math.sin( rWTANGLE ) / as;
      double rSinWCA = Math.toRadians( sinWCA );
      final double WCA = Math.asin( rSinWCA );
      double heading = dc + WCA;
      double rWCA = Math.toRadians( WCA );
      double groundSpeed = as * Math.cos( rWCA ) + ws * Math.cos( rWTANGLE );
      return groundSpeed;
   }
  
/*   public static double crosswindCalc( double wd, double ws, double cd )
   {
          
   }*/
}