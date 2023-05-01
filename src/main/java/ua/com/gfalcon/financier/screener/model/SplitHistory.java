package ua.com.gfalcon.financier.screener.model;

import java.util.Set;

/**
 * Split history event.
 */
public interface SplitHistory {

    Set<SplitEvent> splitHistory();

}
