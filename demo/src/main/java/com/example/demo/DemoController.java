package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class DemoController {

    private Map<Integer, List<String>> map = new HashMap<>();

    {
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));
    }

    @PostMapping("/")
    public List<String> printAllStr(@RequestBody int[] arr){
        List<String> s = map.get(arr[0]);
        LinkedList<String> queue = new LinkedList<>(s);
        if (arr.length > 1) {
            for (int i = 1; i < arr.length; i++) {
                List<String> list = map.get(arr[i]);
                if (queue.size() > 0) {
                    int size = queue.size();
                    while (size > 0) {
                        String peek = queue.poll();
                        list.forEach(c ->queue.add(peek+c));
                        size--;
                    }
                }
            }
        }
        List<String> res = new ArrayList<>(queue);
        res.forEach(t -> System.out.print(t+" "));
        return res;
    }

    public static final String[] unit = {"", "One", "Two", "Three", "Four",
            "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
            "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};

    public static final String[] tens = {
            "",
            "",
            "Twenty",
            "Thirty",
            "Forty",
            "Fifty",
            "Sixty",
            "Seventy",
            "Eighty",
            "Ninety"
    };

    @PostMapping("/convert")
    public static String convert(final int n) {
        if (n < 0) {
            return "Minus" + convert(-n);
        }
        if (n < 20) {
            return unit[n];
        }
        return tens[n/10] +((n % 10 != 0) ? " " : "") + unit[n % 10];
    }
}
