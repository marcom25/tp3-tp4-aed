import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static List<Integer> sort(List<Integer> list) {
        int size = list.size();

        if (size < 2) {
            return list;
        }

        // crear sub-listas
        int middle = size / 2;
        List<Integer> left = new ArrayList<Integer>(list.subList(0, middle));
        List<Integer> right = new ArrayList<Integer>(list.subList(middle, size));

        // ordenar sub-listas
        List<Integer> sortedLeft = sort(left);
        List<Integer> sortedRight = sort(right);

        // mezclar lados
        return merge(sortedLeft, sortedRight);
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> list = new ArrayList<Integer>();

        int leftSize = left.size();
        int rightSize = right.size();

        int i = 0;
        int j = 0;
        while (i < leftSize && j < rightSize) {
            if (left.get(i) <= right.get(j)) {
                list.add(left.get(i));
                i++;
            } else {
                list.add(right.get(j));
                j++;
            }
        }

        // añadir los elementos sobrantes de la izquierda
        while (i < leftSize) {
            list.add(left.get(i));
            i++;
        }

        // añadir los elementos sobrantes de la derecha
        while (j < rightSize) {
            list.add(right.get(j));
            j++;
        }

        System.out.println("merge: " + list);
        return list;
    }
}
