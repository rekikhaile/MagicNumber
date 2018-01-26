package com.rekik.magicnumber;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MagicNumber {

    @RequestMapping("/")
    public String magicNumber(HttpServletRequest param) {

        String numberStr = param.getParameter("number");
        if(numberStr ==null)
            return "You should have entered an integer number which is greater than 0\n";
        else {
            int number = Integer.parseInt(numberStr);
            if(number <= 0)
                return "You should have entered an integer number which is greater than 0\n";
            StringBuilder magicNumStr = new StringBuilder();
            int initNum = number;
            String initNumStr = String.valueOf(initNum);
            String starting = "Starting number: \n"+initNumStr+"</br>"+initNumStr+"   ";
            magicNumStr.append(starting);

            String magicOnes = "";
            while (number != 1) {
                if (number % 2 == 0) {
                    number = number / 2;
                } else {
                    number = 3 * number + 1;

                }
                magicOnes = String.valueOf(number) + "   ";
                magicNumStr.append(magicOnes);

            }
            return magicNumStr.toString();
        }
    }
}