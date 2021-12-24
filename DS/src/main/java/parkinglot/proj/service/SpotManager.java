package parkinglot.proj.service;

import parkinglot.proj.domain.Spot;
import parkinglot.proj.domain.SpotResolver;

import java.util.Optional;
import java.util.stream.Collectors;

public class SpotManager {
    SpotResolver spotResolver;

    public boolean isSpotAvailable(String type) {
        return !spotResolver.resolve(type).stream().filter(t -> t.isAvailable()).collect(Collectors.toList()).isEmpty();
    }

    public Spot reserveSpot(String type) {
        Optional<Spot> spotRes = spotResolver.resolve(type).stream().filter(t -> t.isAvailable()).findFirst();
        if (spotRes.isPresent()) {
            spotRes.get().setAvailable(false);
            // updating the map
            spotResolver.updateSpotOccupancy(spotRes.get());
        }
        return spotRes.get();
    }

    public void freeSpot(Spot spotId, String spotType) {
        Spot spotOptional = spotResolver.resolve(spotType).stream().filter(t -> t.getSpotId().equals(spotId)).findFirst().get();
        spotOptional.setAvailable(true);
        spotResolver.updateSpotOccupancy(spotOptional);
    }
}
