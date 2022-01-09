package draw.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract class Shape {

    abstract Point[][] paint(Point[][] canvas);
}
