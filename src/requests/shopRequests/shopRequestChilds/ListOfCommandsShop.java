package requests.shopRequests.shopRequestChilds;


import requests.shopRequests.ShopRequest;

public class ListOfCommandsShop extends ShopRequest {
    private ListShop list;

    public ListShop getShopOptionList() {
        return list;
    }

    public void setShopOptionList(ListShop accountOptionList) {
        this.list = accountOptionList;
    }
}
