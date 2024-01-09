package id.vida.user.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User
{
    private String id;
    private String name;
    private String emailId;
    private String phoneNumber;
}
