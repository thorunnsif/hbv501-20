package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Drug;
import project.persistence.entities.UserData;
import project.service.DrugService;
import project.service.UserDataService;

/**
 * Created by EiríkurAtli on 4.11.2016.
 * Controller for UserData, Login and more
 */
@Controller
public class UserDataController {

    // Instance Variables
    private UserDataService userDataService;
    private DrugService drugService;
    private UserData loggedInUser;
    private boolean loggedIn;


    // Dependency Injection
    @Autowired
    public UserDataController(UserDataService userDataService, DrugService drugService) {
        this.userDataService = userDataService;
        this.drugService = drugService;
        loggedIn = false;
        loggedInUser = null;
    }

    // Method that returns the correct view for the URL /user_data
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String userDataViewGet(Model model){

        // Add a new UserData to the model for the form
        model.addAttribute("userData",new UserData());

        model.addAttribute("userDataList",userDataService.findAllReverseOrder());

        // Return the view
        return "UserData";
    }

    // Method that receives the POST request on the URL /user_data
    // and receives the ModelAttribute("userData")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String userDataViewPost(@ModelAttribute("userData") UserData userData,
                                     Model model){

        // Save the UserData that we received from the form
        userDataService.save(userData);

        // Here we get the UserDataList (in a reverse order) and add it to the model
        model.addAttribute("userDataList", userDataService.findAllReverseOrder());

        // Add a new UserData to the model for the form
        model.addAttribute("userData", new UserData());

        // Return the view
        return "RegComplete";
    }


    // Method that returns the correct view for the URL /user_data/{name}
    // The {name} part is a Path Variable, and we can reference that in our method
    // parameters as a @PathVariable. This enables us to create dynamic URLs that are
    // based on the data that we have.
    @RequestMapping(value = "/register/{username}", method = RequestMethod.GET)
    public String userDataGetNotesFromUserName(@PathVariable String username,
                                             Model model){

        // Get UserDataList with this name and add them to the model
        model.addAttribute("userDataList", userDataService.findByUsername(username));

        // Add a new UserData to the model for the form
        model.addAttribute("userData", new UserData());

        // Return the view
        return "UserData";
    }

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String displayLogin(Model model)
    {

        //LoginBean loginBean = new LoginBean();
        //model.addObject("loginBean", userData);
        //return model;
        if (loggedIn) {
            model.addAttribute("drug", new Drug());
            return "Home";
        }
        else {
            model.addAttribute("loginData", new UserData());
            model.addAttribute("drug", new Drug());
            return "Login";
        }

        // Return the view
        //return "Login";

    }
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String executeLogin(@ModelAttribute("loginData") UserData userData, @ModelAttribute("drug") Drug drug, Model model)
    {
        try
        {
            int isValidUser = userDataService.isValidUser(userData.getUsername(), userData.getPassword());
            if (isValidUser > 0) {
                loggedIn = true;
            }
            if(loggedIn)
            {
                System.out.println("User Login Successful");
                model.addAttribute("loggedInUser", userData.getUsername());
                model.addAttribute("drug", new Drug());
                model.addAttribute("drugs", drugService.findByName(drug.getName()));

                // set user as logged in user
                loggedInUser = userData;

                // reset login Counter
                return "Home";
            }
            else
            {
                //model = new ModelAndView("login");
                System.out.println("Login Screw-up!!!!");
                model.addAttribute("message", "Username and/or password do not match!!");
                // Counter ++
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return "Login";
    }
/*
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String executeLogout(Model model) //@ModelAttribute("userData") Model model)
    {
        loggedInUser = null;
        loggedIn = false;
        System.out.println("Elvis Has Left The Building");

        model.addAttribute("userData", new UserData());

        return "Login";
    }
*/
}


