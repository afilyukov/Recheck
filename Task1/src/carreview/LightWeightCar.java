package carreview;

class LightWeightCar extends Car  {//имплементация интерфейса убрана на уровень родительского класса
    protected LightWeightCar(String color, String name, IEngine engine) {
        super(color, name, engine);
    }

    @Override void open() {
        System.out.println("Car is open"); }
}
