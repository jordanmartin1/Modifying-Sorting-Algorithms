import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for checking the efficiency of introspective sort. No tests for
 * correctness.
 * 
 * @author Nathan Sprague
 *
 */
class IntroSortEfficiencyTest {

  private Sorter<CountInt> sorter;

  @BeforeEach
  void setUp() throws Exception {
    sorter = (items) -> IntroSort.introSort(items);
    CountInt.resetComparisonCount();
  }


  @Test
  public void testIntroSorterHandlesWorstCaseInput() {
    Generator gen = (size) -> Generators.generateEvil(size);

    CountInt[] values = CountInt.copyIntegerArray(gen.generate(250));

    sorter.sort(values);
    int total = CountInt.getComparisonCount();

    // Reference implementation performs 5111 comparisons
    assertTrue(total < 6500);
  }


  @Test
  public void testIntroSortActsLikeQuickSortOnRandomInputs() {
    Generator gen = (size) -> Generators.generateRandom(size);

    Sorter<CountInt> iSorter = (items) -> IntroSort.introSort(items);
    Sorter<CountInt> qSorter = (items) -> QuickSort.quickSort(items);


    CountInt[] values1 = CountInt.copyIntegerArray(gen.generate(100000));
    CountInt[] values2 = Arrays.copyOf(values1, values1.length);


    iSorter.sort(values1);
    int totalIntro = CountInt.getComparisonCount();

    CountInt.resetComparisonCount();

    qSorter.sort(values2);

    int totalQuick = CountInt.getComparisonCount();

    assertTrue(Math.abs(totalIntro - totalQuick) < (.05 * totalIntro));

  }

}
