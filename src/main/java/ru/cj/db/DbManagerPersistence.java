package ru.cj.db;

import ru.cj.db.hibernate.HibernateUtil;
import ru.cj.db.map.Cat;
import ru.cj.db.map.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

public class DbManagerPersistence implements DbManager{

    private EntityManager entityManager;

    public DbManagerPersistence(EntityManager em){
        entityManager = em;
    }

    @Override
    public List<Product> getProductsByConditions(
            String categoryContain, String nameContain,
                    Float priceFrom, Float priceBefore) {
        openConnction();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> productRoot = cq.from(Product.class);
        Root<Cat> categoryRoot = cq.from(Cat.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

        if(categoryContain != null) {
            if (!categoryContain.equals("")) {
                Expression<String> expression = categoryRoot.get("name");
                Predicate nameContainPredicate =
                        cb.like(cb.lower(expression),
                                "%" + nameContain + "%");
                predicates.add(nameContainPredicate);
            }
        }

        if(nameContain != null) {
            if (!nameContain.equals("")) {
                Expression<String> expression = productRoot.get("name");
                Predicate nameContainPredicate =
                        cb.like(cb.lower(expression),
                                "%" + nameContain + "%");
                predicates.add(nameContainPredicate);
            }
        }

        if(priceFrom != null && priceBefore != null){
            Expression<Float> price =  productRoot.get("price");
            Predicate pricePredicate =
                    cb.between(price, priceFrom, priceBefore);
            predicates.add(pricePredicate);
        }

        cq.select(productRoot);

        if(predicates.size() != 0) {
            Predicate[] predicatesArray =
                    new Predicate[predicates.size()];
            cq.where(predicates.toArray(predicatesArray));
        }

        TypedQuery<Product> productTypedQuery =
                entityManager.createQuery(cq);
        List<Product> productList =
                productTypedQuery.getResultList();
        closeConnection();
        return productList;
    }

    private void openConnction(){
        if(!entityManager.isOpen())
            entityManager = HibernateUtil.getEm();
    }

    private void closeConnection(){
        entityManager.close();
    }
}
