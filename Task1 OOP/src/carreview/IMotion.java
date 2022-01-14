package carreview;

//два интерфейса "схлопнуты" т.к явно все машины двигаются и останавливаются
public interface IMotion {
    void move();
    void stop();
}