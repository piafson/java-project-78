package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    private final Map<String, Predicate<Object>> checks;

    protected BaseSchema() {
        this.checks = new HashMap<>();
    }

    protected final void addCheck(String key, Predicate<Object> check) {
        checks.put(key, check);
    }

    public final boolean isValid(Object inp) {
        return checks.values().stream().allMatch(check -> check.test(inp));
    }
}
