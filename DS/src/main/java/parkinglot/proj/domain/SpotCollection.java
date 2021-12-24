package parkinglot.proj.domain;

import java.util.List;
import java.util.Map;

public class SpotCollection {
  Map<String,List<Spot>> spotMap;

  public Map<String, List<Spot>> getSpotMap() {
    return spotMap;
  }

  public void setSpotMap(Map<String, List<Spot>> spotMap) {
    this.spotMap = spotMap;
  }
}
