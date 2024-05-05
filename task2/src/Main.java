import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class CirclePosition {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java CirclePosition circle.txt points.txt");
            return;
        }

        String circleFile = args[0];
        String pointsFile = args[1];

        try {
            // Считываем координаты центра и радиус окружности из файла
            BufferedReader circleReader = new BufferedReader(new FileReader(circleFile));
            String[] circleCoords = circleReader.readLine().split(" ");
            double centerX = Double.parseDouble(circleCoords[0]);
            double centerY = Double.parseDouble(circleCoords[1]);
            double radius = Double.parseDouble(circleReader.readLine());
            circleReader.close();

            // Считываем координаты точек из файла и вычисляем их положение относительно окружности
            BufferedReader pointsReader = new BufferedReader(new FileReader(pointsFile));
            String line;
            while ((line = pointsReader.readLine()) != null) {
                String[] pointCoords = line.split(" ");
                double pointX = Double.parseDouble(pointCoords[0]);
                double pointY = Double.parseDouble(pointCoords[1]);

                double distance = Math.sqrt(Math.pow(pointX - centerX, 2) + Math.pow(pointY - centerY, 2));
                int position = getPosition(distance, radius);
                System.out.println(position);
            }
            pointsReader.close();
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Метод для определения положения точки относительно окружности
    private static int getPosition(double distance, double radius) {
        if (Math.abs(distance - radius) < 1e-9) { // Проверка на равенство с учетом погрешности
            return 0; // Точка лежит на окружности
        } else if (distance < radius) {
            return 1; // Точка внутри окружности
        } else {
            return 2; // Точка снаружи окружности
        }
    }
}
