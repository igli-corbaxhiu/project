package com.lhind.project.controller;

import com.lhind.project.model.Trip;
import com.lhind.project.model.User;
import com.lhind.project.service.TripService;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping(value = "/trip")
    public ModelAndView showForm(ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();

        Trip trip = new Trip();
        modelAndView.addObject("trip", trip);

        List<String> tripReason = Arrays.asList("Meeting", "Training", "Project", "Workshop", "Event", "Other");
        modelMap.addAttribute("tripReason", tripReason);
        modelAndView.setViewName("trip");

        return modelAndView;
    }

    @PostMapping(value = "/trip")
    public ModelAndView submitForm(@Valid @ModelAttribute("trip") Trip trip,
                                   BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()) {
            modelAndView.addObject("successMessage", "Please correct the errors in form!");
            modelMap.addAttribute("bindingResult", bindingResult);
            List<String> tripReason = Arrays.asList("Meeting", "Training", "Project", "Workshop", "Event", "Other");
            modelMap.addAttribute("tripReason", tripReason);
        }else {
            tripService.save(trip);
            modelAndView.addObject("successMessage", "Trip is registered successfully!");
        }
        modelAndView.addObject("trip", new Trip());
        modelAndView.setViewName("trip");
        return modelAndView;
    }
}
