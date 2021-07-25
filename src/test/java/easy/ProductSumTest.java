package easy;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductSumTest {

  @Test
  public void productSum() {
    List<Object> array = Stream.of(
      5, 2, Stream.of(7, -1).collect(Collectors.toList()), 3,
      Stream.of(6, Stream.of(-13, 8).collect(Collectors.toList()), 4).collect(Collectors.toList())
    ).collect(Collectors.toList());

    ProductSum.productSum(array);
  }
}