package ru.cocojumbo.db;
import javax.persistence.*;

/**
 * Created by ANK on 17.05.2015.
 */
@Entity
@Table(name = "prodwithcat", schema = "", catalog = "price_db")
public class ProdwithcatEntity {
    private int id;
    private String catName;
    private String name;
    private Float price;

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "catName", nullable = true, insertable = true, updatable = true, length = 255)
    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = true, insertable = true, updatable = true, precision = 2)
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

        ProdwithcatEntity that = (ProdwithcatEntity) o;

        if (id != that.id) return false;
        if (catName != null ? !catName.equals(that.catName) : that.catName != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (catName != null ? catName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
