package requests.massenegerPacket.massenegerPacketChilds;

import requests.massenegerPacket.MassenegeRequest;

public class ListOfCommandsMasseneger extends MassenegeRequest {
    private ListMassenger listMassenger;

    public void setListMassenger(ListMassenger listMassenger) {
        this.listMassenger = listMassenger;
    }

    public ListMassenger getListMassenger() {
        return listMassenger;
    }
}
