package collections.list;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * Created on 19/06/16.<br/>
 */
public class CommonOperationsTest {

    @Test
    public void should_multiply_by_ten_and_sum() {
        Assertions.assertThat(CommonOperations.multiplybyTenAndTransformIntoInteger().apply("3")).isEqualTo(30);
    }

    @Test
    public void should_convert_string_to_integer() {
        Assertions.assertThat(CommonOperations.toInteger().apply("3")).isEqualTo(3);
    }
}