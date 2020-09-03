package net.Lookas.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ConnectionUrl {
    private final String data;
    private String processed;
    private ArrayList<String> hrefs;

    public ConnectionUrl(String urlName) throws IOException {
        StringBuilder data = new StringBuilder();
        URL url = new URL(urlName);
        InputStream is = url.openConnection().getInputStream();

        BufferedReader reader = new BufferedReader( new InputStreamReader( is )  );

        String line = null;
        while( ( line = reader.readLine() ) != null )  {
            data.append(line).append("\n");
        }
        reader.close();

        this.data = data.toString();
        process();
    }
    private void process(){
        StringBuilder sb = new StringBuilder();
        for(String line : this.data.split("\n")){
            sb.append(line.replace(">", ">\n"));
        }
        this.processed = sb.toString();
    }
    public String getData(){
        return this.data;
    }
    public String inside(String name){
        return this.data.substring(this.data.indexOf("<"+name+">")+2+name.length(), this.data.indexOf("</"+name+">"));
    }
    public List<String> getHrefs(){
        List<String> list = new ArrayList<>();
        for(String line : this.processed.split("\n")){
            if (line.contains("href=\"")){
                String url = line.substring(line.indexOf("href=\"" )+6);
                if ((url.startsWith("https://") || (url.startsWith("http://")))) {
                    list.add(line.substring(line.indexOf("href=\"")+6, line.indexOf("\"", line.indexOf("href=\"")+10)));
                }
            }
        }
        return list;
    }
}
