package org.launchcode.crudnotes.data;

import org.launchcode.crudnotes.models.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {
}
