package project.controller;

import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.UserData;
import project.service.DrugService;
import project.service.UserDataService;

/**
 * Created by EiríkurAtli on 3.4.2017.
 */
@Controller
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
        System.out.println(jsonString);
        if (jsonString == null) {
            return new ResponseEntity<String>("No user found", HttpStatus.OK);
        }
        JSONObject jsonObject = new JSONObject(jsonString);
        String loginEmail = jsonObject.getString("email");
        String loginPassword = jsonObject.getString("password");

        //Check if user is found with this email address
        if(userDataService.findByEmail(loginEmail)==null){
            return new ResponseEntity<String>("No user with that email", HttpStatus.OK);
        }

        //Get userData for the logged in user and pass to Android in JSON
        UserData user = userDataService.findByEmail(loginEmail);
        System.out.println(user.getFirstName()+" "+user.getLastName()+" "+user.getAddress()+" "+user.getUsername() );
        String userPassword = user.getPassword();
        Gson gson = new Gson();

        // Java object to JSON, and assign to a String
        String json = gson.toJson(user);

        if(loginPassword.compareTo(userPassword) <= 0) {
            return new ResponseEntity<String>(json, HttpStatus.OK);
        }


        return new ResponseEntity<String>("No user with that email and password", HttpStatus.OK);
    }


    @RequestMapping(value="/m/register", method = RequestMethod.GET)
    public @ResponseBody UserData createUser(@RequestParam String email) {
        return userDataService.findByEmail(email);
    }


    public UserData parseUserData(String jsonString) throws JSONException {
        System.out.println("jsonStr:  " + jsonString);
        JSONObject jsonObject = new JSONObject(jsonString);

        //Gson gson = new Gson();
        //UserData user = gson.fromJson(jsonString, UserData.class);

        UserData user = new UserData();
        user.setUsername(jsonObject.getString("username"));
        user.setPassword(jsonObject.getString("password"));
        user.setEmail(jsonObject.getString("email"));
        user.setFirstName(jsonObject.getString("firstName"));
        user.setLastName(jsonObject.getString("lastName"));
        user.setAccountType(jsonObject.getInt("accountType"));
        user.setAddress(jsonObject.getString("address"));
        user.setCity(jsonObject.getString("city"));
        user.setLoginCounter(jsonObject.getInt("loginCounter"));
        user.setPhoneNo(jsonObject.getInt("phoneNo"));
        user.setSocial(jsonObject.getInt("social"));
        user.setZip(jsonObject.getInt("zip"));

        return user;
    }


    @RequestMapping(value="/m/register",method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestBody String jsonString) throws JSONException {

        UserData formUser = this.parseUserData(jsonString);
        JSONObject jsonObject = validateAndroid(formUser);

        if(jsonObject.length() > 0){
            return new ResponseEntity<String>(jsonObject.toString(), HttpStatus.OK);
        }

        //the formUser is saved and the saved user returned
        userDataService.save(formUser);

        return new ResponseEntity<String>("OK", HttpStatus.OK);
/*
        JSONObject jsonObject = new JSONObject(jsonString);
        String registerEmail = jsonObject.getString("email");
        System.out.println(registerEmail);

        // Check if email already has account
        if(userDataService.findByEmail(registerEmail)!=null){
            return new ResponseEntity<String>("Account already created with this email address", HttpStatus.OK);
        }

        //Create UserData from JSON and save to database
        Gson gson = new Gson();
        UserData newUser = gson.fromJson(jsonString, UserData.class);
        userDataService.save(newUser);

        return new ResponseEntity<String>("Registration complete", HttpStatus.OK);
*/
    }



    public JSONObject validateAndroid(UserData user) throws JSONException{
        JSONObject jsonObject = new JSONObject();
        if (user.getUsername().length() <= 3 || user.getUsername().length() > 32 ) {
            jsonObject.append("userName", "Username has to be between 4 and 32 letters");
        }

        if(!user.getPassword().equals(user.getPassword())) {
            jsonObject.append("passwordConfirm", "Passwords do not match");
        }

        if(userDataService.findByEmail(user.getEmail()) != null){
            jsonObject.append("email", "Email address is taken");
        }
        return jsonObject;
    }

}
