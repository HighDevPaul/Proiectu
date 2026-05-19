package ro.ulbs.proiectaresoftware.lab11;

// Interfața comună pentru subiect (observabil)
public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String message);
}