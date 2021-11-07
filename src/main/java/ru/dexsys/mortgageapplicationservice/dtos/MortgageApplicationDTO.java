package ru.dexsys.mortgageapplicationservice.dtos;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class MortgageApplicationDTO {
    private String firstName;
    private String patronymic;
    private String lastName;
    private String gender;
    private Integer passport;
    private LocalDate birthday;
    private BigDecimal salary;
    private BigDecimal creditAmount;
    private Integer durationInMonths;

    public MortgageApplicationDTO(MortgageApplicationDTOBuilder builder) {
        this.firstName = builder.firstName;
        this.patronymic = builder.patronymic;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.passport = builder.passport;
        this.birthday = builder.birthday;
        this.salary = builder.salary;
        this.creditAmount = builder.creditAmount;
        this.durationInMonths = builder.durationInMonths;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Client: ")
                .append("first name: ").append(firstName)
                .append(" patronymic: ").append(patronymic)
                .append(" last name: ").append(lastName)
                .append("; gender: ").append(gender)
                .append("; passport: ").append(passport)
                .append("; birthday: ").append(birthday)
                .append("; salary = ").append(salary)
                .append("; credit amount: ").append(creditAmount)
                .append("; duration in months: ").append(durationInMonths);
        return builder.toString();
    }

    public static class MortgageApplicationDTOBuilder{
        private String firstName;
        private String patronymic;
        private String lastName;
        private String gender;
        private Integer passport;
        private LocalDate birthday;
        private BigDecimal salary;
        private BigDecimal creditAmount;
        private Integer durationInMonths;

        public MortgageApplicationDTOBuilder() {
            super();
        }

        public MortgageApplicationDTOBuilder setFirstName(String fName) {
            this.firstName = fName;
            return this;
        }

        public MortgageApplicationDTOBuilder setPatronymic(String patr) {
            this.patronymic = patr;
            return this;
        }

        public MortgageApplicationDTOBuilder setLastName(String lName) {
            this.lastName = lName;
            return this;
        }

        public MortgageApplicationDTOBuilder setGender(String gen) {
            this.gender = gen;
            return this;
        }

        public MortgageApplicationDTOBuilder setPassport(Integer pass) {
            this.passport = pass;
            return this;
        }

        public MortgageApplicationDTOBuilder setBirthday(LocalDate bDay) {
            this.birthday = bDay;
            return this;
        }

        public MortgageApplicationDTOBuilder setSalary(BigDecimal sal) {
            this.salary = sal;
            return this;
        }

        public MortgageApplicationDTOBuilder setCreditAmount(BigDecimal cAmount) {
            this.creditAmount = cAmount;
            return this;
        }
        public MortgageApplicationDTOBuilder setDurationInMonths(Integer durationMonths) {
            this.durationInMonths = durationMonths;
            return this;
        }

        public MortgageApplicationDTO build(){
            return new MortgageApplicationDTO(this);
        }
    }
}
