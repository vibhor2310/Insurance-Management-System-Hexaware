package entity;

public class Client {
    private int clientId;
    private String clientName;
    private String contactInfo;
    private Policy policy;

    // Constructor
    public Client(){

    }
    public Client(int clientId,String clientName,String contactInfo,Policy policy){
        this.clientId = clientId;
        this.clientName = clientName;
        this.contactInfo = contactInfo;
        this.policy = policy;
    }

    // getter and setter
    public int getClientId() {
        return clientId;
    }
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public String getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
    public Policy getPolicy() {
        return policy;
    }
    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
    @Override
    public String toString() {
        return "Client [clientId = " + clientId + ", clientName = " + clientName + ", contactInfo = " + contactInfo
                + ", Policy = " + policy + "]";
    }
}
