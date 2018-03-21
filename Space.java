package MONOPOLIA;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;
import static MONOPOLIA.Huh.find;
import static MONOPOLIA.Huh.max;
import static MONOPOLIA.Huh.index_max;
import static MONOPOLIA.Huh.chosen_get;
import static MONOPOLIA.Huh.chosen_get_1;
import static MONOPOLIA.Huh.chosen_get_2;
import static MONOPOLIA.Huh.travel_get;
import static MONOPOLIA.Huh.travel_get_1;
import static MONOPOLIA.Huh.travel_get_2;
import static MONOPOLIA.Huh.size;
public class Space {
    static Vector<Integer> v_left = new Vector<>();                        //храним считанные левые вершины
    static Vector<Integer> v_right = new Vector<>();                       //храним считанные правые вершины
    private static void error(String t2) {
        try (FileWriter writer = new FileWriter(t2, false)) {
            // запись всей строки
            String text = "ERROR";
            writer.write(text);
            writer.flush();
        } catch (IOException ignored) {
        }
        System.exit(0);
    }
    private static void read(String t1, String t2) throws FileNotFoundException { //функция считывания и распределения строк по записанной информации
try{        Scanner sc = new Scanner(new FileReader(t1));

        String str;
        String cmd = "from";
        String rmb_cmd = "";
        sc.useDelimiter("[,\n()]");

        while (true) {
            try {
                str = sc.next();
            } catch (NoSuchElementException E) {
                break;
            }

            try {
                int parser = Integer.parseInt(str);                      //переменная, в которой храним считываемые инты
            } catch (NumberFormatException E) {
                char b = str.charAt(str.length() - 1);
                boolean c = Character.isLetter(b);

                if (c) {
                    rmb_cmd = str;
                }
            }

            if (cmd.equals(rmb_cmd)) {
                v_left.add(sc.nextInt());
            }

            if (sc.hasNextInt()) {
                v_right.add(sc.nextInt());
            }
        }//конец считывающего цикла
        for (int i = 1; i < v_left.size(); i++) {

            if (v_right.get(0) < v_left.get(i)) {
                error(t2);
            }
            if (v_right.get(0) < v_right.get(i)) {
                error(t2);
            }

        }
        try {
            int check = v_right.get(0);
            for(int i=0;i<v_left.size();i++){
                if(check < v_right.get(i)){
                    error(t2);
                }
                if(check < v_left.get(i)){
                    error(t2);
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException E){
            error(t2);
        }
}
    catch (ArrayIndexOutOfBoundsException E){
    error(t2);
}
    }
    private static void answer(String t2) {
        int travel_again = travel_get;
        int travel_again_1 = travel_get_1;
        int travel_again_2 = travel_get_2;
        int victory_number = 1;
        int v_left_get = v_left.get(chosen_get);
        int v_left_get_1 = 0;
        int v_left_get_2 = 0;
        int v_right_get_1 = 0;
        int v_right_get_2 = 0;
        if (chosen_get_1 > -1) {
            v_left_get_1 = v_left.get(chosen_get_1);
            victory_number = 2;
        }
        if (chosen_get_2 > -1) {
            v_left_get_2 = v_left.get(chosen_get_2);
            victory_number = 3;
        }
        int v_right_get = v_right.get(chosen_get);
        if (chosen_get_1 != -1) {
            v_right_get_1 = v_right.get(chosen_get_1);
        }
        if (chosen_get_2 != -1) {
            v_right_get_2 = v_right.get(chosen_get_2);
        }
        if (victory_number == 1) {
            try (FileWriter writer = new FileWriter(t2, false)) {
                writer.write("Старт: " + (v_left_get - 12) + " Кубики: " + 35 + "(12+12+11)" + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")") + " Наибольший путь: " + max);
                writer.flush();
            } catch (IOException ignored) {
            }
        }
        if (victory_number == 2) {
            if (index_max == 0) {
                int over_left_1 = v_left_get_1;
                if (v_left_get_1 < 24) {
                    over_left_1 = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left_1 - 24) + " Кубики: " + (v_left_get - v_right_get_1 + 24)+ "(" + (v_left_get - v_right_get_1) + " + 12+12" + ")" + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + travel_again + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + travel_again_1 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 1) {
                int over_left_1 = v_left_get_1;
                if (v_left_get_1 < 12) {
                    over_left_1 = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left_1 - 12) + " Кубики: " + (v_left_get - v_right_get_1+v_left_get_1 - v_right_get + 12) + "("+(v_left_get_1 - v_right_get) +" + "+ (v_left_get - v_right_get_1) + " + 12" + ")" + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + travel_again + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + travel_again_1 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 2) {
                int over_left_1 = v_left_get_1;
                if (v_left_get_1 < 24) {
                    over_left_1 = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left_1 - 24) + " Кубики: " + (v_left_get - v_right_get_1 + 24)+ "(" + (v_left_get - v_right_get_1) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + travel_again + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + travel_again_1 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 4) {
                int over_left = v_left_get;
                if (v_left_get < 24) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 24) + " Кубики: " + (v_left_get_1 - v_right_get + 24)+ "(" + (v_left_get_1 - v_right_get) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + travel_again + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + travel_again_1 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 6) {
                int over_left = v_left_get;
                if (v_left_get < 24) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 24) + " Кубики: " + (v_left_get_1 - v_right_get + 24)+ "(" + (v_left_get_1 - v_right_get) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + travel_again + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + travel_again_1 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 5) {
                int over_left = v_left_get;
                if (v_left_get < 24) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) + " Кубики: " + (v_left_get_1 - v_right_get+v_left_get - v_right_get_1 + 12) + "(" + (v_left_get_1 - v_right_get)+" + "+(v_left_get - v_right_get_1) + " + 12" + ")" + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + travel_again + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + travel_again_1 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 8) {
                int over_left = v_left_get;
                if (v_left_get < 24) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) + " Кубики: " + 35 + "(12+12+11)" + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
        }
        if (victory_number == 3) {
            if (index_max == 0) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 24) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 24) +" Кубики: " + (v_left_get - v_right_get_1 + 24)+ "(" + (v_left_get - v_right_get_1) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + travel_again + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + travel_again_1 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 4) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 24) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 24) +" Кубики: " + (size+v_left_get - v_right_get_1 + 24)+ "(" + (v_left_get - v_right_get_1) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + travel_again + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + travel_again_1 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 8) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 24) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 24) +" Кубики: " + (v_left_get - v_right_get_2 + 24)+ "(" + (v_left_get - v_right_get_2) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + travel_again + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + travel_again_2 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 12) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 24) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 24) +" Кубики: " + (size+v_left_get - v_right_get_2 + 24)+ "(" + (v_left_get - v_right_get_2) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + travel_again + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + travel_again_2 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 16) {
                int over_left = v_left_get;
                if (v_left_get < 24) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 24) +" Кубики: " + (v_left_get_1 - v_right_get + 24)+ "(" + (v_left_get_1 - v_right_get) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + travel_again + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + travel_again_1 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 20) {
                int over_left = v_left_get;
                if (v_left_get < 24) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 24) +" Кубики: " + (size+v_left_get_1 - v_right_get + 24)+ "(" + (v_left_get_1 - v_right_get) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + travel_again + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + travel_again_1 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 24) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 24) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 24) +" Кубики: " + (v_left_get_1 - v_right_get_2 + 24)+ "(" + (v_left_get_1 - v_right_get_2) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get_1 + " " + v_right_get_1 + "](" + travel_again_1 + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + travel_again_2 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 28) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 24) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 24) +" Кубики: " + (size+v_left_get_1 - v_right_get_2 + 24)+ "(" + (v_left_get_1 - v_right_get_2) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get_1 + " " + v_right_get_1 + "](" + travel_again_1 + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + travel_again_2 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 32) {
                int over_left = v_left_get;
                if (v_left_get < 24) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 24) +" Кубики: " + (v_left_get_2 - v_right_get + 24)+ "(" + (v_left_get_2 - v_right_get) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + travel_again + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + travel_again_2 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 36) {
                int over_left = v_left_get;
                if (v_left_get < 24) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 24) +" Кубики: " + (size+v_left_get_2 - v_right_get + 24)+ "(" + (v_left_get_2 - v_right_get) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + travel_again + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + travel_again_2 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 40) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 24) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 24) +" Кубики: " + (v_left_get_2 - v_right_get_1 + 24)+ "(" + (v_left_get_2 - v_right_get_1) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get_1 + " " + v_right_get_1 + "](" + travel_again_1 + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + travel_again_2 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 44) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 24) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 24) +" Кубики: " + (size+v_left_get_2 - v_right_get_1 + 24)+ "(" + (v_left_get_2 - v_right_get_1) + " + 12+12" + ")"  + " Перемещения: " + ("[" + v_left_get_1 + " " + v_right_get_1 + "](" + travel_again_1 + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + travel_again_2 + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 1) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 12) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get - v_right_get_1 + v_left_get_1 - v_right_get_2 + 12)+ "(" + (v_left_get - v_right_get_1)+" "+(v_left_get_1 - v_right_get_2) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 2) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 12) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get - v_right_get_1 + size + v_left_get_1 - v_right_get_2 + 12)+ "(" + (v_left_get - v_right_get_1)+" "+(v_left_get_1 - v_right_get_2) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 5) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 12) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get - v_right_get_1 + v_left_get_1 - v_right_get_2 + 12)+ "(" + (v_left_get - v_right_get_1)+" "+(v_left_get_1 - v_right_get_2) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 6) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 12) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get - v_right_get_1 + size+v_left_get_1 - v_right_get_2 + 12)+ "(" + (v_left_get - v_right_get_1)+" "+(v_left_get_1 - v_right_get_2) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 9) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 12) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get - v_right_get_2 + v_left_get_2 - v_right_get_1 + 12)+ "(" + (v_left_get - v_right_get_2)+" "+(v_left_get_2 - v_right_get_1) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 10) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 12) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get - v_right_get_2 + size+v_left_get_2 - v_right_get_1 + 12)+ "(" + (v_left_get - v_right_get_2)+" "+(v_left_get_2 - v_right_get_1) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 13) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 12) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get - v_right_get_2 + v_left_get_2 - v_right_get_1 + 12)+ "(" + (v_left_get - v_right_get_2)+" "+(v_left_get_2 - v_right_get_1) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 14) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 12) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get - v_right_get_2 + size+ v_left_get_2 - v_right_get_1 + 12)+ "(" + (v_left_get - v_right_get_2)+" "+(v_left_get_2 - v_right_get_1) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 17) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 12) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_1 - v_right_get + v_left_get - v_right_get_2 + 12)+ "(" + (v_left_get_1 - v_right_get)+" "+(v_left_get - v_right_get_2) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 18) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 12) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_1 - v_right_get + size+v_left_get - v_right_get_2 + 12)+ "(" + (v_left_get_1 - v_right_get)+" "+(v_left_get - v_right_get_2) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 21) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 12) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get_1 - v_right_get + v_left_get - v_right_get_2 + 12)+ "(" + (v_left_get_1 - v_right_get)+" "+(v_left_get - v_right_get_2) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 22) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 12) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get_1 - v_right_get + size+v_left_get - v_right_get_2 + 12)+ "(" + (v_left_get_1 - v_right_get)+" "+(v_left_get - v_right_get_2) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 25) {
                int over_left = v_left_get;
                if (v_left_get < 12) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_1 - v_right_get_2 + v_left_get_2 - v_right_get + 12)+ "(" + (v_left_get_1 - v_right_get_2)+" "+(v_left_get_2 - v_right_get) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 26) {
                int over_left = v_left_get;
                if (v_left_get < 12) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_1 - v_right_get_2 + size+v_left_get_2 - v_right_get + 12)+ "(" + (v_left_get_1 - v_right_get_2)+" "+(v_left_get_2 - v_right_get) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 29) {
                int over_left = v_left_get;
                if (v_left_get < 12) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get_1 - v_right_get_2 + v_left_get_2 - v_right_get + 12)+ "(" + (v_left_get_1 - v_right_get_2)+" "+(v_left_get_2 - v_right_get) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 30) {
                int over_left = v_left_get;
                if (v_left_get < 12) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get_1 - v_right_get_2 + size+v_left_get_2 - v_right_get + 12)+ "(" + (v_left_get_1 - v_right_get_2)+" "+(v_left_get_2 - v_right_get) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 33) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 12) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_2 - v_right_get + v_left_get - v_right_get_1 + 12)+ "(" + (v_left_get_2 - v_right_get)+" "+(v_left_get - v_right_get_1) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 34) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 12) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get_2 - v_right_get + v_left_get - v_right_get_1 + 12)+ "(" + (v_left_get_2 - v_right_get)+" "+(v_left_get - v_right_get_1) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 37) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 12) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_2 - v_right_get +size+ v_left_get - v_right_get_1 + 12)+ "(" + (v_left_get_2 - v_right_get)+" "+(v_left_get - v_right_get_1) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 38) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 12) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_2 - v_right_get +size+ v_left_get - v_right_get_1 + 12)+ "(" + (v_left_get_2 - v_right_get)+" "+(v_left_get - v_right_get_1) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 41) {
                int over_left = v_left_get;
                if (v_left_get < 12) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_2 - v_right_get_1 + v_left_get_1 - v_right_get + 12)+ "(" + (v_left_get_2 - v_right_get_1)+" "+(v_left_get_1 - v_right_get) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 42) {
                int over_left = v_left_get;
                if (v_left_get < 12) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_2 - v_right_get_1 + size+v_left_get_1 - v_right_get + 12)+ "(" + (v_left_get_2 - v_right_get_1)+" "+(v_left_get_1 - v_right_get) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 45) {
                int over_left = v_left_get;
                if (v_left_get < 12) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_2 - v_right_get_1 + v_left_get_1 - v_right_get + 12)+ "(" + (v_left_get_2 - v_right_get_1)+" "+(v_left_get_1 - v_right_get) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 46) {
                int over_left = v_left_get;
                if (v_left_get < 12) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_2 - v_right_get_1 +size+ v_left_get_1 - v_right_get + 12)+ "(" + (v_left_get_2 - v_right_get_1)+" "+(v_left_get_1 - v_right_get) + " + 12" + ")"+ " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 3) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 12) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get - v_right_get_1 + 23)+ "(" + (v_left_get - v_right_get_1) + " + 12+11" + ")" + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 7) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 12) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get - v_right_get_1 + 23)+ "(" + (v_left_get - v_right_get_1) + " + 12+11" + ")" + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 11) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 12) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get - v_right_get_2 + 23)+ "(" + (v_left_get - v_right_get_2) + " + 12+11" + ")" + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 15) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 12) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get - v_right_get_2 + 23)+ "(" + (v_left_get - v_right_get_2) + " + 12+11" + ")" + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 19) {
                int over_left = v_left_get;
                if (v_left_get < 12) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_1 - v_right_get + 23)+ "(" + (v_left_get - v_right_get_1) + " + 12+11" + ")" + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 23) {
                int over_left = v_left_get;
                if (v_left_get < 12) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get_1 - v_right_get + 23)+ "(" + (v_left_get - v_right_get_1) + " + 12+11" + ")" + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 27) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 12) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_1 - v_right_get_2 + 23)+ "(" + (v_left_get_1 - v_right_get_2) + " + 12+11" + ")" + " Перемещения: " + ("[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 31) {
                int over_left = v_left_get_2;
                if (v_left_get_2 < 12) {
                    over_left = size + v_left_get_2;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get_1 - v_right_get_2 + 23)+ "(" + (v_left_get_1 - v_right_get_2) + " + 12+11" + ")" + " Перемещения: " + ("[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 35) {
                int over_left = v_left_get;
                if (v_left_get < 12) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_2 - v_right_get + 23)+ "(" + (v_left_get_2 - v_right_get) + " + 12+11" + ")" + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 39) {
                int over_left = v_left_get;
                if (v_left_get < 12) {
                    over_left = size + v_left_get;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get_2 - v_right_get + 23)+ "(" + (v_left_get_2 - v_right_get) + " + 12+11" + ")" + " Перемещения: " + ("[" + v_left_get + " " + v_right_get + "](" + (travel_again) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 43) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 12) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (v_left_get_2 - v_right_get_1 + 23)+ "(" + (v_left_get_2 - v_right_get_1) + " + 12+11" + ")" + " Перемещения: " + ("[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
            if (index_max == 47) {
                int over_left = v_left_get_1;
                if (v_left_get_1 < 12) {
                    over_left = size + v_left_get_1;
                }
                try (FileWriter writer = new FileWriter(t2, false)) {
                    writer.write("Старт: " + (over_left - 12) +" Кубики: " + (size+v_left_get_2 - v_right_get_1 + 23)+ "(" + (v_left_get_2 - v_right_get_1) + " + 12+11" + ")" + " Перемещения: " + ("[" + v_left_get_1 + " " + v_right_get_1 + "](" + (travel_again_1) + ")" + "[" + v_left_get_2 + " " + v_right_get_2 + "](" + (travel_again_2) + ")") + " Наибольший путь: " + max);
                    writer.flush();
                } catch (IOException ignored) {
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        read(args[0],args[1]);
        find();
        answer(args[1]);
    }
}