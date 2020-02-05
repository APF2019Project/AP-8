//package server;
//
//import model.entity.Account;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.Scanner;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import static controller.Main.covertCardsToJsonString;
//
//public class Server {
//    public static void main(String[] args) throws Exception {
//        try (ServerSocket listener = new ServerSocket(5000)) {
//            ExecutorService pool = Executors.newFixedThreadPool(20);
//            while (true) {
//                pool.execute(new ClientThread(listener.accept()));
//            }
//        }
//    }
//
//    private static class ClientThread implements Runnable {
//        private Socket socket;
//        private Account client;
//
//        ClientThread(Socket socket) {
//            this.socket = socket;
//        }
//
//        @Override
//        public void run() {
//            System.out.println("Connected: " + socket);
//            try {
//                Scanner in = new Scanner(socket.getInputStream());
//                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//                String command;
//                boolean errorFlag;
//                while (true) {
//                    errorFlag = false;
//                    command = in.nextLine();
//                    if (command.equals("END")) {
//                        break;
//                    }
//                    switch (command) {
//                        case "add new card": {
////                            String username = in.nextLine();
////                            String password = in.nextLine();
//                             covertCardsToJsonString.setZombieFields(in);
////                            boolean male = in.nextBoolean();
////                            in.nextLine();
//                            for (Account account : Account.getAccounts()) {
//                                if (account.getUsername().equals(username)) {
//                                    out.println("ERROR USERNAME");
//                                    errorFlag = true;
//                                    break;
//                                }
//                            }
//                            if (errorFlag)
//                                continue;
//                            this.client = new Account(username, password, male);
//                            this.client.login();
//                            out.println("DONE");
//                            break;
//                        }
//                        case "online shop": {
//                            String username = in.nextLine();
//                            String password = in.nextLine();
//                            for (Account account : Account.getAccounts()) {
//                                if (account.getUsername().equals(username)) {
//                                    if (account.getPassword().equals(password)) {
//                                        this.client = account;
//                                        this.client.login();
//                                        out.println("DONE");
//                                    } else {
//                                        errorFlag = true;
//                                        break;
//                                    }
//                                    break;
//                                }
//                            }
//                            if (errorFlag)
//                                out.println("ERROR");
//                            break;
//                        }
//                        case "LOGOUT":
//                            this.client.logout();
//                            break;
//                        case "GET USERNAME":
//                            out.println(client.getUsername());
//                            break;
//                        case "GET GENDER":
//                            if (client.getMale())
//                                out.println("male.jpg");
//                            else
//                                out.println("female.jpg");
//                            break;
//                        case "GET POSTS":
//                            out.println(client.getPosts().size());
//                            for (int i = 0; i < client.getPosts().size(); i++) {
//                                out.println(client.getPosts().get(i));
//                                out.println(client.getCaptions().get(i));
//                            }
//                            break;
//                        case "NEW POST":
//                            client.getPosts().add(in.nextLine());
//                            client.getCaptions().add(in.nextLine());
//                            break;
//                        case "GET USERS":
//                            out.println(Account.getAccounts().size() - 1);
//                            for (Account account : Account.getAccounts()) {
//                                if (account.equals(client))
//                                    continue;
//                                out.println(account.getUsername());
//                            }
//                            break;
//                        case "GET USER":
//                            String username = in.nextLine();
//                            for (Account account : Account.getAccounts()) {
//                                if (account.getUsername().equals(username)) {
//                                    out.println(account.getMale());
//                                    out.println(account.getPosts().size());
//                                    for (int i = 0; i < account.getPosts().size(); i++) {
//                                        out.println(account.getPosts().get(i));
//                                        out.println(account.getCaptions().get(i));
//                                    }
//                                }
//                            }
//                            break;
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println("Error:" + socket);
//            } finally {
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    System.out.print("");
//                }
//                System.out.println("Closed: " + socket);
//            }
//        }
//    }
//}