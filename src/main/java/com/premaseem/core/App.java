package com.premaseem.core;

import com.mongodb.*;

import java.util.Date;

/**
 * Java + MongoDB Crud operation example
 *
 */
public class App {
    public static void main(String[] args) {

        try {

            /**** Connect to MongoDB ****/
            // Since 2.10.0, uses MongoClient
            MongoClient mongo = new MongoClient("localhost", 27017);

            /**** Get database ****/
            // if database doesn't exists, MongoDB will create it for you
            DB db = mongo.getDB("testdb");

            /**** Get collection / table from 'testdb' ****/
            // if collection doesn't exists, MongoDB will create it for you
            DBCollection table = db.getCollection("user");

            /**** Insert ****/
            // create a document to store key and value
            BasicDBObject document = new BasicDBObject();
            document.put("name", "premaseem");
            document.put("age", 30);
            document.put("createdDate", new Date());
            table.insert(document);

            /**** Find and display ****/
            BasicDBObject searchQuery = new BasicDBObject();
            searchQuery.put("name", "premaseem");

            DBCursor cursor = table.find(searchQuery);

            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }

            /**** Update ****/
            // search document where name="premaseem" and update it with new values
            BasicDBObject query = new BasicDBObject();
            query.put("name", "premaseem");

            BasicDBObject newDocument = new BasicDBObject();
            newDocument.put("name", "premaseem-updated");

            BasicDBObject updateObj = new BasicDBObject();
            updateObj.put("$set", newDocument);

            table.update(query, updateObj);

            /**** Find and display ****/
            BasicDBObject searchQuery2
                    = new BasicDBObject().append("name", "premaseem-updated");

            DBCursor cursor2 = table.find(searchQuery2);

            while (cursor2.hasNext()) {
                System.out.println(cursor2.next());
            }

            /**** Done ****/
            System.out.println("Done");

        }  catch (MongoException e) {
            e.printStackTrace();
        }

    }
}