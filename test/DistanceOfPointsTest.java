import distance.DistanceOfPoints;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class DistanceOfPointsTest {

    @Test
    void getDistance2Dim() {
        assertEquals(3.605551242828369, DistanceOfPoints.getDistance(new float[]{2, 5}, new float[]{4, 8}));
    }

    @Test
    void getDistance3Dim() {
        assertEquals(4.690415859222412, DistanceOfPoints.getDistance(new float[]{2, 5, 4}, new float[]{4, 8, 1}));
    }

    @Test
    void getDistanceOneArrayIsZero() {
        assertEquals(6.7082037925720215, DistanceOfPoints.getDistance(new float[]{2, 5, 4}, new float[3]));
    }

    @Test
    void getDistanceTwoArrayAreZero() {
        assertEquals(0.0, DistanceOfPoints.getDistance(new float[3], new float[3]));
    }

    @Test
    void getDistanceNull() throws NullPointerException {
        assertEquals(0.0, DistanceOfPoints.getDistance(new float[]{2, 5, 4}, null));
    }
}