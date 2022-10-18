/*
 * OpenDSA Project Distributed under the MIT License
 * 
 * Copyright (c) 2011-2016 - Ville Karavirta and Cliff Shaffer
 * 
 * Modifications by Nathan Sprague 2016.
 */

/**
 * Quicksort class.
 */
public class QuickSort {

  /**
   * Quicksort the provided array.
   * 
   * @param items to be sorted
   */
  public static <T extends Comparable<T>> void quickSort(T[] items) {
    if (items.length > 0) {
      quickSort(items, 0, items.length - 1);
    }
  }

  /**
   * Recursive helper method for quicksort.
   * 
   * @param items The items to sort
   * @param left The starting index of the region to sort
   * @param right The ending index of the region to sort.
   */
  private static <T extends Comparable<T>> void quickSort(T[] items, int left, int right) {
    int pivotindex = findPivot(items, left, right);

    // curr will be the final position of the pivot item.
    int curr = partition(items, left, right, pivotindex);

    if ((curr - left) > 1) {
      quickSort(items, left, curr - 1); // Sort left partition
    }
    if ((right - curr) > 1) {
      quickSort(items, curr + 1, right); // Sort right partition
    }
  }

  /**
   * Helper method to select the pivot point.
   * 
   * @param items array
   * @param left Index to start at
   * @param right Index to end at
   * 
   * @return pivot integer
   */
  protected static <T extends Comparable<T>> int findPivot(T[] items, int left, int right) {
    return (left + right) / 2;
  }

  /**
   * Partition the indicated region of the array. The pivot item will be placed in
   * its final sorted position, with all smaller elements moved to the left and
   * all larger elements moved to the right.
   * 
   * @param items to be sorted
   * @param left Index to start at
   * @param right Index to end at
   * 
   * @return The final index of the pivot item.
   */
  protected static <T extends Comparable<T>> int partition(T[] items, int left, int right,
      int pivotindex) {

    T pivot = items[pivotindex];
    BasicSorts.swap(items, pivotindex, right); // Stick the pivot at end
    pivotindex = right; // remember where it is.
    right--;


    while (left <= right) { // Move bounds inward until they meet
      while (items[left].compareTo(pivot) < 0) {
        left++;
      }
      while ((right >= left) && (items[right].compareTo(pivot) >= 0)) {
        right--;
      }
      if (right > left) {
        BasicSorts.swap(items, left, right); // Swap out-of-place values
      }
    }
    BasicSorts.swap(items, left, pivotindex); // Put pivot in place

    return left; // Return first position in right partition
  }


}
