package org.launchcode.crudnotes.data;


import org.launchcode.crudnotes.models.NoteCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteCategoryRepository extends CrudRepository<NoteCategory, Integer> {

}
