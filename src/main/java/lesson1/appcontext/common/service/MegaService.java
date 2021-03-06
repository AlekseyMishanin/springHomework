package lesson1.appcontext.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MegaService {

    private BestService bestService;

    @Autowired
    public MegaService(BestService bestService) {
        this.bestService = bestService;
    }

    public BestService getBestService() {
        return bestService;
    }
}
