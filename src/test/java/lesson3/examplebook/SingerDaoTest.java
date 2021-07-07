package lesson3.examplebook;

import lesson3.examplebook.config.ConfigExample;
import lesson3.examplebook.interfaces.SingerDao;
import lesson3.examplebook.model.Album;
import lesson3.examplebook.model.Singer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SingerDaoTest extends Assert {

    private GenericApplicationContext ctx;
    private SingerDao singerDao;

    @Before
    public void setUp(){
        ctx = new AnnotationConfigApplicationContext(ConfigExample.class);
        singerDao = ctx.getBean(SingerDao.class);
        assertNotNull(singerDao);
    }

    @Test
    public void testInsert(){
        Singer singer = new Singer();
        singer.setFirst_name("BB");
        singer.setLast_name("King");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1940,8,16))
                        .getTime().getTime()));

        Album album = new Album();
        album.setTitle("My Blues");
        album.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(1961,7,20))
                        .getTime().getTime()));
        singer.addAlbum(album);
        album = new Album();
        album.setTitle("My Blues Old");
        album.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(1962,10,1))
                        .getTime().getTime()));
        singer.addAlbum(album);

        singerDao.save(singer);
        assertNotNull(singer.getId());

        List<Singer> singers = singerDao.findAllWithAlbum();
        assertEquals(4, singers.size());
        listSingerWithAlbum(singers);
    }

    @Test
    public void testFindAll(){
        List<Singer> singers = singerDao.findAll();
        assertEquals(3,singers.size());
        listSingers(singers);
    }

    @Test
    public void testFindAllWithAlbum(){
        List<Singer> singers = singerDao.findAllWithAlbum();
        assertEquals(3, singers.size());
        listSingerWithAlbum(singers);
    }

    @Test
    public void testFindByID(){
        Singer singer = (Singer)singerDao.findById(1);
        assertNotNull(singer);
    }

    @Test
    public void testUpdate(){
        Singer singer = (Singer)singerDao.findById(1L);
        assertNotNull(singer);
        assertEquals("Mayer", singer.getLast_name());

        Album album = singer.getAlbums().stream().filter(
                a->a.getTitle().equals("name 2")).findFirst().get();
        singer.setFirst_name("John Clayton");
        singerDao.save(singer);
    }

    @Test
    public void testDelete(){
        Singer singer = (Singer) singerDao.findById(2L);
        assertNotNull(singer);
        singerDao.delete(singer);
        listSingerWithAlbum(singerDao.findAllWithAlbum());
    }

    private static void listSingers(List<Singer> singers){
        singers.stream().forEach(System.out::println);
    }

    private static void listSingerWithAlbum(List<Singer> singers){
        singers.stream().filter(a->a.getAlbums()!=null).map(a->a.getAlbums()).forEach(System.out::println);
        singers.stream().filter(a->a.getInstruments()!=null).map(a->a.getInstruments()).forEach(System.out::println);
    }

    @After
    public void tearDown(){
        ctx.close();
    }
}
