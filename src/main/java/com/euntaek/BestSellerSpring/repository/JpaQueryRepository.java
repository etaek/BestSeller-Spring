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
                "SELECT count(d.userid) as count FROM Donate d GROUP BY d.userid order by count(d.userid) desc ");
        query.setFirstResult(0);
        query.setMaxResults(3);
        List result=query.getResultList();

        return result;
    }

    @Override
    public List<String> findId()  {
        Query query=em.createQuery(
                "SELECT d.userid FROM Donate d GROUP BY d.userid order by count(d.userid) desc ");
        query.setFirstResult(0);
        query.setMaxResults(3);
        List result=query.getResultList();

        return result;
    }


}
