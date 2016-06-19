package collections.list;

import java.util.Arrays;

/**
 * Created on 14/06/16.<br/>
 */
public class VanillaJavaList {

    public Integer sumElements(String... elements) {
        return Arrays.stream(elements)
                .map(s -> s + "0")
                .map(Integer::valueOf)
                .mapToInt(value -> value)
                .sum();
    }
}
