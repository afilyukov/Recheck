package carreview;

class LorryCar extends Car { //имплементация интерфейса убрана на уровень родительского класса
    protected LorryCar(String color, String name, IEngine engine) {
        super(color, name, engine);
    }

    @Override void open() {   //абстрактный метод надо реализовать
        System.out.println("Car is open"); }
}