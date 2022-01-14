package carreview;

abstract class Car implements IMotion{ //поведение двигаться и останавливаться "схлопнуты" и имплементируются для любой машины
    //где engine? почему public? лучше сделать через интерфейс или абстрактный класс, т.к двигатели бывают разные
    private final IEngine engine;
    private final String color;
    private final String name;
    //параметры задаются через конструктор и убраны сеттеры
    //иммутабельность полей обсуждается по предметной области(у Заказчика?), пока задано для всех
    //сейчас параметров мало, но в реальности, скорее всего, их потребуются сотни. Нужен будет builder

    protected Car(String color, String name, IEngine engine) {
        this.color = color;
        this.name = name;
        this.engine = engine;
    }

    public void start() {
        System.out.println("Car is starting");
    } // заменен модификатор

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stoping");
    }

    abstract void open(); //зачем абстрактный, почему не публичный? но, скорее всего, лучше поискать создателя кода и спросить сначала (в реальности)?
    //может, у каких-то машин нет дверей и нечего открывать?

    public IEngine getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

}
