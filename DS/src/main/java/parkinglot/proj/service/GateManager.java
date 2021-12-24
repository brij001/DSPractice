package parkinglot.proj.service;

import parkinglot.proj.domain.Gate;
import parkinglot.proj.domain.GateResolver;

public class GateManager {
    private GateResolver gateResolver;

    public Gate getGateDetails(String type, Integer number){
        return gateResolver.resolve(type).stream().filter(gate-> gate.getNumber()==number).findFirst().get();
    }



}
