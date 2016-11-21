package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import project.service.DrugService;

/**
 * Created by thorunn on 05/11/16.
 */
@Controller

public class DrugController {
    private DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    /*@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String drugSearchGet(Model model) {
        model.addAttribute("drug", new Drug());
        //model.addAttribute("drugs", drugService.findAllReverseOrder());
        return "Home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String drugSearchPost(@ModelAttribute("drug") Drug drug, Model model) {
        model.addAttribute("drug", new Drug());
        model.addAttribute("drugs", drugService.findByName(drug.getName()));

        return "Home";
    }
/*
    @RequestMapping(value = "/drugs/{type}", method = RequestMethod.GET)
    public String drugByType(@PathVariable String type, Model model) {
        model.addAttribute("drugs", drugService.findByType(type));
        return "drugs/Drugs";
    }

    @RequestMapping(value = "/drugs/{activeIngr}", method = RequestMethod.GET)
    public String drugByActiveIngr(@PathVariable String activeIngr, Model model) {
        model.addAttribute("drugs", drugService.findByActiveIngr(activeIngr));
        return "drugs/Drugs";
    }

    @RequestMapping(value = "/drugs/{name}", method = RequestMethod.GET)
        public String drugByName(@PathVariable String name, Model model) {
            model.addAttribute("drugs", drugService.findByName(name));
            return "drugs/Drugs";
    }
*/


}
