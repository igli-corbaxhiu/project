package com.lhind.project.controller;

import com.lhind.project.model.Trip;
import com.lhind.project.model.User;
import com.lhind.project.repository.UserRepository;
import com.lhind.project.service.TripService;
import com.lhind.project.service.UserService;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/login/user")
public class TripController {

    private final TripService tripService;
    private final UserService userService;
    private final UserRepository userRepository;

    public TripController(TripService tripService, UserService userService, UserRepository userRepository) {
        this.tripService = tripService;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/trip")
    public ModelAndView showForm(ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        Trip trip = new Trip();
        modelAndView.addObject("trip", trip);
        List<String> tripReason = Arrays.asList("Meeting", "Training", "Project", "Workshop", "Event", "Other");
        modelMap.addAttribute("tripReason", tripReason);
        modelMap.addAttribute("users", userService.findAll());
        modelAndView.setViewName("trip");

        return modelAndView;
    }

    @PostMapping("/trip")
    public ModelAndView submitForm(@Valid @ModelAttribute("trip") Trip trip,
                                   BindingResult bindingResult, ModelMap modelMap,
                                   @RequestParam(value = "user_id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()) {
            modelAndView.addObject("successMessage", "Please correct the errors in form!");
            modelMap.addAttribute("bindingResult", bindingResult);
            List<String> tripReason = Arrays.asList("Meeting", "Training", "Project", "Workshop", "Event", "Other");
            modelMap.addAttribute("tripReason", tripReason);
            modelMap.addAttribute("users", userService.findAll());

        }else {
            User user = userRepository.findById(id);
            trip.setUser(user);
            tripService.save(trip);
            tripService.save(trip);
            modelAndView.addObject("successMessage", "Trip is registered successfully!");
            List<String> tripReason = Arrays.asList("Meeting", "Training", "Project", "Workshop", "Event", "Other");
            modelMap.addAttribute("tripReason", tripReason);
            modelMap.addAttribute("users", userService.findAll());
        }

        modelAndView.addObject("trip", trip);
        modelAndView.setViewName("trip");
        return modelAndView;
    }
}
