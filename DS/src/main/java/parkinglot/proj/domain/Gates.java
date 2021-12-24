package parkinglot.proj.domain;

import java.util.List;
import java.util.Map;

public class Gates {
    Map<String, List<Gate>> map; // Type,Gate

    public Map<String, List<Gate>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<Gate>> map) {
        this.map = map;
    }
}
