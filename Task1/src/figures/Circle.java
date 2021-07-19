package figures;

class Circle extends Figure {
    private final float radius;

    Circle(float x, float y, float radius) {
        super(x, y);
        this.radius = radius;
    }

    public float getPerimeter() {
        return 2 * radius * 3.14f;
    }

    public float getArea() {
        return 3.14f * radius * radius;
    }
}