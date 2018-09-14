package vbeast.pro.jsonToObject;

/**
 * Created by varun on 11/9/18.
 */
public class Address {

    private String flatNo;
    private String pocket;
    private String block;
    private String sector;
    private String city;

    public Address(String flatNo, String pocket, String block, String sector, String city) {
        this.flatNo = flatNo;
        this.pocket = pocket;
        this.block = block;
        this.sector = sector;
        this.city = city;
    }
}
