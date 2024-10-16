package com.logan.SpringJDBC.repo;

import com.logan.SpringJDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s1) {
        String sql = "insert into student (rollno, name, marks) values (?, ?, ?)";
        int rows = jdbc.update(sql, s1.getRollno(), s1.getName(), s1.getMarks());
        System.out.println(rows + "affected");

    }

    public List<Student> findAll() {
        String sql = "select * from student";
        //this is an interface, so we have to implement it
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student tempStudent = new Student();
                tempStudent.setRollno(rs.getInt("rollno"));
                tempStudent.setName(rs.getString("name"));
                tempStudent.setMarks(rs.getInt("marks"));

                return tempStudent;
            }
        };

        return jdbc.query(sql, mapper);
    }
}
