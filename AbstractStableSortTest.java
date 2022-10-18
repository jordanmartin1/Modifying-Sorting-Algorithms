import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

/**
 * Unit tests that check for sort stability. Inherits from AbstractSortTest,
 * which tests for sort correctness.
 * 
 * @author CS 240 Instructors
 * @version 10/15/2021
 *
 */
abstract class AbstractStableSortTest extends AbstractSortTest {

  protected void checkSortStability(Integer[] numbers, Sorter<Integer> sorter) {
    Integer[] copy = Arrays.copyOf(numbers, numbers.length);
    Arrays.sort(copy);
    sorter.sort(numbers);
    for (int i = 0; i < numbers.length; i++) {
      assertTrue(copy[i] == numbers[i]);
    }
  }

  
  @Test
  public void testStableRandomSequences() {
    Integer[] curSequence;
    for (int i = 0; i < 50; i++) {
      curSequence = randomSequence(i);
      checkSortStability(curSequence, sorter);
    }
  }

  @Test
  public void testStableAllEqual() {
    for (int size = 1; size < 20; size++) {
      Integer[] numbers = new Integer[size];
      for (int i = 0; i < size; i++) {
        numbers[i] = 10100021;
      }
      checkSortStability(numbers, sorter);
    }
  }

}
