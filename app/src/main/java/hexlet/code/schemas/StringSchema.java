package hexlet.code.schemas;

public class StringSchema  extends BaseSchema {

    private String containsText = "";
    private int minLength;
    private boolean isRequired;
    private boolean isContains;
    private boolean isMinLength;

    public StringSchema minLength(int len) {
        this.isMinLength = true;
        this.minLength = len;
        return this;

    }

    public StringSchema contains(String inp) {
        this.containsText = inp;
        this.isContains = true;
        return this;
    }

    @Override
    public boolean isValid(Object inp) {

        if (getRequired()) {
            if (inp == null) {
                return false;
            }
            if (!inp.getClass().equals(String.class)) {
                return false;
            }
            setValid(inp.toString().length() > 0);
        }

        if (isContains) {
            setValid(inp.toString().contains(containsText));
        }

        if (isMinLength) {
            setValid(inp.toString().length() >= minLength);
        }

        return getValid();
    }
}
