package hexlet.code.schemas;

public final class StringSchema  extends BaseSchema {

    public StringSchema required() {
        addCheck(
                "required",
                value -> {
                    if (value == null || !(value instanceof String)) {
                        return false;
                    } else {
                        return !((String) value).equals("");
                    }
                }
        );
        return this;
    }

    public StringSchema minLength(int stringLen) {
        addCheck(
                "minLength",
                value -> {
                    if (!(value instanceof String) && stringLen == 0) {
                        return true;
                    } else {
                        return  ((String) value).length() >= stringLen;
                    }
                }
        );
        return this;
    }

    public StringSchema contains(String inp) {
        addCheck(
                "contains",
                value -> {
                    if (inp.equals("")) {
                        return true;
                    } else if (inp == null) {
                        return false;
                    }
                    return ((String) value).contains(inp);
                }
        );
        return this;
    }
}
