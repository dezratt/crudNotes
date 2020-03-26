package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("notes")
public class NoteController {

    private static List<String> notes = new ArrayList<>();

    @GetMapping
    public String displayAllNotes(Model model) {
        model.addAttribute("title", "All Notes");
        model.addAttribute("notes", notes);
        return "notes/index";
    }

    @GetMapping("create")
    public String displayCreateNoteForm(Model model) {
        model.addAttribute("title", "Create Note");
        return "notes/create";
    }

    @PostMapping("create")
    public String processCreateNoteForm(@RequestParam String noteName) {
        notes.add(noteName);
        return "redirect:";
    }

}
