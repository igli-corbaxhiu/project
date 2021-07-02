package com.lhind.project.controller;

import com.lhind.project.model.Flight;
import com.lhind.project.model.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
public class FlightController {

    @GetMapping("/register")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        List<String> listProfession = Arrays.asList("Developer", "Tester", "Architect");
        model.addAttribute("listProfession", listProfession);

        return "register_form";
    }

    @PostMapping("/register")
    public String submitForm(@Valid @ModelAttribute("flight") Flight flight,
                             BindingResult bindingResult, Model model) {
        System.out.println(flight);

        if (bindingResult.hasErrors()) {
            List<String> trips = Arrays.asList("Developer", "Tester", "Architect");
            model.addAttribute("listProfession", listProfession);

            return "register_form";
        } else {
            return "register_success";
        }
    }

}
