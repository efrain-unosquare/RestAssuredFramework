package org.example.spotify.builder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.example.spotify.api.routes.ApiRoutes.BASE_PATH;

public class SpecBuilder {

    /**
     * if we want to run the test from command line use the below
     *
     * mvn test -DBASE_URI="https://api.spotify.com" -DACCOUNT_BASE_URI="https://accounts.spotify.com"
     *
     * or
     * from the IDE add the parameters here:
     * Go to RUN > Edit Configurations > Templates or TestNG > VM options
     *
     * Parameters:
     * -DBASE_URI="https://api.spotify.com" -DACCOUNT_BASE_URI="https://accounts.spotify.com"
     *
     * Note: the VM parameters already have "-ea" parameter on VM options just add the previous parameters
     * or if you don't want to do it just comment this line: .setBaseUri(System.getProperty("BASE_URI"))
     * and uncomment the commented line.
     */

    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder()
                .setBaseUri(System.getProperty("BASE_URI"))
                //.setBaseUri("https://api.spotify.com")
                .setBasePath(BASE_PATH)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL).build();
    }

    public static RequestSpecification getAccountRequestSpecToken(){
        return new RequestSpecBuilder()
                .setBaseUri(System.getProperty("ACCOUNT_BASE_URI"))
                //.setBaseUri("https://accounts.spotify.com")
                .setContentType(ContentType.URLENC)
                .log(LogDetail.ALL).build();
    }

    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().log(LogDetail.ALL).build();
    }
}
