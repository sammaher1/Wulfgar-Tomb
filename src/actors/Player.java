package actors;

import java.util.Random;

public class Player extends Actor {
    private Weapon myWeapon;
    private int myCurrentDamage;

    public Player(String name, Actor enemy, int maxHealth, int damage, int stamina){
        super(name, enemy, maxHealth, damage);
        myWeapon = new Weapon("no weapon", 0, .10);
        myCurrentDamage = myWeapon.getDamage() + super.getDamage();

    }

    public Player(String name, Actor enemy, int maxHealth, int damage, Weapon weapon){
        super(name, enemy, maxHealth, damage);
        myWeapon = weapon;
        myCurrentDamage = myWeapon.getDamage() + super.getDamage();

    }


    public int attack() {
        Random r = new Random();
        int finalDamage = myCurrentDamage + (r.nextInt(5) - 2);
        if (r.nextInt(10) < 1) {
            return criticalHit(finalDamage);
        }
        if (isAlive(finalDamage)) {
            super.getEnemy().setHealth(super.getEnemy().getHealth() - finalDamage);
        } else {
            super.getEnemy().die();
        }
        return finalDamage;
    }



    public Weapon getMyWeapon() {
        return myWeapon;
    }

    public void equipWeapon(Weapon weapon) {
        myWeapon = weapon;
        myCurrentDamage = getDamage() + myWeapon.getDamage();
    }

    private void die(){

        //implement
    }
}
