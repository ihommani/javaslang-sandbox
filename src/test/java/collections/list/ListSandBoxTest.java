package collections.list;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

/**
 * Created on 14/06/16.<br/>
 */
public class ListSandBoxTest {

    private ListSandBox listSandBox = new ListSandBox();
    private VanillaJavaList vanillaJavaList = new VanillaJavaList();

    @Test
    public void should_sum_elements() {
        Assertions.assertThat(listSandBox.sumElements("1", "2", "3")).isEqualTo(60);
    }

    @Test
    public void should_sum_elements_vanilla() {
        Assertions.assertThat(vanillaJavaList.sumElements("1", "2", "3")).isEqualTo(60);
    }
}