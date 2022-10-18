import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeSort1Test extends AbstractStableSortTest {

  @BeforeEach
  void setUp() throws Exception {
    sorter = (items) -> MergeSortsImproved.mergeSort1(items);
  }

}
