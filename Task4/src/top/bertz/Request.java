package top.bertz;

public class Request {
    private Integer num;
    private Long time;

    public Request() {
        this.num = (int) (Math.random() * 100) % 5 + 1;
        this.time=System.currentTimeMillis();
    }


    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
