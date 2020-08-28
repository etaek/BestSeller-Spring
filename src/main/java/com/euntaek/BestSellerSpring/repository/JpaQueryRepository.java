package com.euntaek.BestSellerSpring.repository;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Component
public class JpaQueryRepository implements CountRepository {

    private final EntityManager em;

    public JpaQueryRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Long> findCount()  {
        Query query=em.createQuery(
                "SELECT count(d.user_id) as count FROM Donate d GROUP BY d.user_id order by count(d.user_id) desc ");
        query.setFirstResult(0);
        query.setMaxResults(3);
        List result=query.getResultList();

        return result;
    }

    @Override
    public List<String> findId()  {
        Query query=em.createQuery(
                "SELECT d.user_id FROM Donate d GROUP BY d.user_id order by count(d.user_id) desc ");
        query.setFirstResult(0);
        query.setMaxResults(3);
        List result=query.getResultList();

        return result;
    }


}
