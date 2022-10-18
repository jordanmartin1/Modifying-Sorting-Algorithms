
/**
 * Improved MergeSort class.
 * @author Jordan Martin
 */

public class MergeSortsImproved {
  
  static final int MERGE_SORT_THRESHOLD = 155;

  /**
   * Merge sort the provided array using an improved merge operation.
   * 
   * @param items to be sorted
   */
  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void mergeSort1(T[] items) {
    if (items.length == 0 || items.length == 1) {
      return;
    }
    T[] temp = (T[]) new Comparable[items.length];
    mergeSort(items, temp, 0, items.length - 1);
  }

  /**
   * Recursive helper method for the merge sort algorithm.
   * 
   * @param items The array to sort
   * @param temp Temporary array for merge operation
   * @param left Index of the left end of the region to sort
   * @param right Index of the right end of the region to sort.
   */

  private static <T extends Comparable<T>> void mergeSort(T[] items, T[] temp, int left,
      int right) {
    if (left >= right) {
      return; // Region has one record
    }

    int mid = (left + right) / 2; // Select midpoint

    mergeSort(items, temp, left, mid); // Mergesort first half
    mergeSort(items, temp, mid + 1, right); // Mergesort second half
    
    merge(items, temp, left, mid, right);
    
  }
  
  /**
   * Merge two sorted sub-arrays.
   * 
   * @param items to be sorted
   * @param temp - temporary array to hold items
   * @param left Index to start at
   * @param mid Index to divide the array at
   * @param right Index to end at
   */
  private static <T extends Comparable<T>> void merge(T[] items, T[] temp, int left, int mid,
      int right) {

    
    for (int i = 0; i < temp.length && i + left <= mid; i++) {
      temp[i] = items[i + left]; // Copy subarray to temp
    }

    int i1 = 0;
    int i2 = mid + 1;
    for (int curr = left; curr <= right; curr++) {
      if (i1 == temp.length || i1 + left >= mid + 1) { // Left subarray exhausted
        items[curr] = items[i2++];
      } else if (i2 > right) { // Right subarray exhausted
        items[curr] = temp[i1++];
      } else if (temp[i1].compareTo(items[i2]) <= 0) { // Get smaller value
        items[curr] = temp[i1++];
      } else {
        items[curr] = items[i2++];
      }
    }
  }


  /**
   * Merge sort the provided array by using an improved merge operation and
   * switching to insertion sort for small sub-arrays.
   * 
   * @param items to be sorted
   */

  public static <T extends Comparable<T>> void mergeSort2(T[] items) {
    mergeSort2(items, 0, items.length - 1);
  }

  /**
   * Merge sort the provided sub-array using our improved merge sort. This is the
   * fallback method used by introspective sort.
   * 
   * @param items to be sorted
   * @param start Index
   * @param end Index
   */
  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void mergeSort2(T[] items, int start, int end) {
    if (end - start < MERGE_SORT_THRESHOLD) {
      //sort with insertion
      BasicSorts.insertionSort(items);
      return;
    } else {
      T[] temp = (T[]) new Comparable[(items.length) / 2];
      
      int mid = (end + start) / 2;      

      mergeSort(items, temp, start, mid);
      mergeSort(items, temp, mid + 1, end);
      
      merge(items, temp, start, mid, end);

    }


  }

}
 