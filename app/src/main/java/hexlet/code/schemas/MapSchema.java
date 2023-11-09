package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema extends BaseSchema {

    public MapSchema required() {
        addCheck(
                "required",
                Objects::nonNull
        );
        return this;
    }

    public MapSchema sizeof(int len) {
        addCheck(
                "sizeof",
                value -> {
                    Map<String, Object> map = (Map<String, Object>) value;
                    if (len > 0) {
                        return map.size() == len;
                    } else {
                        return true;
                    }
                }
        );
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> inp) {
        addCheck(
                "shape",
                value -> {
                    boolean valid = true;
                    Map<String, BaseSchema> map = (Map<String, BaseSchema>) value;
                    for (Map.Entry entry : map.entrySet()) {
                        if (!inp.get(entry.getKey()).isValid(entry.getValue())) {
                            valid = false;
                        }
                    }
                    return valid;
                }
        );
        return this;
    }
}
