package ua.com.gfalcon.financier.screener.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import ua.com.gfalcon.financier.screener.service.MarketDataService;

/**
 * REST controller for Screener.
 */
@RestController
@RequiredArgsConstructor
public class ScreenerController {

    private final MarketDataService service;

    /**
     * Trigger load Yahoo daily data.
     *
     * @return ok
     */
    @RequestMapping(path = "/load", method = RequestMethod.POST)
    public ResponseEntity<String> loadData() {
        service.loadMarketData();
        return ResponseEntity.ok().build();
    }
}
