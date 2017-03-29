package com.ipbeja.estig.packagetracker3;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Paulo Palma 13995 on 28/12/2016.
 */

public class Carrier implements Serializable {

    private String slug;
    private String name;
    private String logo;
    private List<String> phones;
    private String otherName;
    private String url;
    private int id;
    private List<String> emails;
    private static final long serialVersionUID = 46516565480L;
    private static int CarrierID = 1;

    public Carrier() {this(0); }

    public Carrier(int id) { this.id = id; }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static int getNextCarrierID() {
        int res = Carrier.CarrierID;
        Carrier.CarrierID++;
        return res;
    }

    public void addPhone(String phone) {
        if (phone.length() == 9) {
            this.phones.add(phone);
        }
    }

    public void removePhone(int id) {

        if (id >= 0 && id <= this.phones.size()) {
            this.phones.remove(id);
        }
    }

    public String getPhone(int id) {
        if (id >= 0 && id <= this.phones.size()) {
            return this.phones.get(id);
        }
        return null;
    }

    public void addEmail(String email) {
        if (email.contains("@")) {
            this.emails.add(email);
        }
    }

    public void removeEmail(int id) {
        if (id >= 0 && id <= this.emails.size()) {
            this.emails.remove(id);
        }
    }

    public List<String> getEmails() {

        return this.emails;
    }

    public String getEmail(int id) {
        if (id >= 0 && id <= this.emails.size()) {
            return this.emails.get(id);
        }
        return null;
    }
}

