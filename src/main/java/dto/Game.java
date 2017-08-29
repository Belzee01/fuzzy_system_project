package dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Game implements Comparable<Game> {
    private String title;
    private Double price;
    private Platforms platforms;
    private Tags tags;
    private Integer score;
    private LocalDate date;

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

    public Game(String title, Double price, List<String> platforms, List<String> tags, Integer score, LocalDate date) throws IllegalArgumentException {
        this.title = title;
        this.price = price;
        this.platforms = new Platforms();
        this.platforms.assign(platforms);
        this.tags = new Tags();
        this.tags.assign(tags);
        this.value = 0.0;
        this.score = score;
        this.date = date;
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

    public Integer getScore() {
        return score;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.title + ";");

        sb.append(this.price).append(";");

        this.platforms.getPlatform().forEach(p -> sb.append(p).append(","));
        sb.append(";");

        this.tags.getTags().forEach(t -> sb.append(t).append(","));
        sb.append(";");

        sb.append(this.score).append(";");
        sb.append(this.date).append("\n");

        return sb.toString();
    }

    @Override
    public int compareTo(Game o) {
        return value.compareTo(o.getValue());
    }
}

