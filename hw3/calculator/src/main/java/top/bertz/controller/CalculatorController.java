package top.bertz.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.bertz.calculator.Calculate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CalculatorController {

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public ModelAndView setInput() {
        ModelAndView mv = new ModelAndView("calculator");

        return mv;
    }

    @RequestMapping(value = {"/result"}, method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ModelAndView getResult(HttpServletRequest res, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        String input = res.getParameter("input");
        ModelAndView mv = new ModelAndView("calculator");
        mv.addObject("input", input);

        try {
            Calculate cals = new Calculate();

            String ret = cals.cal(input);

            mv.addObject("result", ret);

            return mv;
        } catch (Exception e) {
            mv.addObject("result", "error");

            return mv;
        }

    }

}
