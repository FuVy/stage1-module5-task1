package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return list -> {
            for (String str : list) {
                if (str == null || str.isEmpty() || !Character.isUpperCase(str.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            int added = 0;
            for (int i = 0; i < list.size() - added; i++) {
                if (list.get(i) % 2 == 0) {
                    list.add(list.get(i));
                    added++;
                }
            }
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> filteredList = new ArrayList<>();
            for (String str : values) {
                if (str != null && !str.isEmpty() &&
                        Character.isUpperCase(str.charAt(0)) &&
                        str.endsWith(".") &&
                        str.split("\\s+").length > 3) {
                    filteredList.add(str);
                }
            }
            return filteredList;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return list -> {
            Map<String, Integer> map = new HashMap<>();
            for (String str : list) {
                map.put(str, str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            List<Integer> result = new ArrayList<>(list1);
            result.addAll(list2);
            return result;
        };
    }
}
