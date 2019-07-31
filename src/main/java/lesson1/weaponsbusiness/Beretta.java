package lesson1.weaponsbusiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Класс описывает оружие, которое обладает возможностью стрелять, перезаряжать и разряжать обойму.
 *
 * @author - Aleksey Mishanin
 * */

@Service("beretta")
public class Beretta implements GunProvider {

    private BulletProvider bulletProvider;

    public void gunshot() {
        System.out.println("Выстрел из ружья. Пуля " + bulletProvider.getBullet() + " достигла цели");
    }

    @Autowired
    public void charge(BulletProvider bullets) {
        this.bulletProvider = bullets;
    }

    public Bullet discharge() {
        Bullet temp = bulletProvider.getBullet();
        bulletProvider = null;
        return temp;
    }
}
