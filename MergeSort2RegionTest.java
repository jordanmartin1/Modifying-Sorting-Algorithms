import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeSort2RegionTest {

  private static int SORT_SIZE = 1000;
  private Integer[] numbers;

  @BeforeEach
  void setUp() throws Exception {
    
    // Initialize numbers to be in reverse order.
    numbers = new Integer[SORT_SIZE];
    for (int i = 0; i < SORT_SIZE; i++) {
      numbers[i] = SORT_SIZE - i - 1;
    }
  }


  @Test
  public void testSortWholeArrayReverseOrder() {
    Integer[] copy = Arrays.copyOf(numbers, numbers.length);
    MergeSortsImproved.mergeSort2(numbers, 0, numbers.length - 1);
    Arrays.sort(copy, 0, numbers.length);
    assertArrayEquals(copy, numbers);
  }

  @Test
  public void testSortAllButLastReverseOrder() {
    Integer[] copy = Arrays.copyOf(numbers, numbers.length);
    MergeSortsImproved.mergeSort2(numbers, 0, numbers.length - 2);
    Arrays.sort(copy, 0, numbers.length - 1);
    assertArrayEquals(copy, numbers);
  }

  @Test
  public void testSortAllButFirstReverseOrder() {
    Integer[] copy = Arrays.copyOf(numbers, numbers.length);
    MergeSortsImproved.mergeSort2(numbers, 1, numbers.length - 1);
    Arrays.sort(copy, 1, numbers.length);
    assertArrayEquals(copy, numbers);
  }


  @Test
  public void testSortAllButFirstAndLastReverseOrder() {
    Integer[] copy = Arrays.copyOf(numbers, numbers.length);
    MergeSortsImproved.mergeSort2(numbers, 1, numbers.length - 2);
    Arrays.sort(copy, 1, numbers.length - 1);
    assertArrayEquals(copy, numbers);
  }


}
