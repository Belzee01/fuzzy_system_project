package dto;

import java.util.List;

public class Tags {

    private List<TAGS> tags;

    private boolean validate(String value) {

        if (value.toLowerCase().contains("rpg")) {
            this.tags.add(TAGS.PC);
            return true;
        }
        if (value.toLowerCase().contains("ps")) {
            this.tags.add(TAGS.PS);
            return true;
        }
        if (value.toLowerCase().contains("xbox")) {
            this.tags.add(TAGS.XBOX);
            return true;
        }

        return false;
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
        PC("pc"),
        PS("ps"),
        XBOX("xbox");

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
