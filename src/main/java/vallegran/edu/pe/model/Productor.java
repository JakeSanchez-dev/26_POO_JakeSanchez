package vallegran.edu.pe.model;

public class Productor {
    private int id;
    private String nombre;
    private String region;

    public Productor(int id, String nombre, String region) {
        this.id = id;
        this.nombre = nombre;
        this.region = region;
    }

    // Constructor sin id (lo genera MySQL con AUTO_INCREMENT)
    public Productor(String nombre, String region) {
        this.nombre = nombre;
        this.region = region;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
}