import java.util.ArrayList;
import java.util.List;

class CircularArrayPath {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java CircularArrayPath <n> <m>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        List<Integer> path = generateCircularArrayPath(n, m); // Генерация пути

        // Вывод пути
                for (int num : path) {
            System.out.print(num);
        }
    }

    public static List<Integer> generateCircularArrayPath(int n, int m) {
        List<Integer> path = new ArrayList<>(); // Массив для хранения начальных элементов интервалов
        int currentIndex = 0; // Текущий индекс в массиве path
        int currentElement = 1; // Текущий элемент кругового массива

        // Проходим по круговому массиву с шагом m и сохраняем начальные элементы интервалов в массиве path
        while (currentIndex < n) {
            // Добавляем текущий элемент кругового массива в путь
            path.add(currentElement);

            // Вычисляем следующий элемент кругового массива с учетом обертывания
            currentElement = (currentElement + m - 1) % n;
            if (currentElement == 0) currentElement = n;

            currentIndex++; // Переходим к следующему индексу в массиве path
        }

        return path;
    }
}
