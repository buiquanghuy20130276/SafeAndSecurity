package bean;

public class HistoryKey {
    private int id;
    private String publickey;
    private String idUser;
    private String createdAt;

    public HistoryKey() {
    }

    public HistoryKey(int id, String publickey, String idUser, String createdAt) {
        this.id = id;
        this.publickey = publickey;
        this.idUser = idUser;
        this.createdAt = createdAt;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPublickey() {
        return publickey;
    }

    public void setPublickey(String publickey) {
        this.publickey = publickey;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
