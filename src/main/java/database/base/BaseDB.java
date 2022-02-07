package database.base;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.List;

public abstract class BaseDB<T> {

    public abstract List<String> getObjectList();

    public abstract boolean addObject(T t);

    public abstract String getObject(long id);

    public MongoDatabase getConnection(){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        return mongoClient.getDatabase("Telegram");
    }
}
