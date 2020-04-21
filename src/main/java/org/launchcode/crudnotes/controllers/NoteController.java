package org.launchcode.crudnotes.controllers;

import org.launchcode.crudnotes.data.NoteCategoryRepository;
import org.launchcode.crudnotes.data.NoteRepository;
import org.launchcode.crudnotes.models.Note;
import org.launchcode.crudnotes.models.NoteCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@Controller
@RequestMapping("notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private NoteCategoryRepository noteCategoryRepository;

    @GetMapping
    public String displayAllNotes(@RequestParam(required = false) Integer categoryId, Model model) {

        if (categoryId == null) {
            model.addAttribute("title", "All Notes");
            model.addAttribute("notes", noteRepository.findAll());
        } else {
            Optional<NoteCategory> result = noteCategoryRepository.findById(categoryId);
            if(result.isEmpty()) {
                model.addAttribute("title", "Invalid Category ID: " + categoryId);
            } else {
                NoteCategory category = result.get();
                model.addAttribute("title", "Notes in category: " + category.getName());
                model.addAttribute("notes", category.getNotes());
            }
        }

        return "notes/index";
    }

    @GetMapping("create")
    public String displayCreateNoteForm(Model model) {
        model.addAttribute("title", "Create Note");
        model.addAttribute(new Note());
        model.addAttribute("categories", noteCategoryRepository.findAll());
        return "notes/create";
    }

    @PostMapping("create")
    public String processCreateNoteForm(@ModelAttribute @Valid Note newNote,
                                        Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Note");
            return "notes/create";
        }
        noteRepository.save(newNote);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteNoteForm(Model model) {
    model.addAttribute("title", "Delete Notes");
    model.addAttribute("notes", noteRepository.findAll());
    return "notes/delete";
    }

    @PostMapping("delete")
    public String processDeleteNotesForm(@RequestParam(required = false) int[] noteIds) {

        if(noteIds != null) {
            for (int id : noteIds) {
                noteRepository.deleteById(id);
            }
        }
        return "redirect:";
    }
}
