package carreview;

class LorryCar extends Car implements IMoveable, IStopable {
// добавлено слово implements

    @Override void open() {   //абстрактный метод надо реализовать
        System.out.println("Car is open"); }

    @Override    //лучше указать
    public void move() {
        System.out.println("Car is moving");
    }

    @Override   //лучше указать
    public void stop() {
        System.out.println("Car is stop");
    }
}