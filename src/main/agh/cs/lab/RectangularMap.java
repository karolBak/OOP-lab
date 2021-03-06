package agh.cs.lab;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {

    RectangularMap(int width, int height) {
        this.upperRight = new Position(width - 1, height - 1);
        this.lowerLeft = new Position(0,0);
    }

    @Override
    public boolean canMoveTo(Position position) {
        return position.larger(lowerLeft)
                && position.smaller(upperRight)
                && !(isOccupied(position));
    }

}
