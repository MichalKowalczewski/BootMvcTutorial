package com.example.boot.controller;

import com.example.boot.dao.UserDAO;
import com.example.boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Controller
@RequestMapping("/sda")
//@SessionScope -  bean tworzony raz na sesje użytkownika (jeżeli otworzymy aplikacje np w innej przeglądarce, to zobaczymy w konsoli inicjalizacje)
//@RequestScoped - przy każdym odwołaniu się do beana jest tworzony nowy bean
//@ApplicationScoped - bean tworzony raz na całe życie aplikacji - używany może być np do połączeń z bazą danych
public class UserController {

    @Autowired
    UserDAO userDAO;

    @PostConstruct
    public void init(){
        System.out.println("zainicjalizowano stronę");
    }

    //index.html
    @RequestMapping("/main")
    public String mainPage(Model model){
        System.out.println("czy tu jestem?");
        //dostarczamy atrybut "users" który będzie dostępny w warstwie widoku
        model.addAttribute("users", userDAO.getUsers());
        return "index";
    }

    //pobieramy id ze ścieżki, przesyłamy do argumentu metody za pomocą adnotacji @PathVariable
    @RequestMapping("/main/{id}")
    public String mainPageId(@PathVariable("id") int id,
                           Model model){
        model.addAttribute("user", userDAO.getUserById(id));
        return "index";
    }


    //post.html
    @RequestMapping("/post")
    public String postPage(Model model){
        model.addAttribute("user", new User());
        return "post";
    }
    //lub też @PostMapping("/post") - w ten sposób mamy pewność że 'method' jest typu Post bez cudowania
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    //Za pomocą @Valid włączamy walidacje zmiennej - która została określona wewnątrz klasy modelu, BindingResult przechowuje wynik walidacji
    public String saveAction(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "post";
        }
        else {
            System.out.println("Added User: " + user.getFirstName() + " " + user.getLastName());
            return "index";
        }
    }

    //editable_list
    @RequestMapping("/editMain")
    public String editableMainPage(Model model){
        System.out.println("czy tu jestem?");
        model.addAttribute("users", userDAO.getUsers());
        return "editable_list";
    }

    //details.html
    //Za pomocą @RequestParam pobieramy wartość z "input" z pól widoku - mapujemy po 'name' - np 'th:name="id"' w editable_list.html w tym przypadku.
    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public String detailsPage(@RequestParam("id") int id, Model model){
        model.addAttribute("user", userDAO.getUserById(id));
        return "details";
    }




}
