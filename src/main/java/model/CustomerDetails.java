package model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class CustomerDetails {
    private String  id;
    private String title;
    private String name;
    private String date;
    private String address;
    private double salary;
    private String city;
    private String province;
    private int postalcode;


}
