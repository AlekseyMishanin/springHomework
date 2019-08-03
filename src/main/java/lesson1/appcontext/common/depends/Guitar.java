package lesson1.appcontext.common.depends;

import org.springframework.stereotype.Component;

@Component("gopher")
public class Guitar {
    public void sing(){
        System.out.println(" Cm Eb Fm Ab Bb");
    }
}
