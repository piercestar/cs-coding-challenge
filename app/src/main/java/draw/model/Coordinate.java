package draw.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Coordinate {

    private int x;
    private int y;

    public void swap(Coordinate coord) {

        int temp_x = this.x;
        int temp_y = this.y;

        this.x = coord.getX();
        this.y = coord.getY();

        coord.setX(temp_x);
        coord.setY(temp_y);
    }

    public boolean isHorizontalOrVerticalLine(Coordinate coord) {
        return isHorizontalLine(coord) || isVerticalLine(coord);
    }

    public boolean isHorizontalLine(Coordinate coord) {
        return this.y == coord.getY();
    }

    public boolean isVerticalLine(Coordinate coord) {
        return this.x == coord.getX();
    }

}
