import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MergeSort2Test extends AbstractStableSortTest {

  @BeforeEach
  void setUp() throws Exception {
    sorter = (items) -> MergeSortsImproved.mergeSort2(items);
  }  

}
