    package com.example.recipes.my_app.dto;


    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import com.fasterxml.jackson.annotation.JsonInclude;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;

    import java.util.List;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class SummaryRecipeDTO {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private List<SummaryRecipeDTO> results;
        private String title;
        private String image;

        private NutritionDTO nutrition;

        public NutritionDTO getNutrition() {
            return nutrition;
        }

        public void setNutrition(NutritionDTO nutrition) {
            this.nutrition = nutrition;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }


        public List<SummaryRecipeDTO> getResults() {
            return results;
        }

        public void setResults(List<SummaryRecipeDTO> results) {
            this.results = results;
        }



        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
