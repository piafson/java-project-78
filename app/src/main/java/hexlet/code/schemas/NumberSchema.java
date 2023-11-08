package hexlet.code.schemas;

public class NumberSchema extends BaseSchema {
    private boolean isPositive;
    private boolean isRange;
    private int startValue;
    private int endValue;

    public NumberSchema positive() {
        this.isPositive = true;
        return this;
    }

    public NumberSchema range(int start, int end) {
        this.isRange = true;
        this.startValue = start;
        this.endValue = end;
        return this;
    }
    @Override
    public boolean isValid(Object inp) {
        if (getRequired()) {
            if (checkNull(inp) || !inp.getClass().equals(Integer.class)) {
                return false;
            }
            setValid(inp.toString().length() > 0);
        }

        if (isPositive) {
            if (!getRequired() && inp == null) {
                return true;
            }
            setValid((Integer) inp > 0);
        }

        if (isRange) {
            setValid((Integer) inp >= startValue && (Integer) inp <= endValue);
        }
        return getValid();
    }

    public boolean checkNull(Object inp) {
        return inp == null;
    }
}
