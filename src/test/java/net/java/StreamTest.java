package net.java;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
    public void mapDouble() {
        Map<Integer, Integer> record = oneToTen.stream()
                .map( (k,v) -> (k, v*2));
    }
}
