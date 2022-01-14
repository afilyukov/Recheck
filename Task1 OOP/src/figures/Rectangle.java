package figures;

class Rectangle extends Figure {
    private final float width;
    private final float height;

    Rectangle(float x, float y, float width, float height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public float getPerimeter() {
        return width * 2 + height * 2;
    }

    public float getArea() {
        return width * height;
    }
}
