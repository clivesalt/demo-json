package com.example.demo;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @GetMapping("/hello1")
    Hello hello() {
        return new Hello("test", "New York");
    }

    @GetMapping("/hello2")
    Hello2 hello2() {
        return new Hello2("Test", "London");
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    static class Hello2 {
        private final String firstName;
        private final String cityOfBirth;

        public Hello2(String firstName, String cityOfBirth) {
            this.firstName = firstName;
            this.cityOfBirth = cityOfBirth;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getCityOfBirth() {
            return cityOfBirth;
        }

        @Override
        public String toString() {
            return "Hello{" +
                    "firstName='" + firstName + '\'' +
                    ", cityOfBirth='" + cityOfBirth + '\'' +
                    '}';
        }
    }

    static class Hello {
        private final String nickName;
        private final String cityOfBirth;

        public Hello(String nickName, String cityOfBirth) {
            this.nickName = nickName;
            this.cityOfBirth = cityOfBirth;
        }

        public String getNickName() {
            return nickName;
        }

        public String getCityOfBirth() {
            return cityOfBirth;
        }

        @Override
        public String toString() {
            return "Hello{" +
                    "nickName='" + nickName + '\'' +
                    ", cityOfBirth='" + cityOfBirth + '\'' +
                    '}';
        }
    }
}
