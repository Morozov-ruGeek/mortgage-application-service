package ru.dexsys.mortgageapplicationservice.dtos;

import lombok.Getter;
import ru.dexsys.mortgageapplicationservice.entities.Mortgage;

import java.math.BigDecimal;
import java.util.Collection;

@Getter
public class ClientDTO {
    private String firstName;
    private String patronymic;
    private String lastName;
    private String gender;
    private Integer passport;
    private BigDecimal salary;
    private Collection<Mortgage> mortgages;

    public ClientDTO(ClientDTOBuilder builder){
        this.firstName = builder.firstName;
        this.patronymic = builder.patronymic;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.passport = builder.passport;
        this.salary = builder.salary;
        this.mortgages = builder.mortgages;
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
                .append("; salary = ").append(salary)
                .append("; mortgages: ").append(mortgages);
        return builder.toString();
    }

    public static class ClientDTOBuilder {
        private String firstName;
        private String patronymic;
        private String lastName;
        private String gender;
        private Integer passport;
        private BigDecimal salary;
        private Collection<Mortgage> mortgages;

        public ClientDTOBuilder() {
            super();
        }

        public ClientDTOBuilder setFirstName(String fName) {
            this.firstName = fName;
            return this;
        }

        public ClientDTOBuilder setPatronymic(String patr) {
            this.patronymic = patr;
            return this;
        }

        public ClientDTOBuilder setLastName(String lName) {
            this.lastName = lName;
            return this;
        }

        public ClientDTOBuilder setGender(String gen) {
            this.gender = gen;
            return this;
        }

        public ClientDTOBuilder setPassport(Integer pass) {
            this.passport = pass;
            return this;
        }

        public ClientDTOBuilder setSalary(BigDecimal sal) {
            this.salary = sal;
            return this;
        }

        public ClientDTOBuilder setMortgages(Collection<Mortgage> mort) {
            this.mortgages = mort;
            return this;
        }

        public ClientDTO build(){
            return new ClientDTO(this);
        }
    }
}
