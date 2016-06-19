package collections.list;

import javaslang.collection.List;

import static collections.list.CommonOperations.multiplybyTenAndTransformIntoInteger;
import static collections.list.CommonOperations.toInteger;

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
}
