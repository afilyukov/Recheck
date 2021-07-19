package carreview;

class LightWeightCar extends Car implements IMoveable {

    @Override void open() {
        System.out.println("Car is open"); }

    @Override
    public void move() {
        System.out.println("Car is moving"); }
}
