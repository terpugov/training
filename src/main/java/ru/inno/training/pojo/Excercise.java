package ru.inno.training.pojo;

/**
 * Created by mikhail on 24/12/16.
 */
public class Excercise {

    private String name;
    private String description;
    private String excerciseComplexity;
    private String excerciseType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExcerciseComplexity() {
        return excerciseComplexity;
    }

    public void setExcerciseComplexity(String excerciseComplexity) {
        this.excerciseComplexity = excerciseComplexity;
    }

    public String getExcerciseType() {
        return excerciseType;
    }

    public void setExcerciseType(String excerciseType) {
        this.excerciseType = excerciseType;
    }
}
