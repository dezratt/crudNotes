package org.launchcode.crudnotes.controllers;

import org.launchcode.crudnotes.data.NoteRepository;
import org.launchcode.crudnotes.models.Note;
import org.launchcode.crudnotes.models.NoteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping
    public String displayAllNotes(Model model) {
        model.addAttribute("title", "All Notes");
        model.addAttribute("notes", noteRepository.findAll());
        return "notes/index";
    }

    @GetMapping("create")
    public String displayCreateNoteForm(Model model) {
        model.addAttribute("title", "Create Note");
        model.addAttribute(new Note());
        model.addAttribute("types", NoteType.values());
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
