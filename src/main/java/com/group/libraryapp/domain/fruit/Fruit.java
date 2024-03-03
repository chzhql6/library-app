package com.group.libraryapp.domain.fruit;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 20, name = "name")
    private String name;

    @Column(nullable = false, name = "warehousing_date")
    private LocalDate warehousingDate;

    @Column(name = "price")
    private Long price;

    @Column(nullable = false, name = "sales_state")
    private Boolean salesState;

    protected Fruit() {}

    public Fruit(String name, LocalDate warehousingDate, long price) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.salesState = Boolean.FALSE;
    }




    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }
    public boolean getSalesState() {
        return salesState;
    }


    public void updateState(boolean salesState){
        this.salesState = salesState;
    }

}
