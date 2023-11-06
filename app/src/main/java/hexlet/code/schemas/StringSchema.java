package hexlet.code.schemas;

public  class StringSchema {

    private String containsText = "";
    private int minLength;
    private boolean isRequired;
    private boolean isContains;
    private boolean isMinLength;

    public void required() {
        this.isRequired = true;
    }

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

    public boolean isValid(Object inp) {
        boolean isValid = true;

        if (isRequired) {
            if (inp == null) {
                return false;
            }
            if (inp.getClass().equals(Integer.class)) {
                return false;
            }
            isValid = inp.toString().length() > 0;
        }

        if (isContains) {
            if (inp == null) {
                return false;
            }

            isValid = inp.toString().contains(containsText);
        }

        if (isMinLength) {
            if (inp == null) {
                return false;
            }
            isValid = inp.toString().length() >= minLength;
        }

        return isValid;
    }
}
