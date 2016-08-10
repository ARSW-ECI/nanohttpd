## NanoHTTPD – a tiny web server in Java

*NanoHTTPD* is a light-weight HTTP server designed for embedding in other applications, released under a Modified BSD licence.

It is being developed at Github and uses Apache Maven for builds & unit testing:

 * Build status: [![Build Status](https://api.travis-ci.org/NanoHttpd/nanohttpd.png)](https://travis-ci.org/NanoHttpd/nanohttpd)
 * Coverage Status: [![Coverage Status](https://coveralls.io/repos/NanoHttpd/nanohttpd/badge.svg)](https://coveralls.io/r/NanoHttpd/nanohttpd)
 * Current central released version: [![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.nanohttpd/nanohttpd/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.nanohttpd/nanohttpd)

## Quickstart

A sample HTTPD implementation is included in `webserver/src/main/java/com/example/App.java`:
```java
    package com.example;
    
    import java.io.IOException;
    import java.util.Map;
    
    import fi.iki.elonen.NanoHTTPD;
    
    public class App extends NanoHTTPD {
    
        public App() throws IOException {
            super(8080);
            start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
            System.out.println("\nRunning! Point your browsers to http://localhost:8080/ \n");
        }
    
        public static void main(String[] args) {
            try {
                new App();
            } catch (IOException ioe) {
                System.err.println("Couldn't start server:\n" + ioe);
            }
        }
    
        @Override
        public Response serve(IHTTPSession session) {
            String msg = "<html><body><h1>Hello server</h1>\n";
            Map<String, String> parms = session.getParms();
            
             msg += "<p>Hello, World!</p>";
            
            return newFixedLengthResponse(msg + "</body></html>\n");
        }
    }
```

To compile and run this server:
 
    mvn compile
    mvn exec:java -Dexec.mainClass="com.example.App" -Dexec.args="arg1"
    
If it started ok, point your browser at <http://localhost:8080/> and enjoy a web server that asks your name and replies with a greeting. 
