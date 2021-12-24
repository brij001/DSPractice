package parkinglot.proj.service;

import parkinglot.proj.domain.Gate;
import parkinglot.proj.domain.Spot;
import parkinglot.proj.domain.Ticket;

import java.util.Date;

public class TicketManager {
    Ticket ticket;
    GateManager gateManager;
    SpotManager spotManager;

    public void bookTicket(String gateType, Integer gateId, String vehicleType){

        if(spotManager.isSpotAvailable(vehicleType)){
            Spot spot = spotManager.reserveSpot(vehicleType);
            Gate gate = gateManager.getGateDetails(gateType, gateId);
            Date dEntry = new Date();
            Ticket t = new Ticket();
            t.setTicketId(123); t.setEntryTime(dEntry); t.setSpotId(spot.getSpotId());t.setVehicalNumber("VEHICLE Number");
        }
    }

}
