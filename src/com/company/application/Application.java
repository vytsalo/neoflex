package com.company.application;

import com.company.HTTPServer.ServerUtils;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import static com.company.HTTPServer.ServerUtils.startServer;

public class Application {


    public static void main(String[] args) throws IOException {

        HttpServer server= startServer();
        ServerUtils.getAllRecords(server);
        ServerUtils.getById(server);

    }
}