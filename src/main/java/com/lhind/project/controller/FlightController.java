package com.lhind.project.controller;

import com.lhind.project.model.Flight;
import com.lhind.project.service.FlightService;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView();
        Flight flight = new Flight();
        modelAndView.addObject("flight", flight);
        modelAndView.setViewName("flight");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView submitForm(@Valid @ModelAttribute("flight") Flight flight,
                                   BindingResult bindingResult, ModelMap modelMap) {
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()) {
            modelAndView.addObject("successMessage", "Please correct the errors in form!");
            modelMap.addAttribute("bindingResult", bindingResult);
        }else {
            flightService.save(flight);
            modelAndView.addObject("successMessage", "Flight is registered successfully!");
        }
        modelAndView.addObject("flight", new Flight());
        modelAndView.setViewName("flight");
        return modelAndView;
    }

}
