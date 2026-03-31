package model.services;

import java.util.List;

public class CalculationService {
    public static <P extends Comparable<P>> P max(List<P> list) {
        if(list.isEmpty()) {
            throw new IllegalStateException("Lista não pode ser vazia.");
        }
        P max = list.get(0);
        for (P item : list) {
            if (item.compareTo(max) > 0) {
                max = item;
            }
        }
        return max;
    }
}
