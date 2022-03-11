package co.edu.unicauca.cor.domain;

/**
 *
 * @author Libardo, Julio
 */
public class ClaimManager {

    private LevelOne levelOne;
    private LevelTwo levelTwo;
    private LevelThree levelThree;
    private LevelFour levelFour;

   

    public void createAthentionFlow() {
        levelOne = new LevelOne("mariaortega@gmail.com");
        levelTwo = new LevelTwo("oscarsanchez@gmail.com");
        levelThree = new LevelThree("kate@gmail.com");
        levelFour = new LevelFour("camilopena@gmail.com");
        // Crea los enlaces
        levelOne.setNextHandler(levelTwo);
        levelTwo.setNextHandler(levelThree);
        levelThree.setNextHandler(levelFour);
        
    }

    public LevelOne getLevelOne() {
        return levelOne;
    }

    public void setLevelOne(LevelOne levelOne) {
        this.levelOne = levelOne;
    }

    public LevelTwo getLevelTwo() {
        return levelTwo;
    }

    public void setLevelTwo(LevelTwo levelTwo) {
        this.levelTwo = levelTwo;
    }

    public LevelThree getLevelThree() {
        return levelThree;
    }

    public void setLevelThree(LevelThree levelThree) {
        this.levelThree = levelThree;
    }
    
    
    public LevelFour getLeverFour() {
        return levelFour;
    }

    public void setLeverFour(LevelFour leverFour) {
        this.levelFour = leverFour;
    }

}