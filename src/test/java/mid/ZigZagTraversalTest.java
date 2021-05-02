package mid;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class ZigZagTraversalTest {

  @Test
  public void zigzagTraverse() {
    final List<Integer> actual = ZigZagTraversal.zigzagTraverse(
      Stream.of(
        Stream.of(1,  3,  4,  10).collect(Collectors.toList()),
        Stream.of(2,  5,  9,  11).collect(Collectors.toList()),
        Stream.of(6,  8,  12, 15).collect(Collectors.toList()),
        Stream.of(7,  13, 14, 16).collect(Collectors.toList())
      ).collect(Collectors.toList())
    );
    final List<Integer> expected = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
      .collect(Collectors.toList());

    assertEquals(expected, actual);
  }
}