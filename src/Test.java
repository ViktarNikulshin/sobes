import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] arr = {3, 5, 0, 0, 1, 0, 2};
        int[] arr1 = {3, 5, 0, 0, 1, 0, 2};
        int x = arr.length - 1;
        for (int i = 0; i < x; ) {
            if (arr[i] == 0) {
                for (int j = i; j <= x - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[x] = 0;
                x--;
            } else {
                i++;
            }
        }
        System.out.println("--------Первый способ---------");
        System.out.println("-----------------");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("-----------------");

        changeArr(arr1, 0);
        System.out.println("------Второй способ (не докрутил через рекурсию) -----------");
        System.out.println("-----------------");
        for (int a : arr1) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println("-----------------");
        System.out.println("----Список users из файла-------------");
        System.out.println("-----------------");
        printCollectionUsers();

    }

    private static void changeArr(int[] arr, int i) {
        if (i < arr.length - 1) {
            changeArr(arr, i + 1);
            if (arr[i] == 0) {
                int x = arr[i + 1];
                arr[i] = x;
                arr[i + 1] = 0;
                if (x != 0) {
                    return;
                }
                changeArr(arr, i + 1);
            }
        }
    }

    private static void printCollectionUsers() {
        // необходимо прочитать файл из него получить  коллекцию пользователей.
        // вывести ее в консоль.

        try {
            File file = new File("src/users.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            List<User> users = new ArrayList<>();
            while (line != null) {
                User user = new User();
                user.setFirstName(line);
                user.setLastName(reader.readLine());
                user.setAge(Integer.parseInt(reader.readLine()));
                users.add(user);
                line = reader.readLine();
            }
            users.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
