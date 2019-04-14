package top.bertz.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.bertz.calculator.Calculate;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CalculatorController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("home");

        return mv;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");

        return mv;
    }

    @RequestMapping(value = {"/calculator"}, method = RequestMethod.GET)
    public ModelAndView setInput() {
        ModelAndView mv = new ModelAndView("calculator");

        return mv;
    }

    @RequestMapping(value = {"/result"}, method = RequestMethod.POST)
    public ModelAndView getResult(HttpServletRequest res) {

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
