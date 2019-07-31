package lesson1.appcontext.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestService {

    @Autowired
    private BestService bestService;

    public BestService getBestService() {
        return bestService;
    }

    public void setBestService(BestService bestService) {
        this.bestService = bestService;
    }
}
