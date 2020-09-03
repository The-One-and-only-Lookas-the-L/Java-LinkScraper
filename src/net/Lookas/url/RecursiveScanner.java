package net.Lookas.url;

import java.util.ArrayList;

public class RecursiveScanner {
    public RecursiveScanner(int maxLayers){
        this.MAX_LAYERS = maxLayers;
    }

    public ArrayList<String> allUrls = new ArrayList<>();
    private final int MAX_LAYERS;

    public void RecursiveScan(ConnectionUrl url, boolean isRoot, boolean printChildren, int layer) {
        try{
            for(String urlString : url.getHrefs()){
                if (urlString.endsWith(".png") || urlString.endsWith(".ico")){
                    continue;
                }
                if (isRoot || printChildren){
                    System.out.println("Scraping: "+urlString);
                }
                if (this.MAX_LAYERS >= layer && !this.allUrls.contains(urlString)){
                    this.allUrls.add(urlString);
                    RecursiveScan(new ConnectionUrl(urlString), false, printChildren, layer++);
                }
            }
        }catch (Throwable throwable){
            System.out.println("RecursiveScannerError: "+throwable.getMessage());
        }
    }
}
