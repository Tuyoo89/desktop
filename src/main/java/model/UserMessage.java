package model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserMessage {

    Document to_user;
    Document fr_user;
    String text;
    String created_date;

    public UserMessage(String text) {
        this.text = text;
        this.created_date = getDate();
    }

    private String getDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        return simpleDateFormat.format(date);
    }
}
