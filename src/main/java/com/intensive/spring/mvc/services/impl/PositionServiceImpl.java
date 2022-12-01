package com.intensive.spring.mvc.services.impl;

import com.intensive.spring.mvc.dao.PositionDAO;
import com.intensive.spring.mvc.entities.Position;
import com.intensive.spring.mvc.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    private final String DEFAULT_POSITION_NAME = "novice";
    private PositionDAO positionDAO;

    private Position defaultPosition;

    @PostConstruct
    private void init() {
        List<Position> positions = positionDAO.getPositionsByName(DEFAULT_POSITION_NAME);
        if (positions.isEmpty()) {
            defaultPosition = new Position(DEFAULT_POSITION_NAME);
            positionDAO.createPosition(defaultPosition);
        } else {
            defaultPosition = positions.get(0);
        }
    }

    public void setDefaultPosition(Position defaultPosition) {
        this.defaultPosition = defaultPosition;
    }

    @Autowired
    public void PositionDAO(PositionDAO positionDAO) {
        this.positionDAO = positionDAO;
    }

    @Override
    public void addPosition(Position position) {
        positionDAO.createPosition(position);
    }

    @Override
    public void updatePosition(Position position) {
        positionDAO.updatePosition(position);
    }

    @Override
    public List<Position> getAllPositions() {
        return positionDAO.getAllPositions();
    }

    @Override
    public Position getPositionById(int id) {
        return positionDAO.getPositionById(id);
    }

    @Override
    public void removePosition(int id) {
        positionDAO.deletePosition(positionDAO.getPositionById(id));
    }

    @Override
    public Position getDefaultPosition() {
        return defaultPosition;
    }
}
