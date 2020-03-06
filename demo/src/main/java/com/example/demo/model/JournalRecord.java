package com.example.demo.model;

public class JournalRecord {

    private int id;
    private int student_id;
    private int study_plan_id;
    private boolean in_time;
    private int count;
    private int mark_id;
    private String student_full_name;
    private String subject_name;
    private String subject_short_name;
    private String exam_type;
    private String mark_name;
    private String mark_value;

    public JournalRecord() {
    }

    public JournalRecord(int id, int student_id, int study_plan_id, boolean in_time, int count, int mark_id) {
        this.id = id;
        this.student_id = student_id;
        this.study_plan_id = study_plan_id;
        this.in_time = in_time;
        this.count = count;
        this.mark_id = mark_id;
    }

    public JournalRecord(int id, int student_id, int study_plan_id, boolean in_time, int count, int mark_id,
                         String student_full_name, String subject_name, String subject_short_name, String exam_type,
                         String mark_name, String mark_value) {
        this(id, student_id, study_plan_id, in_time, count, mark_id);
        this.student_full_name = student_full_name;
        this.subject_name = subject_name;
        this.subject_short_name = subject_short_name;
        this.exam_type = exam_type;
        this.mark_name = mark_name;
        this.mark_value = mark_value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getStudy_plan_id() {
        return study_plan_id;
    }

    public void setStudy_plan_id(int study_plan_id) {
        this.study_plan_id = study_plan_id;
    }

    public boolean isIn_time() {
        return in_time;
    }

    public void setIn_time(boolean in_time) {
        this.in_time = in_time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMark_id() {
        return mark_id;
    }

    public void setMark_id(int mark_id) {
        this.mark_id = mark_id;
    }

    public String getStudent_full_name() {
        return student_full_name;
    }

    public void setStudent_full_name(String student_full_name) {
        this.student_full_name = student_full_name;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

    public String getSubject_short_name() {
        return subject_short_name;
    }

    public void setSubject_short_name(String subject_short_name) {
        this.subject_short_name = subject_short_name;
    }

    public String getExam_type() {
        return exam_type;
    }

    public void setExam_type(String exam_type) {
        this.exam_type = exam_type;
    }

    public String getMark_name() {
        return mark_name;
    }

    public void setMark_name(String mark_name) {
        this.mark_name = mark_name;
    }

    public String getMark_value() {
        return mark_value;
    }

    public void setMark_value(String mark_value) {
        this.mark_value = mark_value;
    }
}

