import java.util.Iterator;

/**
 * Integer array controlling class
 */
public class IntBag 
{
   //properties
   private int[] bag;
   private int m;
   Iterator it;
   
   //constructors
   public IntBag()
   {
      int[] bag ={ -1, 0, 0, 0};
      this.bag = bag;
   }
   
   public IntBag( int m)
   {
      int[] bag ={ -1, 0, 0, 0};
      this.bag = bag;
      this.m = m;
   }
   
   //methods
   public int getValid()
   {
      for ( int i = 0; i < bag.length; i++)
      {
         if ( bag[i] == -1)
            return i;
      }
      return -1;
   }
   
   public int getLength()
   {
      return bag.length;
   }
   
   public void doubleSize()
   {
      int[] newBag = new int[2 * bag.length];
      
      for ( int i = 0; i < bag.length; i++)
         newBag[i] = bag[i];
      
      bag = newBag;
   }
   
   public int add( int index, int value)
   {
      if ( index < 0)
         return -1;
      else if ( index >= bag.length || bag[bag.length - 1] == -1)
      {
         doubleSize();
         return add( index, value);
      }
      
      else
      {
         int l = 0;
         for ( int i = 0; i < bag.length - 1; i++)
         {
            if ( bag[i] == -1)
               l = i;
         }
         
         for ( int i = l; i >= index; i--)
            bag[i + 1] = bag[i];
         
         bag[index] = value;
         
         return index;
      }
   }
   
   public int remove( int index)
   {
      int temp;
      
      if ( index >= bag.length || bag[index] == -1)
         return -1;
      
      else if ( index == bag.length - 1)
      {
         temp = bag[index];
         bag[index] = -1;
         return temp;
      }
      
      else
      {
         int l = 0;
         for ( int i = 0; i < bag.length; i++)
         {
            if ( bag[i] == -1)
            {
               l = i;
               i = bag.length;
            }
         }
         
         temp = index;
         
         for ( int i = index; i < l; i++)
            bag[i] = bag[i + 1];
         
         l = 0;
         
         return temp;
      }
   }
   
   public int get( int index)
   {
      int l = 0;
      for ( int i = 0; i < bag.length; i++)
      {
         if ( bag[i] == -1)
         {
            l = i;
            i = bag.length;
         }
      }
      
      if ( index < l)
         return bag[index];
      else
         return -1;
   }
   
   public void removeAll( int value)
   {
      if ( value <= 0)
         System.out.println( "Value must be positive");
      else
      {
         for ( int i = 0; i < bag.length; i++)
         {
            if ( bag[i] == value)
               remove(i);
         }
      }
   }
   
   public String toString()
   {
      
      if ( bag[0] == -1)
         return "{}";
      
      String s = "{ " + bag[0];
      
      for ( int i = 1; i < bag.length; i++)
      {
         if ( bag[i] == -1)
            return s + "}";
         else
         {
            s += ", " + bag[i];
         }
      }
      return s;
   }
   
   public Iterator iterator()
   {
      if ( m == 0)
         it = new IntBagIterator( this);
      else
         it = new IntBagStepIterator( this, this.m);
      return it;
   }
}