
public class Pokemon implements Comparable<Pokemon> {
    private String name;
    private int pokedexNumber;
    private String type1;
    private String type2;
    private String classification;
    private double height;
    private double weight;
    private String abilities;
    private int generation;
    private boolean legendaryStatus;

    // Constructor
    public Pokemon(String name, int pokedexNumber, String type1, String type2, String classification, double height, double weight, String abilities, int generation, boolean legendaryStatus) {
        this.name = name;
        this.pokedexNumber = pokedexNumber;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.legendaryStatus = legendaryStatus;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getPokedexNumber() {
        return pokedexNumber;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getClassification() {
        return classification;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getAbilities() {
        return abilities;
    }

    public int getGeneration() {
        return generation;
    }

    public boolean isLegendaryStatus() {
        return legendaryStatus;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPokedexNumber(int pokedexNumber) {
        this.pokedexNumber = pokedexNumber;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public void setLegendaryStatus(boolean legendaryStatus) {
        this.legendaryStatus = legendaryStatus;
    }

    // toString method 
    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", pokedexNumber=" + pokedexNumber +
                ", type1='" + type1 + '\'' +
                ", type2='" + type2 + '\'' +
                ", classification='" + classification + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", abilities='" + abilities + '\'' +
                ", generation=" + generation +
                ", legendaryStatus=" + legendaryStatus +
                '}';
    }

    // compareTo
    // Este método nos va a servir para ordenar los pokemon por type1 en el TreeSet
    @Override
    public int compareTo(Pokemon other) {
        return this.type1.compareTo(other.type1);
    }
}