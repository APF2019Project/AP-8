package requests.shopRequests;

import requests.Request;
import requests.shopRequests.shopRequestChilds.ListShop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShopRequest extends Request {
    private static ShopRequest shopRequest;
    private String name;
    private ListShop listShop;

    public static ShopRequest getInstance() {
        if (shopRequest == null)
            shopRequest = new ShopRequest();
        return shopRequest;
    }

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListShop getListShop() {
        return listShop;
    }

    public void setListShop(ListShop listShop) {
        this.listShop = listShop;
    }

    //todo get commands
    public ShopRequest getCommand() {
        String command = scanner.nextLine().toLowerCase().trim();

        Pattern pattern = Pattern.compile("sell (\\w+)");
        Matcher matcher = pattern.matcher(command);
        if (matcher.find())
            return sell(matcher.group(1));

        pattern = Pattern.compile("buy (\\w+)");
        matcher = pattern.matcher(command);
        if (matcher.find())
            return buy(matcher.group(1));
        return null;
    }

    private ShopRequest buy(String group) {
        this.setListShop(ListShop.BUY);
        this.setName(name);
        return this;
    }

    //todo play methods
    private ShopRequest sell(String name) {
        this.setListShop(ListShop.SELL);
        this.setName(name);
        return this;
    }
}
