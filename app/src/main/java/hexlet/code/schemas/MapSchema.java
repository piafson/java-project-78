package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;

public class MapSchema extends BaseSchema {
    private int sizeOfMap;
    private boolean isSizeOfMap;

    public MapSchema sizeof(int size) {
        this.isSizeOfMap = true;
        this.sizeOfMap = size;
        return this;
    }

    @Override
    public boolean isValid(Object inp) {
        if (getRequired()) {
            if (checkNull(inp) || !inp.getClass().equals(HashMap.class)) {
                return false;
            }
        }

        if (isSizeOfMap) {
            setValid(((Map<?, ?>) inp).size() == sizeOfMap);
        }

        return getValid();
    }

    public boolean checkNull(Object inp) {
        return inp == null;
    }
}
