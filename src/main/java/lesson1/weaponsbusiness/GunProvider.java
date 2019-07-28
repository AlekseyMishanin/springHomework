package lesson1.weaponsbusiness;

/**
 * Интерфейс описывает основные действия ружья
 *
 * @author - Aleksey Mishanin
 * */
public interface GunProvider {

    //выстрел
    void gunshot ();

    //зарядить оружие
    void charge (BulletProvider bullets);

    //разрядить оружие
    Bullet discharge ();
}
