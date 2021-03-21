package com.company.HTTPServer;

import com.company.service.UserService;
import com.company.service.impl.UserServiceImpl;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.BindException;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class ServerUtils {


    private static int port;

    public static int getPort() {
        return port;
    }


    private static UserService userService = new UserServiceImpl();

    public UserService getUserService() {
        return userService;
    }



    public ServerUtils(int port) {
        this.port=port;
    }


    public static HttpServer startServer() throws IOException {

        System.out.println("Введите порт:");

        String portString = new Scanner(System.in).nextLine();

        int port=0;

        HttpServer server=null;

        try {
            port = Integer.parseInt(portString);

            server = HttpServer.create(new InetSocketAddress(port), 0);



        } catch (IllegalArgumentException e){

            System.out.println("Номер порта должен быть целым числом от 0 до 65535");

            startServer();

        } catch (BindException bindException){
            System.out.println("Такой порт уже занят введите другой");
            startServer();

        }

        System.out.println("Сервер успешно запущен");

        return server;

    }

    //
    public static void getAllRecords(HttpServer server) {

        server.createContext("/api/getall", (exchange -> {

            String respText = userService.getList().toString();

            exchange.getResponseHeaders().set("Content-Type", "application/json");

            exchange.sendResponseHeaders(200, respText.getBytes().length);


            OutputStream output = exchange.getResponseBody();
            output.write(respText.getBytes());
            output.flush();
            exchange.close();
        }));
    }


    //GET USER BY ID
    public static void getById(HttpServer server) {

        server.createContext("/api/get", (exchange -> {

            String respText = "";

            String param = exchange.getRequestURI().getQuery();

            if (!param.isEmpty()){

                try {

                    Integer id = Integer.parseInt(param.substring(param.indexOf("=")+1,param.length()));

                    respText = "get by id=" + id;

                    exchange.getResponseHeaders().set("Content-Type", "application/json");

                    exchange.sendResponseHeaders(200, respText.getBytes().length);


                } catch (IllegalArgumentException e){
                    exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=" + "UTF-8");

                    respText = "Введено неверное значение";
                    exchange.sendResponseHeaders(422, respText.getBytes().length);

                }

            }

            OutputStream output = exchange.getResponseBody();
            output.write(respText.getBytes());
            output.flush();
            exchange.close();
        }));

    }


}