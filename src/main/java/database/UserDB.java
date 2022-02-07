package database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import database.base.BaseDB;
import model.User;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class UserDB extends BaseDB<User> {

    @Override
    public List<String> getObjectList() {
        List<String> userList = new ArrayList<>();
        MongoDatabase connection = getConnection();

        MongoCollection<Document> users =
                connection.getCollection("users");

        for(Document doc: users.find()){
            userList.add(doc.toJson());
        }

        return userList;
    }

    @Override
    public boolean addObject(User user) {
        MongoDatabase connection = getConnection();
        MongoCollection<Document> users = connection.getCollection("users");

        Document document = users.find(Filters.eq("phone_number", user.getPhone_number())).first();
        if(document != null)
            return false;

        Document doc = new Document();

        doc.append("username", user.getUsername());
        doc.append("phone_number", user.getPhone_number());
        doc.append("about", user.getAbout());
        doc.append("created_date", user.getCreated_date());

        users.insertOne(doc);

        return true;
    }

    @Override
    public String getObject(long id) {
        MongoDatabase connection = getConnection();
        MongoCollection<Document> users = connection.getCollection("users");

        Document user = users.find(Filters.eq("id", id)).first();

        assert user != null;
        return user.toJson();
    }

    public String getByPhoneNum(String phone_number){
        MongoDatabase connection = getConnection();
        MongoCollection<Document> users = connection.getCollection("users");

        Document user = users.find(Filters.eq("phone_number", phone_number)).first();

        if(user == null){
            return "";
        }
        return user.toJson();
    }

}
