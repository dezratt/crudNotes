package org.launchcode.crudnotes.controllers;


import org.launchcode.crudnotes.data.NoteCategoryRepository;
import org.launchcode.crudnotes.models.NoteCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("noteCategories")
public class NoteCategoryController {

    @Autowired
    private NoteCategoryRepository noteCategoryRepository;

    @GetMapping
    public String displayAllCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("categories", noteCategoryRepository.findAll());
        return "noteCategories/index";
    }

    @GetMapping("create")
    public String renderCreateNoteCategoryForm(Model model) {
        model.addAttribute("title", "Create Category");
        model.addAttribute(new NoteCategory());
        return "noteCategories/create";
    }

    @PostMapping("create")
    public String processCreateNoteCategoryForm(@Valid @ModelAttribute NoteCategory noteCategory,
                                                Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Category");
            model.addAttribute(new NoteCategory());
            return "noteCategories/create";
        }

        noteCategoryRepository.save(noteCategory);
        return "redirect:";
    }
}
