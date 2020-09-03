package net.Lookas;

import net.Lookas.url.ConnectionUrl;
import net.Lookas.url.RecursiveScanner;

public class Main {
    public static void main(String[] args){
        try {
            RecursiveScanner scanner = new RecursiveScanner(10);
            scanner.RecursiveScan(new ConnectionUrl("https://example.com"), true, true, 0);
            System.out.println("Scraped: "+scanner.allUrls.size());
        } catch (Throwable e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
