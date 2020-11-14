package net.java;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * Unit test for simple App.
 */
public class StreamTest {
    private Collection<Integer> oneToTen;

    @Before
    public void setup() {
        oneToTen = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            oneToTen.add(i);
        }
    }

    @Test
    public void filterExample() {
        assert 5L == oneToTen.stream()
                            .filter( i -> i%2 > 0)
                            .count();
    }

    @Test
    public void noneMatchExample() {
        assert oneToTen.stream()
                    .noneMatch( i-> i == 11);
    }

    @Test
    public void collectExample() {
        List<Integer> even = oneToTen.stream()
                                .filter( i -> i%2 > 0 )
                                .collect(toList());
        assert even.size() == 5;
    }

    @Test
    public void mapCollectExample() {
        Map<Integer,Integer> digits =  oneToTen.stream()
                                                .collect(toMap(i -> i, d -> 2 * d));
        assert digits.get(1) == 2;
        assert digits.get(2) == 4;
    }

    @Test
    public void mapToUpperCase() {
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        List<String> upper = letters.stream().map(str -> str.toUpperCase()).collect(toList());
        assert upper.contains("A");
        assert upper.contains("B");
        assert upper.contains("C");
        assert upper.contains("D");
        assert upper.contains("E");
    }

    @Test
    public void mapExample() {
        Map<Integer, Integer> doubled = new HashMap<>();
        doubled.put(1, 2);
        doubled.put(2, 4);
        doubled.put(3, 6);
        doubled.put(4, 8);
        assert 3 == doubled.compute(1, (k,v) -> k + v);
    }
}
