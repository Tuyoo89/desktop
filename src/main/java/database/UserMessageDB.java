package database;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import database.base.BaseDB;
import model.UserMessage;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class UserMessageDB extends BaseDB<UserMessage> {

    @Override
    public List<String> getObjectList() {
        List<String> user_messageList = new ArrayList<>();
        MongoDatabase connection = getConnection();

        MongoCollection<Document> user_messages =
                connection.getCollection("user_message");

        for(Document doc: user_messages.find()){
            user_messageList.add(doc.toJson());
        }

        return user_messageList;
    }

    @Override
    public boolean addObject(UserMessage userMessage) {
        MongoDatabase connection = getConnection();
        MongoCollection<Document> userMessages = connection.getCollection("user_message");

        Document doc = new Document();

        doc.append("to_user", userMessage.getTo_user());
        doc.append("fr_user", userMessage.getFr_user());
        doc.append("text", userMessage.getText());
        doc.append("created_date", userMessage.getCreated_date());

        userMessages.insertOne(doc);

        return true;
    }

    @Override
    public String getObject(long id) {
        MongoDatabase connection = getConnection();
        MongoCollection<Document> userMessages = connection.getCollection("user_message");

        Document attachment = userMessages.find(Filters.eq("id", id)).first();

        assert attachment != null;
        return attachment.toJson();
    }


}
