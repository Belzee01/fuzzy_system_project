package dto;

import java.util.List;

public class Tags {

    private List<TAGS> tags;

    private void validate(String value) {
        switch (value.toLowerCase()) {
            case "fps" : tags.add(TAGS.FPS);
                break;
            case "racing": tags.add(TAGS.RACING);
                break;
            case "rts" : tags.add(TAGS.RTS);
                break;
            case "rpg" : tags.add(TAGS.RPG);
                break;
            case "sport" : tags.add(TAGS.SPORT);
                break;
            case "tactical" : tags.add(TAGS.TACTICAL);
                break;
            case "adventure" : tags.add(TAGS.ADVENTURE);
                break;
            case "arcade" : tags.add(TAGS.ARCADE);
                break;
            default: break;
        }
    }

    @Override
    public String toString() {
        return "Platforms{" +
                "platform=" + tags +
                '}';
    }

    public void assign(List<String> platforms) throws IllegalArgumentException {
        platforms.forEach(this::validate);

        if (tags.isEmpty())
            throw new IllegalArgumentException("Tag list cannot be empty!");
    }

    private enum TAGS {
        RPG("rpg"),
        ADVENTURE("adventure"),
        FPS("fps"),
        RACING("racing"),
        RTS("rts"),
        SPORT("sport"),
        TACTICAL("tactical"),
        ARCADE("arcade");


        private TAGS(String value) {
            this.value = value;
        }

        private final String value;

        @Override
        public String toString() {
            return this.value;
        }
    }

}
