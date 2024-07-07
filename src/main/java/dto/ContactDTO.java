package dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder


public class ContactDTO {

    private String id;
    private String name;
    private  String lastname;
    private  String email;
    private  String phone;
    private  String address;
    private  String description;






}
