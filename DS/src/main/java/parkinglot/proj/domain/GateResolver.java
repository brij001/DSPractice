package parkinglot.proj.domain;

import java.util.List;

public class GateResolver {
    Gates gates;

    public List<Gate> resolve(String gateType){
        return gates.getMap().get(gateType);
    }
}
