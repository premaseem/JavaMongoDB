package com.premaseem.core;

import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        MongoClient mongo = new MongoClient( "localhost" , 27017 );
    }
}
