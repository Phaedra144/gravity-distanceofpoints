/*
 * DistanceOfPoints
 *
 * 2018.11.21
 *
 * Bedi Szilvia
 */

package java.distance;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DistanceOfPoints {

    public static void main(String[] args) {
        Path input2Dim = Paths.get("assets/sample_input_2_8.tsv");
        Path input3Dim = Paths.get("assets/sample_input_3_1000.tsv");
        Path input4Dim = Paths.get("assets/sample_input_4_4.tsv");
        Path input10Dim = Paths.get("assets/sample_input_10_100.tsv");
        Path input100Dim = Paths.get("assets/sample_input_100_100.tsv");

        getClosestPoints(getFloatList(input2Dim));
    }

    private static void getClosestPoints(ArrayList<float[]> floatList) {
        float closestDistance = getDistance(floatList.get(0), floatList.get(1));
        float[] floatArray1 = floatList.get(0);
        float[] floatArray2 = floatList.get(1);
        int line1 = 0;
        int line2 = 0;

        for (int i = 1; i < floatList.size() - 1; i++) {
            for (int j = i + 1; j < floatList.size(); j++) {
                float temp = getDistance(floatList.get(i), floatList.get(j));
                if (temp < closestDistance) {
                    closestDistance = temp;
                    floatArray1 = floatList.get(i);
                    floatArray2 = floatList.get(j);
                    line1 = i + 1;
                    line2 = j + 1;
                }
            }
        }

        printResult(floatArray1, line1);
        printResult(floatArray2, line2);
    }

    public static float getDistance(float[] floats1, float[] floats2) {
        float result = 0;
        try {
            for (int i = 0; i < floats1.length; i++) {
                result += Math.pow(Math.abs(floats1[i] - floats2[i]), 2);
            }
        } catch (NullPointerException e) {
            System.out.println("One or two float array was missing.");
        }
        return (float) Math.sqrt(result);
    }

    private static void printResult(float[] floatArray1, int line1) {
        System.out.print(line1 + ":");
        for (float num : floatArray1) {
            System.out.print(Math.round(num) + "\t");
        }
        System.out.println();
    }

    public static ArrayList<float[]> getFloatList(Path filePath) {
        ArrayList<String> lines = readFile(filePath);
        ArrayList<float[]> points = new ArrayList<>();
        for (String line : lines) {
            String[] stringNumbers = line.split("\t");
            float[] numbers = new float[stringNumbers.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Float.parseFloat(stringNumbers[i]);
            }
            points.add(numbers);
        }
        return points;
    }

    private static ArrayList<String> readFile(Path filePath) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            lines = (ArrayList<String>) Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("Something went wrong with your file, "
                + "please check the path again!");
        }
        return lines;
    }
}
