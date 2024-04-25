package org.example.practice14;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MarketController {
    private List<Market> marketList = new ArrayList<>();

    @PostMapping("/add-mark")
    public Market createProduct(@RequestBody Market market) {
        marketList.add(market);
        return market;
    }

    @GetMapping("/marks")
    public List<Market> getAllProducts() {
        return marketList;
    }

    @DeleteMapping("/marks/{index}")
    public Market deleteProduct(@PathVariable int index) {
        if (index >= 0 && index < marketList.size()) {
            return marketList.remove(index);
        } else {
            return null;
        }
    }
}
