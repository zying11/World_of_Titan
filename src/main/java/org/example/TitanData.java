package org.example;

import java.util.Comparator;

public class TitanData {
    private int index,height,walkingLeg,runningSpeed,sumDangerRisk;
    private String type,walkingPattern,climbingSkill;

    public TitanData(int index, String type, int height, int walkingLeg, int runningSpeed,
                     String walkingPattern, String climbingSkill,int sumDangerRisk) {
        this.index=index;
        this.type=type;
        this.height = height;
        this.walkingLeg = walkingLeg;
        this.runningSpeed = runningSpeed;
        this.walkingPattern = walkingPattern;
        this.climbingSkill = climbingSkill;
        this.sumDangerRisk=sumDangerRisk;
    }

    public TitanData(int index,String type,int sumDangerRisk) {
        this.index = index;
        this.type=type;
        this.sumDangerRisk=sumDangerRisk;
    }

    //getter method
    public int getIndex() {
        return index;
    }

    public int getSumDangerRisk() {
        return sumDangerRisk;
    }

    public String getType() {
        return type;
    }

    public int getHeight() {
        return height;
    }

    public int getWalkingLeg() {
        return walkingLeg;
    }

    public int getRunningSpeed() {
        return runningSpeed;
    }

    public String getWalkingPattern() {
        return walkingPattern;
    }

    public String getClimbingSkill() {
        return climbingSkill;
    }

    //setter method
    public void setIndex(int index) {
        this.index = index;
    }

    public void setSumDangerRisk(int sumDangerRisk) {
        this.sumDangerRisk = sumDangerRisk;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWalkingLeg(int walkingLeg) {
        this.walkingLeg = walkingLeg;
    }

    public void setRunningSpeed(int runningSpeed) {
        this.runningSpeed = runningSpeed;
    }

    public void setWalkingPattern(String walkingPattern) {
        this.walkingPattern = walkingPattern;
    }

    public void setClimbingSkill(String climbingSkill) {
        this.climbingSkill = climbingSkill;
    }

    @Override
    public String toString() {
        String s;
        if(type.equalsIgnoreCase("normal titan")){
            s="Titan "+index +
                    ": "+ type +
                    " (" + height +"m"+
                    ", " + walkingLeg + " legs" +
                    ", " + runningSpeed +"ms" +
                    ", " + walkingPattern +
                    ", " + climbingSkill +
                    ") Risk=" +sumDangerRisk;
        }
        else{
            s="Titan "+index +": "+ type +" Risk=" + sumDangerRisk;
        }
        return s;
    }
}

class DangerRiskComparator implements Comparator<TitanData> {
    @Override
    public int compare(TitanData o1, TitanData o2) {
        if (o1.getSumDangerRisk() < o2.getSumDangerRisk())
            return 1;
        else if (o1.getSumDangerRisk() > o2.getSumDangerRisk())
            return -1;
        return 0;
    }
}
