/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.net.ConnectException;
import java.rmi.UnknownHostException;
import org.bson.Document;

/**
 *
 * @author ashif
 */
public class ConnectToDatabase {

    private static MongoClient connection;
    private static MongoDatabase database;
    private static ConnectToDatabase instance;

    private static final String HOST = "localhost";
    private static final int PORT = 27017;

    public static ConnectToDatabase getConnection(String databaseName)
            throws UnknownHostException, ConnectException {

        if (instance == null) {

            instance = new ConnectToDatabase(HOST, PORT, databaseName);
        }
        return instance;
    }

    public static ConnectToDatabase getConnection(String host, int port, String databaseName)
            throws UnknownHostException, ConnectException {

        if (instance == null) {

            instance = new ConnectToDatabase(host, port, databaseName);
        }
        return instance;
    }

    private MongoCollection<Document> collection;

    private ConnectToDatabase(String host, Integer port, String databaseName) {

        try {

            connection = new MongoClient(host, port);
            database = connection.getDatabase(databaseName);
        } catch (Exception e) {

            System.err.println(e.toString());
        }
    }

    public MongoCollection<Document> getCollection(String collectionName) {

        collection = database.getCollection(collectionName);
        return collection;
    }
}
