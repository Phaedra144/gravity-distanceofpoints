import distance.DistanceOfPoints;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GetFloatListTest {

    ArrayList<float[]> floatListOfArrays;

    @BeforeEach
    void setUp() {
        floatListOfArrays = new ArrayList<>(Arrays.asList(new float[]{62.0f, 46.0f}, new float[]{1.0f, 12.0f}, new float[]{433.0f, 55.0f}));
    }

    @Test
    void getFloatListFirstElementOfFisrtArray() {
        assertEquals(62.0f, DistanceOfPoints.getFloatList(Paths.get("assets/sample.tsv")).get(0)[0]);
    }

    @Test
    void getFloatListFirstElementOfSecondArray() {
        ArrayList<float[]> floatListOfArrays = new ArrayList<>(Arrays.asList(new float[]{62.0f, 46.0f}, new float[]{1.0f, 12.0f}, new float[]{433.0f, 55.0f}));
        assertEquals(62.0f, DistanceOfPoints.getFloatList(Paths.get("assets/sample.tsv")).get(0)[0]);
    }

    @Test
    void getFloatListNoFile() {
        assertEquals(new ArrayList<>(), DistanceOfPoints.getFloatList(Paths.get("assets/sampleNull.tsv")));
    }
}