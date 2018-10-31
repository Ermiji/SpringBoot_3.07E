package me.ermias.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/")
    public String home(Model model){
        //First create a Person
        Person person = new Person();
        person.setName("Ermias G");
        person.setSsn("555-333-2222");

        //create a Passport
        Passport passport = new Passport();
        passport.setPassportNumber(444344434);
        passport.setExpirationDate("10-23-2022");

        //Add the passport to person
        person.setPassport(passport);

        //Save person to database
        personRepository.save(person);

        //Grab all the persons from database and send them to the
        //template
        model.addAttribute("persons",personRepository.findAll());

        return "home";
    }
}
