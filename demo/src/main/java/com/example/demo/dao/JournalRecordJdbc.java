package com.example.demo.dao;

import com.example.demo.model.JournalRecord;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JournalRecordJdbc {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    public JournalRecordJdbc(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("Journal")
                .usingGeneratedKeyColumns("id");
    }

    public long create(JournalRecord journalRecord) {
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("student_id", journalRecord.getStudent_id());
        parameters.put("study_plan", journalRecord.getStudy_plan_id());
        parameters.put("in_time", journalRecord.isIn_time());
        parameters.put("count", journalRecord.getCount());
        parameters.put("mark_id", journalRecord.getMark_id());

        return simpleJdbcInsert.executeAndReturnKey(parameters).longValue();
    }

    public List<JournalRecord> getAll() {
        return jdbcTemplate.query(
                "SELECT journal.id, student_id, study_plan, in_time, count, mark_id, " +
                        "CONCAT(student.surname, ' ', student.name, ' ', student.secondname) AS student_full_name, " +
                        "subject.name AS subject_name, subject.shortname AS subject_short_name, " +
                        "exam_type.type AS exam_type, mark.name AS mark_name, mark.value AS mark_value " +
                        "FROM journal " +
                        "INNER JOIN student ON journal.student_id = student.id " +
                        "INNER JOIN study_plan ON journal.study_plan = study_plan.id " +
                        "INNER JOIN subject ON study_plan.subject_id = subject.id " +
                        "INNER JOIN exam_type ON study_plan.exam_type_id = exam_type.id " +
                        "INNER JOIN mark ON journal.mark_id = mark.id ",
                this::mapJournal
        );
    }

    public JournalRecord get(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT journal.id, student_id, study_plan, in_time, count, mark_id, " +
                        "CONCAT(student.surname, ' ', student.name, ' ', student.secondname) AS student_full_name, " +
                        "subject.name AS subject_name, subject.shortname AS subject_short_name, " +
                        "exam_type.type AS exam_type, mark.name AS mark_name, mark.value AS mark_value " +
                        "FROM journal " +
                        "INNER JOIN student ON journal.student_id = student.id " +
                        "INNER JOIN study_plan ON journal.study_plan = study_plan.id " +
                        "INNER JOIN subject ON study_plan.subject_id = subject.id " +
                        "INNER JOIN exam_type ON study_plan.exam_type_id = exam_type.id " +
                        "INNER JOIN mark ON journal.mark_id = mark.id " +
                        "WHERE journal.id = ?",
                this::mapJournal,
                id
        );
    }

    public List<JournalRecord> getAllByStudent(int studentId) {
        return jdbcTemplate.query(
                "SELECT journal.id, student_id, study_plan, in_time, count, mark_id, " +
                        "CONCAT(student.surname, ' ', student.name, ' ', student.secondname) AS student_full_name, " +
                        "subject.name AS subject_name, subject.shortname AS subject_short_name, " +
                        "exam_type.type AS exam_type, mark.name AS mark_name, mark.value AS mark_value " +
                        "FROM journal " +
                        "INNER JOIN student ON journal.student_id = student.id " +
                        "INNER JOIN study_plan ON journal.study_plan = study_plan.id " +
                        "INNER JOIN subject ON study_plan.subject_id = subject.id " +
                        "INNER JOIN exam_type ON study_plan.exam_type_id = exam_type.id " +
                        "INNER JOIN mark ON journal.mark_id = mark.id " +
                        "WHERE student_id = ?",
                this::mapJournal,
                studentId
        );
    }

    public List<JournalRecord> getAllByStudyGroup(int studyGroupId) {
        return jdbcTemplate.query(
                "SELECT journal.id, student_id, study_plan, in_time, count, mark_id, " +
                        "CONCAT(student.surname, ' ', student.name, ' ', student.secondname) AS student_full_name, " +
                        "subject.name AS subject_name, subject.shortname AS subject_short_name, " +
                        "exam_type.type AS exam_type, mark.name AS mark_name, mark.value AS mark_value " +
                        "FROM journal " +
                        "INNER JOIN student ON journal.student_id = student.id " +
                        "INNER JOIN study_plan ON journal.study_plan = study_plan.id " +
                        "INNER JOIN subject ON study_plan.subject_id = subject.id " +
                        "INNER JOIN exam_type ON study_plan.exam_type_id = exam_type.id " +
                        "INNER JOIN mark ON journal.mark_id = mark.id " +
                        "WHERE study_group_id = ?",
                this::mapJournal,
                studyGroupId
        );
    }

    public void update(int id, JournalRecord journalRecord) {
        jdbcTemplate.update(
                "UPDATE journal SET student_id = ?, study_plan = ?, in_time = ?, count = ?, mark_id = ?" +
                        "WHERE id = ?",
                journalRecord.getStudent_id(),
                journalRecord.getStudy_plan_id(),
                journalRecord.isIn_time(),
                journalRecord.getCount(),
                journalRecord.getMark_id(),
                id
        );
    }

    private JournalRecord mapJournal(ResultSet rs, int i) throws SQLException {
        return new JournalRecord(
                rs.getInt("id"),
                rs.getInt("student_id"),
                rs.getInt("study_plan"),
                rs.getBoolean("in_time"),
                rs.getInt("count"),
                rs.getInt("mark_id"),
                rs.getString("student_full_name"),
                rs.getString("subject_name"),
                rs.getString("subject_short_name"),
                rs.getString("exam_type"),
                rs.getString("mark_name"),
                rs.getString("mark_value")
        );
    }

    public void delete(int id) {
        jdbcTemplate.update(
                "DELETE FROM journal WHERE id = ?",
                id
        );
    }
}
