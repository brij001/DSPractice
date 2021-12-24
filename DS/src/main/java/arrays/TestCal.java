package arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TestCal {

    public static void main(String ...s ){




         System.out.println(data());

    }

    public static List<Object[]> data() {
        Object[][] data = new Object[][] { { 1 , 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
        return Arrays.asList(data);
    }
}
