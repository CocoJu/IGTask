package ru.cj.db;

import ru.cj.db.hibernate.HibernateUtil;
import ru.cj.db.map.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class DbManagerPersistance implements DbManager{

    private EntityManager entityManager;

    public DbManagerPersistance(EntityManager em){
        entityManager = em;
    }

    @Override
    public List<Product> getProductsByConditions(
            String nameContain, Float priceFrom, Float priceBefore) {

        openConnction();

        List<Predicate> predicates = new ArrayList<Predicate>();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery =
                criteriaBuilder.createQuery(Product.class);
        Root<Product> productRoot = criteriaQuery.from(Product.class);

        if(!nameContain.equals("") && nameContain != null){
            Expression<String> expression = productRoot.get("name");
            Predicate nameContainPredicate = criteriaBuilder.like(
                    criteriaBuilder.lower(expression), "%" + nameContain + "%");
            predicates.add(nameContainPredicate);
        }

        if(priceFrom != null && priceBefore != null){
            Expression<Float> price =  productRoot.get("price");
            Predicate pricePredicate =
                    criteriaBuilder.between(price, priceFrom, priceBefore);
            predicates.add(pricePredicate);
        }

        criteriaQuery.select(productRoot);

        if(predicates.size() != 0) {
            Predicate[] predicatesArray = new Predicate[predicates.size()];
            criteriaQuery.where( predicates.toArray(predicatesArray) );
        }

        TypedQuery<Product> productTypedQuery =
                entityManager.createQuery(criteriaQuery);
        List<Product> productList = productTypedQuery.getResultList();

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
