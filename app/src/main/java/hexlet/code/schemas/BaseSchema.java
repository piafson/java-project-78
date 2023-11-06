package hexlet.code.schemas;

abstract class BaseSchema {
    private boolean isValid = true;
    private boolean isRequired;
    public abstract boolean isValid(Object inp);

    public BaseSchema required() {
        this.isRequired = true;
        return this;
    }

    public boolean getRequired() {
        return isRequired;
    }

    public boolean getValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
