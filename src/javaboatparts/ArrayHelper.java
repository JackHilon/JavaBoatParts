
package javaboatparts;


public class ArrayHelper {
    
    // this class just for collect important methods from main class. 
    // this class has no role.
    
     private static int IndexOfLastDistinctItem(String[] array, int numberOfDistinctItems)
    {
        int count=1;
        
        for (int i = 1; i < array.length; i++) {
            
            if(CompareItem1(array, array[i], i))
            {
                count++;
            }
            
            if(count == numberOfDistinctItems)
                return i;
        }
        return -1;
    }
    
     // first version
    private static boolean CompareItem1(String[] array, String item, int indexOfItem)
    {
        for (int i = 0; i < indexOfItem-1; i++) {
            if(item.equals(array[i]))
                return false;
        }
        return true;
    }
    
    // second version
    private static boolean CompareItem2(String[] array, int indexOfItem)
    {
        for (int i = 0; i < indexOfItem-1; i++) {
            if(array[indexOfItem].equals(array[i]))
                return false;
        }
        return true;
    }
    
    // first version
    private static int NumberOfDistinctParts1(String[] array) {
        int same = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    continue;
                }
                if (array[i].equals(array[j])) {
                    same = same + 1;
                }
            }
        }
        return (int) array.length - (same / 2);
    }
    
    // second version
    private static int NumberOfDistinctParts2(String[] array) {
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if(CompareItem1(array, array[i], i))
                count++;
        }
        return count;
    }
}
