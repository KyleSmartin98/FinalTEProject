package com.techelevator.dao;


import com.techelevator.model.Office;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcOfficeDao implements OfficeDao{
    @Override
    public List<Office> findAll() {
        return null;
    }

    @Override
    public Office getOfficeById(Long officeId) {
        return null;
    }

    @Override
    public Office findByOfficeName(String officeName) {
        return null;
    }

    @Override
    public int findIdByOfficeName(String officeName) {
        return 0;
    }
}
