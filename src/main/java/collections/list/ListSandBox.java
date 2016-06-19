package collections.list;

import javaslang.Function1;
import javaslang.collection.List;

/**
 * Created on 14/06/16.<br/>
 * <p>
 * Javaslang has its own List structure.
 */
public class ListSandBox {

    public Integer sumElements(String... elements) {
        return List.of(elements)
                .map(multiplybyTenAndTransformIntoInteger())
                .sum()
                .intValue();
    }

    public Integer biggerOperation(String divisor, String... elements) {
        return List.of(elements)
                .map(multiplybyTenAndTransformIntoInteger())
                .map(sum -> sum / toInteger().apply(divisor))
                .sum()
                .intValue();
    }

    // Let's say that multiblying a string by ten is done by right aggregating "0".
    private Function1<String, Integer> multiplybyTenAndTransformIntoInteger() {
        // notice the function composition done by the keyword "andThen" or "compose"
        return ((Function1<String, String>) integer -> integer + "0").andThen(toInteger());
    }

    private Function1<String, Integer> toInteger() {
        return Integer::new;
    }

}
