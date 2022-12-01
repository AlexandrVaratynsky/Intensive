package com.intensive.spring.mvc.dao.impl;

import com.intensive.spring.mvc.components.SessionFactoryBean;
import com.intensive.spring.mvc.dao.PositionDAO;
import com.intensive.spring.mvc.entities.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class SQLPositionDAO implements PositionDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    public void createPosition(Position position) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().persist(position);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Override
    public void updatePosition(Position position) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().merge(position);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }

    @Override
    public Position getPositionById(int id) {
        Position result;
        sessionFactory.getCurrentSession().beginTransaction();
        result =  sessionFactory.getCurrentSession().get(Position.class, id);
        sessionFactory.getCurrentSession().getTransaction().commit();
        return result;
    }

    @Override
    public List<Position> getPositionsByName(String positionName){
        List<Position> result;
        sessionFactory.getCurrentSession().beginTransaction();

        result = sessionFactory.getCurrentSession().createQuery(
                "from Position where name ='" + positionName + "'",
                Position.class)
                .getResultList();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return result;
    }
    @Override
    public List<Position> getAllPositions(){
        List<Position> result;
        sessionFactory.getCurrentSession().beginTransaction();
        result = sessionFactory.getCurrentSession().createQuery(
                "from Position",
                Position.class)
                .getResultList();
        sessionFactory.getCurrentSession().getTransaction().commit();
        return result;
    }

    @Override
    public void deletePosition(Position position) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().remove(position);
        sessionFactory.getCurrentSession().getTransaction().commit();
    }
}
