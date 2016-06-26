package collections.list;

import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.List;
import javaslang.collection.Map;
import javaslang.collection.Traversable;

import java.util.function.Function;

import static collections.list.CommonOperations.multiplybyTenAndTransformIntoInteger;
import static collections.list.CommonOperations.toInteger;

/**
 * Created on 14/06/16.<br/>
 * <p>
 * Javaslang has its own List structure.
 */
public class ListSandBox {

    /**
     * Sum a given array of string representation of integers
     *
     * @param elements
     * @return
     */
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

    /**
     * Create a windows of ten elements over a list, calculate the mean value, and then slide of ten other elements
     * @param elements
     * @return
     */
    public List<Integer> getTheMeanValueOfEachTenConsecutiveValues(List<Integer> elements) {
        return elements.sliding(10, 10)
                .map(Traversable::sum)
                .map(integer -> integer.intValue() / 10)
                .toList();
    }

    /**
     * Starting a list of element, associate them by pair
     * @param elements
     * @return
     */
     public <T> Map<T, T> associateByTwo(List<T> elements) {
        return elements.sliding(2, 2).toMap(new Function<List<T>, Tuple2<T, T>>() {
            @Override
            public Tuple2<T, T> apply(List<T> elements) {
                return Tuple.of(elements.get(0), elements.get(1));
            }
        });
    }
}
