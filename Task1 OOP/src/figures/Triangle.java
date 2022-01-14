package figures;

class Triangle extends Figure {
    private final float sideA;
    private final float sideB;
    private final float sideC;

    Triangle(float x, float y, float sideA, float sideB, float sideC) {
        super(x, y);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public float getPerimeter() {
        return sideA + sideB + sideC;
    }

    public float getArea() {
        float p = getPerimeter() / 2;
        return (float) Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideA));
    }
}
