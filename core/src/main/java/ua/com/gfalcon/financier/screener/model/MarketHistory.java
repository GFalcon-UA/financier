package ua.com.gfalcon.financier.screener.model;

import java.util.SortedSet;

/**
 * Market history.
 */
public interface MarketHistory {

    SortedSet<Bar> history();

}
