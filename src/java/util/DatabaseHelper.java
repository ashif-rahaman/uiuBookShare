/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

/**
 *
 * @author ashif
 */
public class DatabaseHelper {

    public static MongoCursor<Document> getCursor(MongoCollection<Document> collection) {

        return collection.find().iterator();
    }

    public static Document getOne(MongoCollection<Document> collection) {

        return collection.find().first();
    }
}
