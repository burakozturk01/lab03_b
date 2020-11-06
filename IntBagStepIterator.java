import java.util.Iterator;

/**
 * Iterator sub-class for IntBag class
 */
public class IntBagStepIterator extends IntBag implements Iterator
{
   // properties
   private IntBag aBag;
   private int index, m;

   // constructors
   public IntBagStepIterator( IntBag bag, int m)
   {
      aBag = bag;
      index = 0;
      this.m = m;
   }
   
   // methods
   public Object next()
   {
      int tmp = aBag.get(index);
      index = index + m;
      return tmp;
   }
   public boolean hasNext()
   {
      if (aBag.getValid() == -1)
         return false;
      else
         return aBag.getValid() > index;
   }
}