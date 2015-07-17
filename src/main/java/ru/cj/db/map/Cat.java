package ru.cj.db.map;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cat")
public class Cat {

    @Id
    private int id;
    private String name;

    @OneToMany(mappedBy = "cat", cascade = CascadeType.ALL)
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cat cat = (Cat) o;

        if (id != cat.id) return false;
        if (name != null ? !name.equals(cat.name) : cat.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
