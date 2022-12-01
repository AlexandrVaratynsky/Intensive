package com.intensive.spring.mvc.dao;

import com.intensive.spring.mvc.entities.Position;

import java.util.List;


public interface PositionDAO {


    void createPosition(Position position);

    void updatePosition(Position position);

    Position getPositionById(int id);

    List<Position> getPositionsByName(String positionName);

    List<Position> getAllPositions();

    void deletePosition(Position position);
}
