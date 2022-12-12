package models;

import java.util.Objects;

public class KeyWrapper {

        private final String x;
        private final String y;

        public KeyWrapper(String x, String y) {
            this.x = x;
            this.y = y;
        }

    @Override
    public String toString() {
        return  x + ';' + y + ';';
    }

    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            KeyWrapper that = (KeyWrapper) o;
            return Objects.equals(x, that.x) &&
                    Objects.equals(y, that.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
}
