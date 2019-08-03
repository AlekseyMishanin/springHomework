package lesson1.appcontext.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BetaService {

    @Autowired
    private BestService bestService;

    public BestService getBestService() {
        return bestService;
    }
}
