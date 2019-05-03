package top.bertz.calculator;

public class Result {

    private final long counts;
    private final String result;

    public Result(long counts, String result) {
        this.counts = counts;
        this.result = result;
    }

    public long getcounts() {
        return counts;
    }

    public String getresult() {
        return result;
    }
}
