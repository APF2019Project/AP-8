package model.repository;

import java.util.HashMap;

public class Shop {
    private HashMap<String , Integer> shop = new HashMap<>();
    public void showShop(){
        for (String key: shop.keySet()) {
            System.out.println(key + ":" + shop.get(key) );
        }
    }
  //  public boolean sell(String cardName){

   // }

}
