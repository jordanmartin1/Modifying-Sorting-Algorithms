
/**
 * Introsort class.
 * 
 * @author Jordan Martin
 * @version 3/30/2022
 */
public class IntroSort {

  /**
   * Sort the provided items using the introsort algorithm.
   * 
   * @param items to be sorted
   */
  public static <T extends Comparable<T>> void introSort(T[] items) {
    int maxDepth = (int) (2 * Math.floor(Math.log(items.length)));
    if (items.length < 16) {
      BasicSorts.insertionSort(items);
    }
    sort(items, 0, items.length - 1, maxDepth);
    
  }
  
  /**
   * Private helper method.
   * 
   * @param items to be sorted
   * @param maxDepth - maximum depth to check which sort method to use
   */
  public static <T extends Comparable<T>> void sort(T[] items, int left, int right, int maxDepth) {
    if (maxDepth <= 0) {
      MergeSortsImproved.mergeSort2(items);
      return;
    } else {
      int pivot = QuickSort.findPivot(items, left, right);
      int partition = QuickSort.partition(items, left, right, pivot);

      if ((partition - left) > 1) {
        sort(items, left, partition - 1, maxDepth - 1);
      }
      
      if ((right - partition) > 1) {
        sort(items, partition + 1, right, maxDepth - 1);
      }
    
    
    }
  }

}
