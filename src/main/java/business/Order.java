package business;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Order implements Serializable {
    private int orderId;
    private int clientId;
    private LocalDateTime orderTime;
    public static DeliveryService deliveryService;
    public static UserService userService;

    public Order(int orderId, int clientId, LocalDateTime orderTime) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.orderTime = orderTime;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Order)) {
            return false;
        }

        Order order=(Order)o;



        return orderId==order.getOrderId();


    }

    public int hashCode() {
        return orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public String toString(){
        String string="Order"+orderId+", user "+userService.findById(clientId)+", items:{ ";
        List<MenuItem> items=(List<MenuItem>) (Object)deliveryService.getOrders().get(this);
        for(MenuItem item: items){
            string+=item.getTitle()+", ";
        }
        string=string.substring(0,string.length()-2);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        string+="}, time "+orderTime.format(format);
        return string;
    }

    public int getClientId() {
        return clientId;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }
}
