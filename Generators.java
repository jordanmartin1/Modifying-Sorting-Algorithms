import java.util.Random;

/**
 * Sequence generators for testing sort algorithms.
 * 
 * @author Nathan Sprague
 * @version 2/2019
 *
 */
public class Generators {

  private static Random gen;

  /**
   * Generate a random sequence of Integers with the indicated size. The entries
   * in the resulting sequence will be drawn from all possible integers with equal
   * probability.
   */
  public static Integer[] generateRandom(int size) {
    if (gen == null) {
      gen = new Random();
    }
    Integer[] result = new Integer[size];

    for (int i = 0; i < size; i++) {
      result[i] = Integer.valueOf(gen.nextInt());
    }
    return result;
  }

  /**
   * Generate an sequence of Integers with the indicated size. The entries in the
   * resulting sequence will be in the range 0 to size-1.
   */
  public static Integer[] generateOrdered(int size) {
    Integer[] result = new Integer[size];

    for (int i = 0; i < size; i++) {
      result[i] = Integer.valueOf(i);
    }
    return result;
  }

  /**
   * Generate a worst-case input array for quicksort.
   */
  public static Integer[] generateEvil(int size) {

    // Space for the result
    Integer[] result = new Integer[size];

    int[] indices = new int[size];
    for (int i = 0; i < size; i++) {
      indices[i] = i;
    }

    for (int k = size - 1; k >= 0; k--) {

      // quicksort would select this pivot index.
      int mid = k / 2;

      // so we want to make the value that originated at this index the
      // largest remaining.
      result[indices[mid]] = k;

      // quicksort would then perform this swap to move whatever was
      // at mid to the end.
      int tmp = indices[mid];
      indices[mid] = indices[k];
      indices[k] = tmp;
    }

    return result;

  }



}
