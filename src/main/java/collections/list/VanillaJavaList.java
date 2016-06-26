package collections.list;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    public Integer biggerOperation(String divisor, String... elements) {
        return Arrays.stream(elements)
                .map(s -> s + "0")
                .map(Integer::valueOf)
                .map(integer -> integer / Integer.valueOf(divisor))
                .mapToInt(value -> value)
                .sum();
    }

    public <T> Map<T, T> associateByTwo(List<T> elements) {
        Iterator<T> evenElements = elements.stream().filter(evenElementPredicate(elements)).collect(Collectors.toList()).iterator();
        Iterator<T> unEvenElements = elements.stream().filter(evenElementPredicate(elements).negate()).collect(Collectors.toList()).iterator();

        Map<T, T> unEvenElementByEvenElement = new HashMap<>();

        while (evenElements.hasNext() && unEvenElements.hasNext()) {
            unEvenElementByEvenElement.put(evenElements.next(), unEvenElements.next());
        }
        return unEvenElementByEvenElement;
    }

    private <T> Predicate<T> evenElementPredicate(List<T> elements) {
        return element -> elements.indexOf(element) % 2 == 0;
    }

}
