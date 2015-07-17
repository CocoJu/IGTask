package ru.cj.db.map;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "prod")
public class Product {

    @Id
    private int id;
    private String name;
    private Float price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cat_id" , insertable=false, updatable=false)
    private Cat cat;

    public Cat getCat() {
        return this.cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product that = (Product) o;

        if (id != that.id) return false;
        if (cat != null ? !cat.equals(that.cat) : that.cat != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (cat != null ? cat.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
