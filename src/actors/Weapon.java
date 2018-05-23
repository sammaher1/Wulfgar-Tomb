package actors;

public class Weapon {

    private String myName;
    private int myDamage;
    private double myCritChance;

    public Weapon(String name, int damage, double critChance){
        myName = name;
        myDamage = damage;
        myCritChance = critChance;

    }

    public int getDamage() {
        return myDamage;
    }

    public double getCritChance() {
        return myCritChance;
    }

    public String getName() {
        return myName;
    }

}
