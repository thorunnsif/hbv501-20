package project.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.UserData;
import project.service.DrugService;
import project.service.UserDataService;

/**
 * Created by EiríkurAtli on 3.4.2017.
 */
public class MobileUserDataController {

    // Instance Variables
    private UserDataService userDataService;
    private DrugService drugService;
    private UserData loggedInUser;
    private boolean loggedIn;


    // Dependency Injection
    @Autowired
    public MobileUserDataController(UserDataService userDataService, DrugService drugService) {
        this.userDataService = userDataService;
        this.drugService = drugService;
        loggedIn = false;
        loggedInUser = null;
    }
/*
    @RequestMapping(value="/m/login",method = RequestMethod.GET)
    public String displayLogin(Model model)
    {

        //LoginBean loginBean = new LoginBean();
        //model.addObject("loginBean", userData);
        //return model;
        if (loggedIn) {
            model.addAttribute("loggedInUser", loggedInUser);
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
*/
    @RequestMapping(value="/m/login",method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody String jsonString) throws JSONException {
        JSONObject jsonObject = new JSONObject(jsonString);
        String loginUsername = jsonObject.getString("email");
        String loginPassword = jsonObject.getString("password");
        //String encodedLoginPassword = passwordEncoder.encode(loginPassword);

        if(userDataService.findOne(loginUsername)==null){
            return new ResponseEntity<String>("No user with that email", HttpStatus.OK);
        }

        UserData user = userDataService.findOne(loginUsername);
        String userPassword = user.getPassword();

        if(loginPassword.compareTo(userPassword) <= 0) {
            return new ResponseEntity<String>("OK", HttpStatus.OK);
        }


        return new ResponseEntity<String>("No user with that email and password", HttpStatus.OK);
    }

}
