package requests.collectionRequests.collectionRequestsChilds;

import requests.collectionRequests.CollectionRequest;

public class AddNewCard extends CollectionRequest {
    private String namme;

    public String getNamme() {
        return namme;
    }

    public void setNamme(String namme) {
        this.namme = namme;
    }
}
