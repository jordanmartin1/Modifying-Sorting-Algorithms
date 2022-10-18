/*
 * OpenDSA Project Distributed under the MIT License
 * 
 * Copyright (c) 2011-2016 - Ville Karavirta and Cliff Shaffer
 */

/**
 * Basic n^2 sorting algorithms.
 *
 *@author Jordan Martin - for insertionSort(items, start, end)
 */
public class BasicSorts {

  /**
   * Insertion sort the array.
   * 
   * @param items to be sorted
   */
  public static <T extends Comparable<T>> void insertionSort(T[] items) {

    for (int i = 1; i < items.length; i++) { // Insert i'th record
      T cur = items[i];
      int j = i;
      for (; (j > 0) && (cur.compareTo(items[j - 1]) < 0); j--) {
        items[j] = items[j - 1];
      }
      items[j] = cur;
    }
  }

  /**
   * Insertion sort just the indicated region of the array.
   * 
   * @param items to be sorted
   * @param start Index
   * @param end Index
   */
  public static <T extends Comparable<T>> void insertionSort(T[] items, int start, int end) {
    int j;
    for (int i = start; i <= end; i++) {
      T cur = items[i];
      for (j = i; (j > start) && (cur.compareTo(items[j - 1]) < 0); j--) {
        items[j] = items[j - 1];
      }
      items[j] = cur;
    }
  }
  


  /**
   * Selection sort the provided array.
   * 
   * @param items to be sorted
   */
  public static <T extends Comparable<T>> void selectionSort(T[] items) {

    for (int i = 0; i < items.length - 1; i++) { // Select i'th biggest record
      int bigindex = 0; // Current biggest index
      for (int j = 1; j < items.length - i; j++) { // Find the max value
        if (items[j].compareTo(items[bigindex]) > 0) { // Found something bigger
          bigindex = j; // Remember bigger index
        }
      }
      swap(items, bigindex, items.length - i - 1); // Put it into place
    }
  }


  /**
   * Swap items i and j in the provided array.
   * 
   * @param items to be sorted
   * @param i - first item to be swapped
   * @param j - second item to be swapped
   */
  public static <T extends Comparable<T>> void swap(T[] items, int i, int j) {
    T tmp = items[i];
    items[i] = items[j];
    items[j] = tmp;
  }

}
