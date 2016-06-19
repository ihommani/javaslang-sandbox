package collections.list;

import javaslang.Function1;

/**
 * Created on 19/06/16.<br/>
 */
public class CommonOperations {

    // Let's say that multiblying a string by ten is done by right aggregating "0".
    public static Function1<String, Integer> multiplybyTenAndTransformIntoInteger() {
        // notice the function composition done by the keyword "andThen" or "compose"
        return ((Function1<String, String>) integer -> integer + "0").andThen(toInteger());
    }

    public static Function1<String, Integer> toInteger() {
        return Integer::new;
    }
}
