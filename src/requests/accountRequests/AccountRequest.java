package requests.accountRequests;

import requests.Request;
import requests.accountRequests.accountRequestChilds.CreateAccount;
import requests.accountRequests.accountRequestChilds.ListAccount;
import requests.accountRequests.accountRequestChilds.ListOfCommandsAccount;
import requests.accountRequests.accountRequestChilds.LoginAccount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountRequest extends Request {
    //    private String userName;
//    private String pass;
//    private String newPass;
//    private enum Type{
//        createAccount,
//        login
//    }
    private static AccountRequest accountRequest;

    public static AccountRequest getInstance() {
        if (accountRequest == null)
            accountRequest = new AccountRequest();
        return accountRequest;
    }

    public String getPassWord() {
        System.out.println("password :");
        String passWord = scanner.nextLine().trim();
        return passWord;
    }

    public AccountRequest getCommand() {
        String actualCommand = scanner.nextLine().trim();
        String command = actualCommand.toLowerCase();
        Pattern pattern = Pattern.compile("create account (\\w+)");
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            CreateAccount accountLoginRequest = new CreateAccount();
            accountLoginRequest.setLine(actualCommand.split("\\s")[2]);
            return accountLoginRequest;
        }

        pattern = Pattern.compile("login (\\w+)");
        matcher = pattern.matcher(command);
        if (matcher.find()) {
            LoginAccount loginAccount = new LoginAccount();
            loginAccount.setLine(actualCommand.split("\\s")[1]);
            return loginAccount;
        }
        if (command.indexOf("logout") >= 0) {
            ListOfCommandsAccount listOfCommandsAccount = new ListOfCommandsAccount();
            listOfCommandsAccount.setAccountOptionList(ListAccount.LOGOUT);
            return listOfCommandsAccount;
        }
        return null;
    }
}
