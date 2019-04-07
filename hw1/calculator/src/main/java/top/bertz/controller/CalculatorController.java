package top.bertz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.bertz.calculator.Result;
import top.bertz.calculator.Calculate;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CalculatorController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/calculator")
    public Result result(@RequestParam(value = "input", defaultValue = "ANS;") String input) {
        try {
            Calculate cals = new Calculate();

            //因为URI中不能带加号（加号会转成空格），而且这次没有写前端，传值只能通过GET方法来进行，所以在这里把URI中的空格转成了加号，使计算器能正确运算
            input = input.replace(' ', '+');


            String ret = cals.cal(input);
            return new Result(counter.incrementAndGet(), ret);
        } catch (Exception e) {
            System.out.println(e);
            return new Result(counter.incrementAndGet(), input);
        }
    }
}
