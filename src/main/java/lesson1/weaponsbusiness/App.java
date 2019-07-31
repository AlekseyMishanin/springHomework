package lesson1.weaponsbusiness;

import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        GenericXmlApplicationContext context = new GenericXmlApplicationContext();
        context.load("lesson1/gunsconfig.xml");
        context.refresh();

        GunProvider gunProvider = context.getBean("beretta", Beretta.class);
        gunProvider.gunshot();
        context.close();
    }
}
