package collections.list;

import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.collection.List;
import javaslang.collection.Map;
import javaslang.collection.Stream;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created on 14/06/16.<br/>
 */
public class ListSandBoxTest {

    private ListSandBox listSandBox = new ListSandBox();
    private VanillaJavaList vanillaJavaList = new VanillaJavaList();

    private Random random = new Random();

    @Test
    public void should_sum_elements() {
        Assertions.assertThat(listSandBox.sumElements("1", "2", "3")).isEqualTo(60);
    }

    @Test
    public void should_sum_elements_vanilla() {
        Assertions.assertThat(vanillaJavaList.sumElements("1", "2", "3")).isEqualTo(60);
    }


    @Test
    public void should_sum_elements_and_then_divide() {
        Assertions.assertThat(listSandBox.biggerOperation("10", "1", "2", "3")).isEqualTo(6);
    }

    @Test
    public void should_sum_elements_and_then_divide_elements() {
        Assertions.assertThat(vanillaJavaList.biggerOperation("10", "1", "2", "3")).isEqualTo(6);
    }

    @Test
    public void should_produced_a_ten_elements_list_with_mean_value_into_each() {
        List<Integer> theMeanValueOfEachTenConsecutiveValues = listSandBox.getTheMeanValueOfEachTenConsecutiveValues(Stream.fill(100, () -> random.nextInt()).toList());

        Assertions.assertThat(theMeanValueOfEachTenConsecutiveValues).hasSize(10);
    }

    @Test
    public void should_associate_element_by_2() {
        // when
        Map<String, String> assocation = listSandBox.associateByTwo(List.of("hello", "world", "james", "bond"));

        // then
        Assertions.assertThat(assocation).hasSize(2).containsOnly(Tuple.of("hello", "world"), Tuple.of("james", "bond"));
    }

    @Test
    public void should_associate_element_by_2_vanilla() {

        java.util.List<String> strings = new ArrayList<>();

        strings.add("hello");
        strings.add("world");
        strings.add("james");
        strings.add("bond");

        java.util.Map<String, String> assocation = vanillaJavaList.associateByTwo(strings);

        Assertions.assertThat(assocation).hasSize(2).containsOnlyKeys("hello", "james").containsValues("world", "bond");
    }

    @Test
    public void should_zip_elements_with_one_another() {
        Assertions.assertThat(List.empty().push("james").push("hello").zip(List.empty().push("bond").push("world")))
                .hasSize(2).containsOnly(Tuple.of("hello", "world"), Tuple.of("james", "bond"));
    }

    @Test
    public void should_zip_elements_with_one_another_vanilla() {
        // given
        java.util.List<String> elements1 = new ArrayList<>();
        java.util.List<String> elements2 = new ArrayList<>();

        elements1.add("hello");
        elements1.add("james");
        elements2.add("world");
        elements2.add("bond");

        // when
        java.util.Map<String, String> zippedElements = vanillaJavaList.zipStringElements(elements1, elements2);

        // then
        Assertions.assertThat(zippedElements).hasSize(2).containsOnlyKeys("hello", "james").containsValues("world", "bond");
    }

    @Test
    public void should_split_the_list_into_2_lists() {

        Tuple2<List<String>, List<String>> span = List.of("aaaaaa", "aaaaaaa", "aa", "aaaabaaa", "a", "bbbb", "azfbgvcsg").span(s -> !s.contains("b"));

        Assertions.assertThat(span._1).hasSize(3);
        Assertions.assertThat(span._2).hasSize(3);
    }
}