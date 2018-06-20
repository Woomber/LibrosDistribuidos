package models;

import java.io.Serializable;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public class Foro implements Serializable {
    private final int id;

    public Foro() {
        this.id = 0;
    }

    public Foro(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}
