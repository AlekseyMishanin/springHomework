package lesson3.examplebook;

import lesson3.examplebook.config.ConfigExample;
import lesson3.examplebook.interfaces.SingerDao;
import lesson3.examplebook.model.Singer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class App {

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigExample.class);
        SingerDao<Singer> singerDao = ctx.getBean(SingerDao.class);
        //singerDao.delete(singer);
//        listSingers(singerDao.findAllWithAlbum());
        System.out.println(singerDao.findById(1));
    }

    private static void listSingers(List<Singer> singers){
        singers.stream().filter(a->a.getAlbums()!=null).map(a->a.getAlbums()).forEach(a->System.out.println(a));
    }
}
