package top.bertz.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.bertz.wordladder.WordLadder;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/wordladder")
public class WordLadderController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView getInput() {
//        ClassPathResource dict = new ClassPathResource("static/small.json");
//        WordLadder wl = new WordLadder(dict.getInputStream());
//        JSONObject result = new JSONObject();
//        result.put("has", wl.find(word));
//        result.put("status" , 200);

        ModelAndView mv = new ModelAndView("wordladder");

        return mv;
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView getWordLadder(HttpServletRequest input) throws IOException {
        ClassPathResource dict = new ClassPathResource("static/small.json");
        WordLadder wl = new WordLadder(dict.getInputStream());
        String stratword = input.getParameter("startword");
        String endword = input.getParameter("endword");

        ModelAndView mv = new ModelAndView("wordladder");
        mv.addObject("startword", stratword);
        mv.addObject("endword", endword);

        if (!wl.find(stratword))
            mv.addObject("result", "Cannot find startword: "+stratword+".");
        else if (!wl.find(stratword))
            mv.addObject("result", "Cannot find endword: "+endword+".");
        else {
            ArrayList<String> list = wl.BFS(stratword, endword);
            mv.addObject("result", list);
        }
//        JSONArray result = JSONArray.fromObject(list);
//        JSONObject response = new JSONObject();
//        response.put("result", result);
//        response.put("status", 200);
        return mv;
    }

}
