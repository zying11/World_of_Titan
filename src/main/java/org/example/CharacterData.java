package org.example;

import java.util.Comparator;

public class CharacterData {
    private String name;
    private String height;
    private String weight;
    private String strength;
    private String agility;
    private String intelligence;
    private String coordination;
    private String leadership;

    //constructor
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

    public CharacterData(String name,String attribute) {
        this.name = name;
        this.height=attribute;
        this.weight=attribute;
        this.strength=attribute;
        this.agility=attribute;
        this.intelligence=attribute;
        this.coordination=attribute;
        this.leadership=attribute;
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

class HeightComparator implements Comparator<CharacterData> {
    @Override
    public int compare(CharacterData character1, CharacterData character2)
    {
        if(character1.getHeight() == character2.getHeight())
            return 0;
        else if(Integer.parseInt(character1.getHeight())>Integer.parseInt(character2.getHeight()))
            return -1;
        else
            return 1;
    }
}

class WeightComparator implements Comparator<CharacterData> {
    @Override
    public int compare(CharacterData character1, CharacterData character2)
    {
        if(character1.getWeight() == character2.getWeight())
            return 0;
        else if(Integer.parseInt(character1.getWeight())>Integer.parseInt(character2.getWeight()))
            return -1;
        else
            return 1;
    }
}

class StrengthComparator implements Comparator<CharacterData> {
    @Override
    public int compare(CharacterData character1, CharacterData character2)
    {
        if(character1.getStrength() == character2.getStrength())
            return 0;
        else if(Integer.parseInt(character1.getStrength())>Integer.parseInt(character2.getStrength()))
            return -1;
        else
            return 1;
    }
}

class AgilityComparator implements Comparator<CharacterData> {
    @Override
    public int compare(CharacterData character1, CharacterData character2)
    {
        if(character1.getAgility() == character2.getAgility())
            return 0;
        else if(Integer.parseInt(character1.getAgility())>Integer.parseInt(character2.getAgility()))
            return -1;
        else
            return 1;
    }
}

class IntelligenceComparator implements Comparator<CharacterData> {
    @Override
    public int compare(CharacterData character1, CharacterData character2)
    {
        if(character1.getIntelligence() == character2.getIntelligence())
            return 0;
        else if(Integer.parseInt(character1.getIntelligence())>Integer.parseInt(character2.getIntelligence()))
            return -1;
        else
            return 1;
    }
}

class CoordinationComparator implements Comparator<CharacterData> {
    @Override
    public int compare(CharacterData character1, CharacterData character2)
    {
        if(character1.getCoordination() == character2.getCoordination())
            return 0;
        else if(Integer.parseInt(character1.getCoordination())>Integer.parseInt(character2.getCoordination()))
            return -1;
        else
            return 1;
    }
}

class LeadershipComparator implements Comparator<CharacterData> {
    @Override
    public int compare(CharacterData character1, CharacterData character2)
    {
        if(character1.getLeadership() == character2.getLeadership())
            return 0;
        else if(Integer.parseInt(character1.getLeadership())>Integer.parseInt(character2.getLeadership()))
            return -1;
        else
            return 1;
    }
}
