package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.lang.Math;
import java.time.LocalDate;

import static java.lang.Math.abs;


@RestController
public class CalculatorController {
    @GetMapping("/add") // GET /add
    public int addTwoNumbers(CalculatorAddRequest request){
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply") // POST
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request){
        return request.getNumber1() * request.getNumber2();
    }



    //Problem #1
    @GetMapping("/api/v1/calc")
    public String addminusmultiplyTwoNumbers(CalculatorAddMinusMultiplyRequest request){
        int answerAdd = request.getNum1() + request.getNum2();
        int answerMinus = abs(request.getNum1() - request.getNum2());
        int answerMultiply = request.getNum1() * request.getNum2();

        String returnStr = "\"add\" : " + answerAdd + ",\n" + "\"minus\" : " + answerMinus + ",\n" + "\"multiply\" : " + answerMultiply;
        return returnStr;
    }

    //Problem #2
    @GetMapping("api/v1/day-of-the-week")
    public String dateToDayOfWeek(CalculatorDayOfTheWeek request){
        String requestDateStr = request.getDate();
        LocalDate requestDateLocalDate = LocalDate.parse(requestDateStr);
        String dayOfTheWeekStr = requestDateLocalDate.getDayOfWeek().toString();
        dayOfTheWeekStr = dayOfTheWeekStr.substring(0, dayOfTheWeekStr.length()-3);

        String returnStr = "\"dayOfTheWeek\" : " + "\"" + dayOfTheWeekStr + "\"" ;
        return returnStr;
    }


    //Problem #3
    @PostMapping("api/v1/addAllNumbers")
    public int addAllNumbers(@RequestBody CalculatorAddAllNumbers request){
        int sum = 0;
        for(int i = 0 ; i < request.getNumbers().length ; i++){
            sum += request.getNumbers()[i];
        }
        return sum;
    }

}
