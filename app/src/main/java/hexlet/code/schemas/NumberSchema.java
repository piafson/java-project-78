package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        addCheck(
                "required",
                Objects::nonNull
        );
        return this;
    }

    public NumberSchema positive() {
        addCheck(
                "positive",
                value -> {
                    if (value == null) {
                        return true;
                    } else if (value.getClass().equals(Integer.class)) {
                        return (Integer) value > 0;
                    }
                    return false;
                }
        );
        return this;
    }

    public NumberSchema range(int start, int end) {
        addCheck(
                "range",
                value -> {
                    if (!(value.getClass().equals(Integer.class))) {
                        return true;
                    } else if (start == 0 && end == 0) {
                        return true;
                    }
                    return (Integer) value >= start && (Integer) value <= end;
                }
        );
        return this;
    }
}
