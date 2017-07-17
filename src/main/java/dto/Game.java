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

    public Double getPrice() {
        return price;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public List<String> getTags() {
        return tags;
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

