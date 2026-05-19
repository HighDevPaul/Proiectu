package ro.ulbs.proiectaresoftware.lab11;

public class ObserverPatternDemo {

    public static void main(String[] args) {

        YouTubeChannel channel = new YouTubeChannel("Tech Explained");

        MediaInterested media1 = new MediaInterested("CNN");
        MediaInterested media2 = new MediaInterested("FoxNews");

        // ── Primul upload — 2 observatori înregistrați ────────────────────
        System.out.println("=== Inregistrare observatori ===");
        channel.addObserver(media1);
        channel.addObserver(media2);

        String message1 = "Observer Pattern in Java";
        channel.uploadVideo(message1);
        // CNN și FoxNews primesc notificarea

        // ── Eliminăm media2 înainte de al doilea upload ───────────────────
        System.out.println("\n=== Eliminare FoxNews ===");
        channel.removeObserver(media2);

        String message2 = "Singleton Pattern in Java";
        channel.uploadVideo(message2);
        // Doar CNN primește notificarea
    }
}