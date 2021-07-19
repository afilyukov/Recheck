package carreview;

abstract class Car {
    //где engine? лучше сделать через интерфейс или абстрактный класс, т.к двигатели бывают разные
    public IEngine engine;
    private String color;
    private String name;
    //сейчас параметров мало, но в реальности, скорее всего, их потребуются сотни. Нужен будет builder

    void start() {
        System.out.println("Car starting");
    }

    abstract void open();

    public IEngine getEngine() {
        return engine;
    }
    public void setEngine(IEngine engine) {
        this.engine = engine;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name; }
}
