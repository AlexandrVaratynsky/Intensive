package com.intensive.spring.mvc.services.impl;

import com.intensive.spring.mvc.dao.PositionDAO;
import com.intensive.spring.mvc.entities.Position;
import com.intensive.spring.mvc.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    private PositionDAO positionDAO;
    @Autowired
    public void EmployeeDAO(PositionDAO employeeDAO) {
        this.positionDAO = employeeDAO;
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
    public List<Position> listPosition() {
        return null;
    }

    @Override
    public Position getPositionById(int id) {
        return positionDAO.getPositionByID(id);
    }

    @Override
    public void removePosition(int id) {
        positionDAO.deletePosition(positionDAO.getPositionByID(id));
    }
}
