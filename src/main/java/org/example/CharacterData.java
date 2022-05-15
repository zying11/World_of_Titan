package org.example;

public class CharacterData {
    private String name;
    private String height;
    private String weight;
    private String strength;
    private String agility;
    private String intelligence;
    private String coordination;
    private String leadership;

    public CharacterData(String name, String height, String weight, String strength, String agility, String intelligence, String coordination, String leadership) {
        this.name =name;
        this.height =height;
        this.weight =weight;
        this.strength =strength;
        this.agility =agility;
        this.intelligence =intelligence;
        this.coordination =coordination;
        this.leadership =leadership;
    }

    //getter method
    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getStrength() {
        return strength;
    }

    public String getAgility() {
        return agility;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public String getCoordination() {
        return coordination;
    }

    public String getLeadership() {
        return leadership;
    }

    //setter method

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public void setAgility(String agility) {
        this.agility = agility;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public void setCoordination(String coordination) {
        this.coordination = coordination;
    }

    public void setLeadership(String leadership) {
        this.leadership = leadership;
    }

    @Override
    public String toString() {
        return "CharacterData{" +
                "name='" + name + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", strength='" + strength + '\'' +
                ", agility='" + agility + '\'' +
                ", intelligence='" + intelligence + '\'' +
                ", coordination='" + coordination + '\'' +
                ", leadership='" + leadership + '\'' +
                '}'+'\n';
    }
}
