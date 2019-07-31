package lesson1.appcontext.common.service;

import org.springframework.stereotype.Component;

@Component
public class BestService {
    public void getBest(){
        System.out.println(this);
    }
}
