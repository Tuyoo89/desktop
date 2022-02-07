package model.base;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class BaseModel {
    long id;
}
