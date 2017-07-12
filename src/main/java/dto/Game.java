package dto;

import java.util.List;

public class Game {
    private String title;
    private Double price;
    private List<String> platforms;
    private List<String> tags;

    public Game(String title, Double price, List<String> platforms, List<String> tags) {
        this.title = title;
        this.price = price;
        this.platforms = platforms;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}

