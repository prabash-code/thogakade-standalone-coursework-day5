package model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetails {
    private String orderId;
    private String itemCode;
    private int qty;
    private int discount;
}
