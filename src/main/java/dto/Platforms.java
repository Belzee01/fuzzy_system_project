package dto;

import java.util.List;

public class Platforms {

    private List<PLATFORMS> platform;

    private void validate(String value) {

        if (value.toLowerCase().contains("pc")) {
            if (!platform.contains(PLATFORMS.PC))
                this.platform.add(PLATFORMS.PC);
        }
        if (value.toLowerCase().contains("ps")) {
            if (!platform.contains(PLATFORMS.PS))
                this.platform.add(PLATFORMS.PS);
        }
        if (value.toLowerCase().contains("xbox")) {
            if (!platform.contains(PLATFORMS.XBOX))
                this.platform.add(PLATFORMS.XBOX);
        }
    }

    @Override
    public String toString() {
        return "Platforms{" +
                "platform=" + platform +
                '}';
    }

    public void assign(List<String> platforms) throws IllegalArgumentException {
        platforms.forEach(this::validate);

        if (platform.isEmpty())
            throw new IllegalArgumentException("Platform list cannot be empty!");
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
