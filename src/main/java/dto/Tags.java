package dto;

import java.util.List;

public class Tags {

    private List<TAGS> tags;

    private void validate(String value) {
        switch (value) {
            case "rpg" : tags.add(TAGS.RPG);
                break;
            case "action": tags.add(TAGS.ACTION);
                break;
            case "horror" : tags.add(TAGS.HORROR);
                break;
            case "adevnture" : tags.add(TAGS.ADVENTURE);
                break;
            case "scifi" : tags.add(TAGS.SCIFI);
                break;
            case "fantasy" : tags.add(TAGS.FANTASY);
                break;
            case "fps" : tags.add(TAGS.FPS);
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

    public void assign(List<String> platforms) {
        platforms.forEach(this::validate);
    }

    private enum TAGS {
        RPG("rpg"),
        ACTION("action"),
        HORROR("horror"),
        ADVENTURE("adevnture"),
        SCIFI("scifi"),
        FANTASY("fantasy"),
        FPS("fps");


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
