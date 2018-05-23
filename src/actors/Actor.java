package actors;

import java.util.Random;

public class Actor {

    private String myName;
    private Actor myEnemy;
    private int myHealth;
    private int myMaxHealth;
    private int myDamage;

    public Actor(String name, Actor enemy, int maxHealth, int damage) {
        myName = name;
        myEnemy = enemy;
        myMaxHealth = maxHealth;
        myHealth = maxHealth;
        myDamage = damage;
    }

    // reduces enemy health by myDamage +- a random number, unless it randomly calls critical hit.

    public int attack() {
        Random r = new Random();
        int finalDamage = myDamage + (r.nextInt(5) - 2);
        if (r.nextInt(10) < 1) {
            return criticalHit(finalDamage);
        }
        if (isAlive(finalDamage)) {
            myEnemy.setHealth(myEnemy.getHealth() - finalDamage);
        } else {
            myEnemy.die();
        }
        return finalDamage;
    }

    // called by attack method, reduces enemy health by damage * 2

    protected int criticalHit(int damage) {
        int critDamage = damage * 2;
        if (isAlive(critDamage)) {
            myEnemy.setHealth(myEnemy.getHealth() - critDamage);
        } else {
            myEnemy.die();
        }
        return critDamage;

    }

    protected boolean isAlive(int damage) {
        if (myEnemy.getHealth() - damage > 0) {
            return false;
        }
        return true;
    }

    protected void die() {
        //method for dying
    }

    public void setEnemy(Actor enemy) {
        myEnemy = enemy;
    }

    public void setHealth(int health) {
        myHealth = health;
    }

    public void setMaxHealth(int maxHealth) {
        myMaxHealth = maxHealth;
    }

    public void setDamage(int damage) {
        myDamage = damage;
    }

    public Actor getEnemy() {
        return myEnemy;
    }

    public int getHealth() {
        return myHealth;
    }

    public int getMaxHealth() {
        return myMaxHealth;
    }

    public int getDamage() {
        return myDamage;
    }

}
