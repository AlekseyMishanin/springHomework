package lesson1.defaultlistablebeanfactory;

public class BookwormOracle implements Oracle {
    private Object encyclopedia;

    public void setEncyclopedia(Object encyclopedia) {
        this.encyclopedia = encyclopedia;
    }

    public String defineMeaningOfLife() {
        return "Hello world!!";
    }
}
