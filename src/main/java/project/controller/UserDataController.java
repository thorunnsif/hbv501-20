package project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.UserData;
import project.service.UserDataService;

/**
 * Created by EiríkurAtli on 4.11.2016.
 */
@Controller
public class UserDataController {

    // Instance Variables
    UserDataService userDataService;

    // Dependency Injection
    @Autowired
    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
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
    //public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response, UserData userData)
    public String displayLogin(Model model)
    {
        //ModelAndView model = new ModelAndView("login");
        //LoginBean loginBean = new LoginBean();
        //model.addObject("loginBean", userData);
        //return model;
        model.addAttribute("userData", new UserData());

        // Return the view
        return "Login";

    }
    @RequestMapping(value="/login",method = RequestMethod.POST)

    //public ModelAndView executeLogin(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("loginBean")LoginBean loginBean)
    public String executeLogin(@ModelAttribute("userData") UserData userData, Model model){
    {
        try
        {
            int isValidUser = userDataService.isValidUser(userData.getUsername(), userData.getPassword());

            if(isValidUser > 0)
            {
                System.out.println("User Login Successful");
                model.addAttribute("loggedInUser", userData.getUsername());
                //model = new Model("welcome");

                // reset login Counter
                return "Home";
            }
            else
            {
                //model = new ModelAndView("login");
                System.out.println("Login Screwup!!!!");
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
}

}
