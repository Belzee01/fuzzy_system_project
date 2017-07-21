package dto;

import java.util.List;

public class Platforms {

    private List<PLATFORMS> platform;

    private boolean validate(String value) {

        if (value.toLowerCase().contains("pc")) {
            this.platform.add(PLATFORMS.PC);
            return true;
        }
        if (value.toLowerCase().contains("ps")) {
            this.platform.add(PLATFORMS.PS);
            return true;
        }
        if (value.toLowerCase().contains("xbox")) {
            this.platform.add(PLATFORMS.XBOX);
            return true;
        }

        return false;
    }

    @Override
    public String toString() {
        return "Platforms{" +
                "platform=" + platform +
                '}';
    }

    public void assign(List<String> platforms) {
        platforms.forEach(this::validate);
    }

    private enum PLATFORMS {
        PC("pc"),
        PS("ps"),
        XBOX("xbox");

        private PLATFORMS(String value) {
            this.value = value;
        }

        private final String value;

        @Override
        public String toString() {
            return this.value;
        }
    }
}
