package ro.ulbs.proiectaresoftware.lab11;

// ConcreteObserver — implementează Observer
public class MediaInterested implements Observer {

    private String name;

    public MediaInterested(String name) {
        this.name = name;
    }

    // ── Implementare Observer ─────────────────────────────────────────────
    @Override
    public void update(String message) {
        System.out.println("  [" + name + "] received update: " + message);
        doSomeLogic(message);
    }

    public void doSomeLogic(String message) {
        System.out.println("  [" + name + "] processing: " + message);
    }

    @Override
    public String toString() {
        return name;
    }
}