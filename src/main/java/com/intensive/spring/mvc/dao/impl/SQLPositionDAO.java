package com.intensive.spring.mvc.dao.impl;

import com.intensive.spring.mvc.components.SessionFactoryBean;
import com.intensive.spring.mvc.dao.PositionDAO;
import com.intensive.spring.mvc.entities.Position;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SQLPositionDAO implements PositionDAO {
    private SessionFactory sessionFactory;
    private final String DEFAULT_POSITION_NAME = "novice";

    @Autowired
    public void setSessionFactory(SessionFactoryBean sessionFactoryBean) {
        this.sessionFactory = sessionFactoryBean.sessionFactory();

    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    private boolean sourceIsEmpty() {
        boolean result;
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        result = session.createQuery("select 1 from Position ").setMaxResults(1).list().isEmpty();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public void createPosition(Position position) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(position);

    }

    @Override
    public Position getPositionByID(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Position position = (Position) session.getReference(Position.class, new Integer(id));
        return position;

    }

    @Override
    public Position getPositionByName(String positionName) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        Position position = (Position) session.createQuery(" from Position where name = '"
                + positionName + "'").list().get(0);
        session.getTransaction().commit();
        return position;

    }

    @Override
    public Position getDefaultPosition() {
        Position result;
        if (sourceIsEmpty()) {
            result = createDefaultPosition();
        } else {
            result = getPositionByName(DEFAULT_POSITION_NAME);
        }
        return result;
    }

    private Position createDefaultPosition() {
        Position result;
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(new Position(DEFAULT_POSITION_NAME));
        session.getTransaction().commit();
        result = getPositionByName(DEFAULT_POSITION_NAME);
        return result;
    }

    @Override
    public void updatePosition(Position position) {
        Session session = this.sessionFactory.getCurrentSession();
        session.merge(position);
    }

    @Override
    public void deletePosition(Position position) {
        Session session = this.sessionFactory.getCurrentSession();
        session.remove(position);
    }
}
