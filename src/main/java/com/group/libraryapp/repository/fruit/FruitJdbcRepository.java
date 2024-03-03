package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.fruit.response.FruitSaleAmountsResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class FruitJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public FruitJdbcRepository(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    public boolean isFruitNotExist(long id){
        String readSql = "SELECT * FROM fruit WHERE id = ?";
        return jdbcTemplate.query(readSql, (rs, roNum) -> 0 , id).isEmpty();
    }

    public boolean isFruitNotExist(String name){
        String readSql = "SELECT * FROM fruit WHERE name = ?";
        return jdbcTemplate.query(readSql, (rs, roNum) -> 0 , name).isEmpty();
    }

    public void deleteFruit(String name){
        String sql = "DELETE FROM fruit WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }

    public void updateFruitState(long id){
        String sql = "UPDATE fruit SET sales_state = TRUE WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public void saveFruit(String name, LocalDate warehousingDate, long price) {
        String sql = "INSERT INTO fruit(name, warehousing_date, price, sales_state) VALUE (?, ?, ?, FALSE)";
        jdbcTemplate.update(sql, name, warehousingDate, price);
    }


    public FruitSaleAmountsResponse getFruitSalesAmount(String name){

        String readSql = "SELECT t0.amountOfSum, t1.amountOfSum FROM" +
                "(SELECT sales_state, sum(price) as amountOfSum from fruit WHERE name = ? AND sales_state = FALSE GROUP BY sales_state) AS t0," +
                "(SELECT sales_state, sum(price) as amountOfSum from fruit WHERE name = ? AND sales_state = TRUE GROUP BY sales_state) AS t1";
        List<FruitSaleAmountsResponse> list = jdbcTemplate.query(readSql, new RowMapper<FruitSaleAmountsResponse>() {
            @Override
            public FruitSaleAmountsResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                long notsalesAmount = rs.getLong("t0.amountOfSum");
                long salesAmount = rs.getInt("t1.amountOfSum");
                return new FruitSaleAmountsResponse(salesAmount, notsalesAmount);
            }
        }, name, name);

        return list.get(0);
    }




}
