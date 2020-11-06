import java.util.Iterator;

/**
 * Iterator sub-class for IntBag class
 */
public class IntBagIterator extends IntBag implements Iterator
{
   // properties
   private IntBag aBag;
   private int index;

   // constructors
   public IntBagIterator( IntBag bag)
   {
      aBag = bag;
      index = 0;
   }
   
   // methods
   public Object next()
   {
      index++;
      return aBag.get(index - 1);
   }
   public boolean hasNext()
   {
      if (aBag.getValid() == -1)
         return false;
      else
         return aBag.getValid() > index;
   }
}