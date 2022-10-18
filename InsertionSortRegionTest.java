import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InsertionSortRegionTest {
  
  @Test
  public void testSortWholeArrayReverseOrder() {
    Integer[] curSequence = new Integer[]{5, 4, 3, 2, 1, 0};
    BasicSorts.insertionSort(curSequence, 0, curSequence.length - 1);
    assertArrayEquals(new Integer[] {0, 1, 2, 3, 4, 5}, curSequence);
  }
  
  @Test
  public void testSortAllButLastReverseOrder() {
    Integer[] curSequence = new Integer[]{5, 4, 3, 2, 1, 0};
    BasicSorts.insertionSort(curSequence, 0, curSequence.length - 2);
    assertArrayEquals(new Integer[] {1, 2, 3, 4, 5, 0}, curSequence);
  }
  
  @Test
  public void testSortAllButFirstReverseOrder() {
    Integer[] curSequence = new Integer[]{5, 4, 3, 2, 1, 0};
    BasicSorts.insertionSort(curSequence, 1, curSequence.length - 1);
    assertArrayEquals(new Integer[] {5, 0, 1, 2, 3, 4}, curSequence);
  }
  
  @Test
  public void testSortAllButFirstAndLastReverseOrder() {
    Integer[] curSequence = new Integer[]{5, 4, 3, 2, 1, 0};
    BasicSorts.insertionSort(curSequence, 1, curSequence.length - 2);
    assertArrayEquals(new Integer[] {5, 1, 2, 3, 4, 0}, curSequence);
  }

}
