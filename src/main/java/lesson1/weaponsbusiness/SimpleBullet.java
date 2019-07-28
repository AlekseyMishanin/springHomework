package lesson1.weaponsbusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Класс описывает один из вариантов получить пулю.
 *
 * @author - Aleksey Mishanin
 * */

@Component("bullets")
public class SimpleBullet implements BulletProvider {

    private Bullet bullet;

    @Autowired
    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }

    public Bullet getBullet() {
        return bullet;
    }
}
