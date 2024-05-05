import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class MinMoves {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java MinMoves input.txt");
            return;
        }

        String inputFile = args[0];

        try {
            // Чтение данных из файла
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line;
            int[] nums = new int[100]; // Предполагаем, что не более 100 чисел в файле
            int count = 0;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line);
                nums[count++] = num;
            }
            reader.close();

            // Усекаем массив до реального размера
            nums = Arrays.copyOf(nums, count);

            // Сортируем массив для нахождения медианы
            Arrays.sort(nums);

            // Находим медиану
            int median;
            if (count % 2 == 0) {
                median = (nums[count / 2 - 1] + nums[count / 2]) / 2;
            } else {
                median = nums[count / 2];
            }

            // Находим количество ходов для каждого числа
            int moves = 0;
            for (int num : nums) {
                moves += Math.abs(num - median);
            }

            System.out.println(moves);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}
