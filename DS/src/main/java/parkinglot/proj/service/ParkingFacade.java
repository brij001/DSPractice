package parkinglot.proj.service;

import design.parkinglot.model.Payment.PaymentManager;
import parkinglot.proj.domain.Gate;
import parkinglot.proj.domain.Spot;

public class ParkingFacade {

    SpotManager spotManager;
    PaymentManager paymentManager;
    // TicketManager

   public boolean isAvailable(Spot spot){
       return spotManager.isSpotAvailable(spot.getSpotType());
   }

   public void bookticket(Spot spot){
       if(isAvailable(spot)){

       }

       //paymentManager.deductMoney(50);

   }

   public void exitVehicle(){
       collectPayment();
       // freeSpot();
   }
   public void collectPayment(){
       // int amnt = paymentService.getPayment(Ticket ticket, Date inTime, Date outTime);
       //paymentManager.deductMoney(50, PaymentType type);
   }

   @Override
   public boolean equals(Object obj) {
        return false;
   }
}
