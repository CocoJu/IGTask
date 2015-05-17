package ru.cocojumbo.db;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by ANK on 17.05.2015.
 */
@Entity
@Table(name = "cat", schema = "", catalog = "price_db")
public class CatEntity {
    private int id;
    private String name;
    private Collection<ProdEntity> prodsById;

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, insertable = true, updatable = true, length = 255)
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

        CatEntity catEntity = (CatEntity) o;

        if (id != catEntity.id) return false;
        if (name != null ? !name.equals(catEntity.name) : catEntity.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "catByCatId")
    public Collection<ProdEntity> getProdsById() {
        return prodsById;
    }

    public void setProdsById(Collection<ProdEntity> prodsById) {
        this.prodsById = prodsById;
    }
}
