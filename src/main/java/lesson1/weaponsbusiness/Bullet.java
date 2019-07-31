package lesson1.weaponsbusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Класс пули.
 *
 * @author - Aleksey Mishanin
 * */

@Component("bullet")
public class Bullet {

    private String name;

    public Bullet() {
    }

    @Autowired
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
