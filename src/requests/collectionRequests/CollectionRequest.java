package requests.collectionRequests;

import requests.Request;
import requests.collectionRequests.collectionRequestsChilds.AddNewCard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CollectionRequest extends Request {
    private static CollectionRequest collectionRequest;

    public static CollectionRequest getInstance() {
        if (collectionRequest == null)
            collectionRequest = new CollectionRequest();
        return collectionRequest;
    }

    public CollectionRequest getCollectionOptionList() {
        String command = scanner.nextLine().trim().toLowerCase();
        Pattern pattern = Pattern.compile("add new card (\\w+)");
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            AddNewCard add = new AddNewCard();
            add.setNamme(command.split("\\s")[2]);
            return add;
        }
        return null;
    }
}