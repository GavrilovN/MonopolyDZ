package MONOPOLIA;
import java.util.Vector;
class Huh extends Space {
    static int max = 0;
    static int index_max=0;
    static int size = 0;
    static int chosen_get = 0;
    static int chosen_get_1 = 0;
    static int chosen_get_2 = 0;
    static int travel_get = 0;
    static int travel_get_1 = 0;
    static int travel_get_2 = 0;
    private static Vector<Integer> v_path = new Vector<>();                        //храним считанные перемещение как число клеток
    private static Vector<Integer> chosen = new Vector<>();
    private static Vector<Integer> path_sum_index = new Vector<>();
    private static Vector<Integer> chosen_keeper = new Vector<>();
    private static Vector<Integer> chosen_keeper_1 = new Vector<>();
    private static Vector<Integer> chosen_keeper_2 = new Vector<>();
    private static Vector<Integer> travel_keeper = new Vector<>();
    private static Vector<Integer> travel_keeper_1 = new Vector<>();
    private static Vector<Integer> travel_keeper_2 = new Vector<>();
private static void path_counter(Vector<Integer> chosen){
    Vector<Integer> v_left_after = new Vector<>();              //выбранные выборкой левые вершины добавляем сюда
    Vector<Integer> v_right_after = new Vector<>();             //выбранные выборкой левые вершины добавляем сюда
    for (Integer aChosen : chosen) {
        v_left_after.add(v_left.get(aChosen));
        v_right_after.add(v_right.get(aChosen));
    }
    int travel_1 = v_right_after.get(0) - v_left_after.get(0);
    int travel_2=0;
    int travel_3=0;
    int path_1;
    int path_2;
    int path_3;
    int path_4;
    if(v_right_after.get(0) < v_left_after.get(0)) {
        travel_1 = size + v_right_after.get(0) - v_left_after.get(0);
    }
    if(v_left_after.size()>1) {
        travel_2 = v_right_after.get(1) - v_left_after.get(1);
        if (v_right_after.get(1) < v_left_after.get(1)) {
            travel_2 = size + v_right_after.get(1) - v_left_after.get(1);
        }
    }
    if(v_left_after.size()>2) {
        travel_3 = v_left_after.get(2) - v_right_after.get(2);
        if (v_right_after.get(2) < v_left_after.get(2)) {
            travel_3 = size + v_right_after.get(2) - v_left_after.get(2);
        }
    }
    Vector<Integer> path_vector = new Vector<>();

    int a=0;
    int b=0;
    for(int i=1;i<8;){
            a = i % 3;
            b = (i / 3) % 3;
            i++;
                if(v_left_after.size()>1) {
                    if (!(a == b)) {
                        if (a != 2 && b != 2) {
                            path_1 = v_left_after.get(b) - v_right_after.get(a);
                            path_2 = size + v_left_after.get(b) - v_right_after.get(a);
                            path_vector.add(path_1);
                            path_vector.add(path_2);
                        }
                        if(v_left_after.size()>2) {
                            if (!(a == 1 && b == 0 || a == 0 && b == 1)) {
                                path_3 = v_left_after.get(b) - v_right_after.get(a);
                                path_4 = size + v_left_after.get(b) - v_right_after.get(a);
                                path_vector.add(path_3);
                                path_vector.add(path_4);
                            }
                        }
                    }
                }
    }
    Vector<Integer> travel_max_counter = new Vector<>();
    travel_keeper.add(travel_1);
    travel_keeper_1.add(travel_2);
    travel_keeper_2.add(travel_3);
    travel_max_counter.add(travel_1);
    travel_max_counter.add(travel_2);
    travel_max_counter.add(travel_3);
    int travel_max = 0;
    for(int i =0; i<2; i++){
        if(travel_max <travel_max_counter.get(i)){
            travel_max = travel_max_counter.get(i);
        }
    }
    int path_sum_1;
    int path_sum_2;
    int path_sum_3;
    int k = 0;
    int c = 0;
    Vector<Integer> path_sum_keeper = new Vector<>();
    if(v_left_after.size()>2) {
        for (int i = 0; i < 12; i++) {
            if (path_vector.get(i) < 13 && path_vector.get(i) > 1 && path_vector.get(i) % 2 == 1) {
                if (i == 0 || i == 1) {
                    k = 6;
                    c = 2;
                    b = 0;
                    a = 1;
                }
                if (i == 2 || i == 3) {
                    k = 10;
                    c = 1;
                    b = 0;
                    a = 2;
                }
                if (i == 4 || i == 5) {
                    k = 2;
                    c = 2;
                    b = 1;
                    a = 0;
                }
                if (i == 6 || i == 7) {
                    k = 8;
                    c = 0;
                    b = 1;
                    a = 2;
                }
                if (i == 8 || i == 9) {
                    k = 0;
                    c = 1;
                    b = 2;
                    a = 0;
                }
                if (i == 10 || i == 11) {
                    k = 4;
                    c = 0;
                    b = 2;
                    a = 1;
                }
                path_sum_1 = travel_max_counter.get(b) + path_vector.get(i) + travel_max_counter.get(a) + 24;
                path_sum_keeper.add(path_sum_1);
                for (int j = 0; j < 2; j++) {
                    if (path_vector.get(k) < 13 && path_vector.get(k) > 1 && path_vector.get(k) % 2 == 0) {
                        path_sum_2 = path_sum_1 + path_vector.get(k) + travel_max_counter.get(c) - 12;
                        path_sum_keeper.add(path_sum_2);
                    } else {
                        path_sum_keeper.add(0);
                    }
                    k++;
                }
            } else{
                path_sum_keeper.add(0);
                path_sum_keeper.add(0);
                path_sum_keeper.add(0);
            }
            if (path_vector.get(i) < 13 && path_vector.get(i) > 1 && path_vector.get(i) % 2 == 0) {
                if (i == 0 || i == 1) {
                    k = 6;
                    b = 0;
                    a = 1;
                }
                if (i == 2 || i == 3) {
                    k = 10;
                    b = 0;
                    a = 2;
                }
                if (i == 4 || i == 5) {
                    k = 2;
                    b = 1;
                    a = 0;
                }
                if (i == 6 || i == 7) {
                    k = 8;
                    b = 1;
                    a = 2;
                }
                if (i == 8 || i == 9) {
                    k = 0;
                    b = 2;
                    a = 0;
                }
                if (i == 10 || i == 11) {
                    k = 4;
                    b = 2;
                    a = 1;
                }
                path_sum_1 = travel_max_counter.get(b) + path_vector.get(i) + travel_max_counter.get(a) + 23;
                path_sum_keeper.add(path_sum_1);
            }else{
                path_sum_keeper.add(0);
            }
        }
    }
    if(v_left_after.size()==2){
            int p = 0;
            for (int i = 0; i < 4; i++) {
                if (i == 0 || i == 1) {
                    p = 2;
                    b = 0;
                    a = 1;
                }
                if (i == 2 || i == 3) {
                    p = 0;
                    b = 1;
                    a = 0;
                }
                if (path_vector.get(i) < 13 && path_vector.get(i) > 1 && path_vector.get(i) % 2 == 1) {
                    path_sum_1 = travel_max_counter.get(b) + path_vector.get(i) + travel_max_counter.get(a) + 24;
                    path_sum_keeper.add(path_sum_1);
                        if (path_vector.get(p) < 13 && path_vector.get(p) > 1 && path_vector.get(p) % 2 == 0) {
                            path_sum_3 = path_sum_1 + path_vector.get(p) + travel_max_counter.get(b)-12;
                            path_sum_keeper.add(path_sum_3);
                        } else {
                            path_sum_keeper.add(0);
                        }
                        p++;
                } else {
                    path_sum_keeper.add(0);
                    path_sum_keeper.add(0);
                }
            }
    }
    path_sum_keeper.add(travel_max +35);
    int path_sum = 0;
    for (Integer aPath_sum_keeper : path_sum_keeper) {
        if (path_sum < aPath_sum_keeper) {
            path_sum = aPath_sum_keeper;
        }
    }
    v_path.add(path_sum);
    int index_win = path_sum_keeper.indexOf(path_sum);
    path_sum_index.add(index_win);
    // блок нахождения максимального перемещения
    for (Integer aV_path : v_path)
        if (max < aV_path) {
            max = aV_path;
        }
}
    static void find() {
        size = v_right.get(0);
        v_right.remove(0);
        int num = v_left.size();
        int num1 = num+1;
        if(num1 > 3){
            num1=4;
        }
        for (int n = 1; n < num1; n++) {
            chosen.clear();
            for (int i = 0; i < n; i++) {
                chosen.add(i);
            }
            chosen_keeper.add(chosen.get(0));
            if(chosen.size()>1) {
                chosen_keeper_1.add(chosen.get(1));
            }else{
                chosen_keeper_1.add(-1);
            }
            if(chosen.size()>2) {
                chosen_keeper_2.add(chosen.get(2));
            }else{
                chosen_keeper_2.add(-1);
            }
            path_counter(chosen);
            for (; chosen.get(0) != num-1; ) {
                chosen.set(n - 1, chosen.get(n - 1)+1);
                if (chosen.get(n - 1) == num) {
                    if (n == 1) {
                        break;
                    } else {
                        for (int i = n - 2; i != -1; i--) {
                            if ((chosen.get(i + 1) == num)) {
                                chosen.set(i + 1, 0);
                                chosen.set(i, chosen.get(i) + 1);
                            }
                        }
                        chosen.set(n - 1, 0);
                    }
                }
                boolean accepted = true;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (j == i) continue;
                        if (chosen.get(i).equals(chosen.get(j))) accepted = false;
                    }
                }
                if (!accepted) continue;
                chosen_keeper.add(chosen.get(0));
                if(chosen.size()>1) {
                    chosen_keeper_1.add(chosen.get(1));
                }else{
                    chosen_keeper_1.add(-1);
                }
                if(chosen.size()>2) {
                    chosen_keeper_2.add(chosen.get(2));
                }else{
                    chosen_keeper_2.add(-1);
                }
                path_counter(chosen);
            }
        }
        index_max = path_sum_index.get(v_path.indexOf(max));
        chosen_get = chosen_keeper.get(v_path.indexOf(max));
        chosen_get_1 = chosen_keeper_1.get(v_path.indexOf(max));
        chosen_get_2 = chosen_keeper_2.get(v_path.indexOf(max));
        travel_get = travel_keeper.get(v_path.indexOf(max));
        travel_get_1 = travel_keeper_1.get(v_path.indexOf(max));
        travel_get_2 = travel_keeper_2.get(v_path.indexOf(max));
    }
}