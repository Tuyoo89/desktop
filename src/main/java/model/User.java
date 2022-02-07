package model;


import lombok.*;
import lombok.experimental.FieldDefaults;
import model.base.BaseModel;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class User extends BaseModel {

    String username;
    String phone_number;
    String about;
    Document attachment;
    String created_date;

    public User(String username, String phone_number, String about) {
        this.username = username;
        this.phone_number = phone_number;
        this.about = about;
        this.created_date = getDate();
    }

    private String getDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return simpleDateFormat.format(date);
    }

}
