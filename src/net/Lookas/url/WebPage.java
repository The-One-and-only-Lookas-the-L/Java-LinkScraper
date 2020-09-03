package net.Lookas.url;

public class WebPage {
    private final String data;
    private final String name;
    private final String url;

    public WebPage(String name, String url, String data){
        this.data = data;
        this.url = url;
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public String getData(){
        return this.data;
    }
    public String getUrl(){
        return this.url;
    }
}
