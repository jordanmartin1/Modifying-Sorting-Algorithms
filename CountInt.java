/**
 * This class is similar to the Integer class, except that it maintains a static
 * count variable to keep track of the number of times the compareTo method is
 * called. This is useful for profiling sorting algorithms.
 * 
 * @author CS 240 Instructors
 * @version 10/15/2021
 *
 */
public class CountInt implements Comparable<CountInt> {

  private final int value;
  private static int comparisonCount = 0;

  /**
   * Initialize the integer value.
   * 
   * @param value Integer to store
   */
  public CountInt(int value) {
    this.value = value;
  }

  public int intValue() {
    return value;
  }

  @Override
  public int compareTo(CountInt other) {
    comparisonCount++;
    return value - other.intValue();
  }

  @Override
  public boolean equals(Object other) {
    return (other instanceof CountInt) && value == ((CountInt) other).value;
  }

  @Override
  public String toString() {
    return "" + value;
  }

  /**
   * Reset the static comparison count to zero.
   */
  public static void resetComparisonCount() {
    comparisonCount = 0;
  }

  /**
   * Return the total number of comparisons since the last reset.
   * 
   * @return count of comparisons
   */
  public static int getComparisonCount() {
    return comparisonCount;
  }

  /**
   * Return an array of CountInt's corresponding to the provided array of
   * Integers.
   * 
   * @param numbers The array to copy
   * @return CountInt version of the array.
   */
  public static CountInt[] copyIntegerArray(Integer[] numbers) {
    CountInt[] result = new CountInt[numbers.length];

    for (int i = 0; i < numbers.length; i++) {
      result[i] = new CountInt(numbers[i]);
    }
    return result;
  }


}
