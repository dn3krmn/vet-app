package com.dk.vetapp.controller;

import com.dk.vetapp.dto.OwnerDto;
import com.dk.vetapp.service.OwnerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class OwnerController {

    private OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    //create handler method GET request and return model and view
    @GetMapping("/owners")
    public String owners(Model model){
        List<OwnerDto> owners = ownerService.findAllOwner();
        model.addAttribute("owners",owners);

        return "/owners";
    }

    //handler method to handle new owner request
    @GetMapping("owners/addowner")
    public String addOwner(Model model){
        OwnerDto ownerDto = new OwnerDto();
        model.addAttribute("owner", ownerDto);
        return "add_owner";
    }

    //handler method to handle form submit request
    @PostMapping("/owners")
    public String addOwner(@Valid @ModelAttribute("owner") OwnerDto ownerDto, BindingResult result, Model model){

        if(result.hasErrors()){
            model.addAttribute("owner", ownerDto);
            return "add_owner";
        }
        ownerService.addOwner(ownerDto);
        return "redirect:/owners";
    }

    //handler method to handle edit owner request
    @GetMapping("/owners/{ownerId}/edit")
    public String editOwner(@PathVariable("ownerId") int ownerId, Model model){
        OwnerDto ownerDto = ownerService.findOwnerById(ownerId);
        model.addAttribute("owner",ownerDto);
        return "edit_owner";
    }

    //handler method to handle edit owner form submit request
    @PostMapping("/owners/{ownerId}")
    public String updateOwner(@PathVariable("ownerId") int ownerId,
                              @Valid @ModelAttribute("owner") OwnerDto owner,
                              BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("owner", owner);
            return "edit_owner";
        }
        owner.setOwnerId(ownerId);
        ownerService.updateOwner(owner);
        return "redirect:/owners";
    }

    //handler method to handle delete owner request
    @GetMapping("/owners/{ownerId}/delete")
    public String deleteOwner(@PathVariable("ownerId") int ownerId){
        ownerService.deleteOwner(ownerId);
        return "redirect:/owners";
    }
}
