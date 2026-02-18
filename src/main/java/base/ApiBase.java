package base;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ApiBase {
    protected static Properties prop;
    protected static RequestSpecification requestSpec;
       static {
               try {
                        FileInputStream fip=new FileInputStream("src/main/resources/config.properties");
                        prop=new Properties();
                        prop.load(fip);
                        RestAssured.baseURI = prop.getProperty("baseURL");
                    }
               catch (IOException e) {
                        throw new RuntimeException(e);
            }
        }
    }

