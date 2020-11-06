import java.util.Scanner;
import java.util.Iterator;

/**
 * Test Iterators
 * @author Burak Ozturk
 * @version 05.11.2020
 */ 
public class TestIterators
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);

      // constants

      // variables
      Iterator i, j;
      IntBag bag;

      // program code
      System.out.println( "Start...");
      
      bag = new IntBag();
      
      for (int k = 0; k < 5; k++)
         bag.add( k, (int)(Math.random() * 50));
      
      System.out.println("Bag: " + bag.toString());
      
      i = bag.iterator();
      while ( i.hasNext() )
      {
         System.out.println( i.next() );
         j = bag.iterator();
         while ( j.hasNext() )
         {
            System.out.println( "--" + j.next() );
         }
      }


      System.out.println( "End.");
   }

}