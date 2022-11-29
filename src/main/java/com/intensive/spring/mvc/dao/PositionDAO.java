package com.intensive.spring.mvc.dao;

import com.intensive.spring.mvc.entities.Position;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionDAO {

    void createPosition(Position position);

    Position getPositionByID(int id);

    Position getPositionByName(String PositionName);

    Position getDefaultPosition();

    void updatePosition(Position position);

    void deletePosition(Position position);
}
