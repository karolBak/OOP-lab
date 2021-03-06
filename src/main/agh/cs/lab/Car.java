package agh.cs.lab;

public class Car {
    private MapDirection direction = MapDirection.North;
    private Position position = new Position(2,2);
    private IWorldMap map;

    Car(IWorldMap map) {
        this.map = map;
    }

    Car(IWorldMap map, int x, int y) {
        this.map = map;
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return position;
    }

    public boolean move(MoveDirection direction) {
        Position newPos = position;
        switch(direction) {
            case Left:
                this.direction = this.direction.previous();
                break;
            case Right:
                this.direction = this.direction.next();
                break;
            case Forward:
                newPos = position.add(this.direction.toPosition());
                break;
            case Backward:
                newPos = position.sub(this.direction.toPosition());
        }
        if(map.canMoveTo(newPos)) {
            position = newPos;
            return true;
        }
        return false;
    }

    public String toString() {
        return direction.toChar();
    }
}
