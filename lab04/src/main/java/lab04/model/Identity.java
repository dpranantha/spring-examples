package lab04.model;


public class Identity extends Product {
    private long id;
    public Identity(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
}
