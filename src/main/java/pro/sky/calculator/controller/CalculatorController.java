package pro.sky.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.service.CalculatorService;


@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }

    @GetMapping
    public String showGreetings() {
        return service.greeting();
    }

    @GetMapping("/plus")
    public String plusResult(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Неверные данные";
        } else {
            return num1 + "+" + num2 + "=" + service.plus(num1, num2);
        }
    }

    @GetMapping("/minus")
    public String minusResult(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Неверные данные";
        } else {
            return num1 + "-" + num2 + "=" + service.minus(num1, num2);
        }
    }

    @GetMapping("/multiply")
    public String multiplyResult(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Неверные данные";
        } else {
            return num1 + "*" + num2 + "=" + service.multiply(num1, num2);
        }
    }

    @GetMapping("/divide")
    public String divideResult(@RequestParam(required = false) Integer num1, @RequestParam(required = false) Integer num2) {
        if (num1 == null || num2 == null) {
            return "Неверные данные";
        } else if (num2 == 0) {
            return "На ноль делить нельзя";
        } else {
            return num1 + "/" + num2 + "=" + service.divide(num1, num2);
        }
    }
}

