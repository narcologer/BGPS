package com.example.demo.controller;

import com.example.demo.dao.JournalRecordJdbc;
import com.example.demo.model.JournalRecord;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalRecordController {

    private final JournalRecordJdbc journalRecordJdbc;

    public JournalRecordController(JournalRecordJdbc journalRecordJdbc) {
        this.journalRecordJdbc = journalRecordJdbc;
    }

    @GetMapping("")
    public List<JournalRecord> getJournalRecords() {
        return journalRecordJdbc.getAll();
    }

    @GetMapping("/{id}")
    public JournalRecord getJournalRecord(@PathVariable int id) {
        return journalRecordJdbc.get(id);
    }

    @GetMapping("/student/{studentId}")
    public List<JournalRecord> getJournalRecordsByStudent(@PathVariable int studentId) {
        return journalRecordJdbc.getAllByStudent(studentId);
    }

    @GetMapping("/study_group/{studyGroupId}")
    public List<JournalRecord> getJournalRecordsByStudyGroup(@PathVariable int studyGroupId) {
        return journalRecordJdbc.getAllByStudyGroup(studyGroupId);
    }

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public long addJournalRecord(@RequestBody JournalRecord journalRecord) {
        return journalRecordJdbc.create(journalRecord);
    }

    @PutMapping("/{id}")
    public int updateJournalRecord(@PathVariable int id, @RequestBody JournalRecord journalRecord) {
        journalRecordJdbc.update(id, journalRecord);
        return 0;
    }

    @DeleteMapping("/{id}")
    public int deleteJournalRecord(@PathVariable int id) {
        journalRecordJdbc.delete(id);
        return 0;
    }
}

