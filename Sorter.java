/**
 * Functional interface for sorting methods.
 * 
 * @author Nathan Sprague
 * @version 2/2019
 *
 */
@FunctionalInterface
public interface Sorter<T extends Comparable<T>> {
  void sort(T[] items);
}
