package project.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    public DrugController(DrugService drugService) {
        this.drugService = drugService;

    }

    @RequestMapping(value = "/drugs", method = RequestMethod.GET)
    public String drugViewGet(Model model) {
        return "";
    }

    public String drugViewPost(Drug drug, Model model) {

    }

    public String drugByType(String type, Model model) {

    }

    public String drugByProducer(String prod, Model model) {

    }

    public String drugByName(String name, Model model) {

    }



}
