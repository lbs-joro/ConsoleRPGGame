public class Character {
    protected String name;
    protected int health;
    protected int damage;

    public Character(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void attack(Character opponent) {
        System.out.println(name + " attacks " + opponent.name + " for " + damage + " damage.");
        opponent.takeDamage(damage);
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        } else {
            System.out.println(name + " has " + health + " health remaining.");
        }
    }

    public boolean isAlive() {
        return health > 0;
    }
}
