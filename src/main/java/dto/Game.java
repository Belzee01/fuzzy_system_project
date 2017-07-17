package dto;

import java.util.List;

public class Game implements Comparable<Game> {
    private String title;
    private Double price;
    private List<String> platforms;
    private List<String> tags;

    private Double value;

    public Game(String title, Double price, List<String> platforms, List<String> tags) {
        this.title = title;
        this.price = price;
        this.platforms = platforms;
        this.tags = tags;
        this.value = 0.0;
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

    public Double getValue() {
        return value;
    }

    public Game setValue(Double value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        return "Game{" + " value: " + value +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", platforms=" + platforms +
                ", tags=" + tags +
                '}';
    }

    @Override
    public int compareTo(Game o) {
        return value.compareTo(o.getValue());
    }
}

