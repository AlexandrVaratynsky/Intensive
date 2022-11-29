package com.intensive.spring.mvc.services;

import com.intensive.spring.mvc.entities.Position;

import java.util.List;

public interface PositionService {
    public void addPosition(Position position);
    public void updatePosition(Position position);
    public List<Position> listPosition();
    public Position getPositionById(int id);
    public void removePosition(int id);
}
