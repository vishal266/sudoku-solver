package com.vishal.solver.sudoku.search;

import com.vishal.solver.sudoku.exception.SearchNotSupportedException;
import org.apache.log4j.Logger;

/**
 * A factory class to instantiate different search objects based on user preference from SearchType enum
 * Currently supports only DFS and BFS
 * More search types can be added here in the future like A*, Branch and bound, etc if needed.
 */
public class SearchFactory {

    private static Logger log = Logger.getLogger(SearchFactory.class);

    public static Search getSearch(SearchType searchType) throws SearchNotSupportedException {
        if(searchType == null) {
            log.error("Search type cannot be null...");
            throw new SearchNotSupportedException("Search type cannot be null...");
        }
        switch (searchType) {
            case BFS: {
                log.info("Breadth first search to be used...");
                return new BreadthFirstSearch();
            }
            case DFS: {
                log.info("Depth first search to be used...");
                return new DepthFirstSearch();
            }
            default: {
                log.error("Search algorithm not supported currently...");
                throw new SearchNotSupportedException("Search algorithm not supported currently...");
            }
        }
    }
}
