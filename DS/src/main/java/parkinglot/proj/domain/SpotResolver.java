package parkinglot.proj.domain;

import java.util.List;

public class SpotResolver {
    SpotCollection spotCollection;

    public List<Spot> resolve(String type){
        return spotCollection.getSpotMap().get(type);
    }

    public void updateSpotOccupancy(Spot spot){
        List<Spot> spots = spotCollection.getSpotMap().get(spot.getSpotType());
        spots.remove(spot); // or remove by iteration and matching ID
        spots.add(spot);
        spotCollection.getSpotMap().put(spot.getSpotType(), spots);
    }

}
