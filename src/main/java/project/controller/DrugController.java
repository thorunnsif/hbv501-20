package project.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Drug;
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

    @RequestMapping(value = "/drugs", method = RequestMethod.GET)
    public String drugViewGet(Model model) {
        model.addAttribute("drugs", drugService.findAllReverseOrder());
        return "drugs/Drugs";
    }

    @RequestMapping(value = "/drugs", method = RequestMethod.POST)
    public String drugViewPost(Drug drug, Model model) {
        drugService.save(drug);
        model.addAttribute("drugs", drugService.findAllReverseOrder());
        model.addAttribute("drug", new Drug());
        return "drugs/Drugs";
    }
    @RequestMapping(value = "/drugs/{name}", method = RequestMethod.GET)
    public String drugByType(String type, Model model) {
        return "";
    }

    public String drugByProducer(String prod, Model model) {
        return "";
    }

    public String drugByName(@PathVariable String name, Model model) {
        return "";
    }



}
