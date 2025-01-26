    package com.example.recipes.my_app.model;

    import jakarta.persistence.Embeddable;

    @Embeddable
    public class StepDetail {

        private int number;
        private String step;


        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getStep() {
            return step;
        }

        public void setStep(String step) {
            this.step = step;
        }
    }
