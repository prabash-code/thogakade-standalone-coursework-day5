package model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Orders {
    private String orderId;
    private String date;
    private String custId;

}
