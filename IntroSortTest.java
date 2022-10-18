import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntroSortTest extends AbstractSortTest {

  @BeforeEach
  void setUp() throws Exception {
    sorter = (items) -> IntroSort.introSort(items);
  }

}
