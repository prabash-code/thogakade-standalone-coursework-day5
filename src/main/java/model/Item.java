package model;

import lombok.*;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Setter
@Getter

public class Item {
    private String itemCode;
    private String description;
    private String packSize;
    private double unitPrice;
    private int qty;
}
