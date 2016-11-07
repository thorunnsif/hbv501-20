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

    // Method that returns the correct view for the URL /userData
    // This handles the GET request for this URL
    @RequestMapping(value = "/user_data", method = RequestMethod.GET)
    public String userDataViewGet(Model model){

        // Add a new Postit Note to the model for the form
        // If you look at the form in PostitNotes.jsp, you can see that we
        // reference this attribute there by the name `postitNote`.
        model.addAttribute("userData",new UserData());

        // Here we get all the Postit Notes (in a reverse order) and add them to the model
        model.addAttribute("userDataList",userDataService.findAllReverseOrder());

        // Return the view
        return "UserData";
    }

    // Method that receives the POST request on the URL /postit
    // and receives the ModelAttribute("postitNote")
    // That attribute is the attribute that is mapped to the form, so here
    // we can save the postit note because we get the data that was entered
    // into the form.
    // Notice the `method = RequestMethod.POST` part
    @RequestMapping(value = "/user_data", method = RequestMethod.POST)
    public String userDataViewPost(@ModelAttribute("userData") UserData userData,
                                     Model model){

        // Save the Postit Note that we received from the form
        userDataService.save(userData);

        // Here we get all the Postit Notes (in a reverse order) and add them to the model
        model.addAttribute("userDataList", userDataService.findAllReverseOrder());

        // Add a new Postit Note to the model for the form
        // If you look at the form in PostitNotes.jsp, you can see that we
        // reference this attribute there by the name `postitNote`.
        model.addAttribute("userData", new UserData());

        // Return the view
        return "UserData";
    }


    // Method that returns the correct view for the URL /postit/{name}
    // The {name} part is a Path Variable, and we can reference that in our method
    // parameters as a @PathVariable. This enables us to create dynamic URLs that are
    // based on the data that we have.
    // This method finds all Postit Notes posted by someone with the requested {name}
    // and returns a list with all those Postit Notes.
    @RequestMapping(value = "/user_data/{username}", method = RequestMethod.GET)
    public String UserDataGetNotesFromUserName(@PathVariable String username,
                                             Model model){

        // Get all Postit Notes with this name and add them to the model
        model.addAttribute("userDataList", userDataService.findByUsername(username));

        // Add a new Postit Note to the model for the form
        // If you look at the form in PostitNotes.jsp, you can see that we
        // reference this attribute there by the name `postitNote`.
        model.addAttribute("userData", new UserData());

        // Return the view
        return "UserData";
    }

}
