package dto;

import java.util.List;

public class Game implements Comparable<Game> {
    private String title;
    private Double price;
    private Platforms platforms;
    private Tags tags;

    private Double value;

    public Game(String title, Double price, List<String> platforms, List<String> tags) throws IllegalArgumentException {
        this.title = title;
        this.price = price;
        this.platforms = new Platforms();
        this.platforms.assign(platforms);
        this.tags = new Tags();
        this.tags.assign(tags);
        this.value = 0.0;
    }

    public Double getPrice() {
        return price;
    }

    public Platforms getPlatforms() {
        return platforms;
    }

    public Tags getTags() {
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
                ", platforms=" + platforms.toString() +
                ", tags=" + tags.toString() +
                '}';
    }

    @Override
    public int compareTo(Game o) {
        return value.compareTo(o.getValue());
    }
}

