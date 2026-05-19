package ro.ulbs.proiectaresoftware.lab11;

import java.util.ArrayList;
import java.util.List;

// ConcreteSubject — implementează Subject
public class YouTubeChannel implements Subject {

    private String channelName;

    // Lista de observatori înregistrați
    private List<Observer> observers = new ArrayList<>();

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    // ── Implementare Subject ──────────────────────────────────────────────
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
        System.out.println("  [+] Abonat: " + observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("  [-] Dezabonat: " + observer);
    }

    @Override
    public void notifyObservers(String message) {
        // Notificăm toți observatorii înregistrați
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    // ── Acțiunea principală — notifică observatorii la upload ─────────────
    public void uploadVideo(String title) {
        System.out.println("\n{" + channelName + "} uploaded: " + title);
        notifyObservers(title);
    }
}