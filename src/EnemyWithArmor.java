public class EnemyWithArmor extends Enemy{
    public EnemyWithArmor(String name, int health, int damage, int experienceGained) {
        super(name, health, damage, experienceGained);
    }

    @Override
    public void takeDamage(int amount){
        System.out.println("Enemy has armor, and only takes " + amount/2 + " damage");
        health -= amount / 2;
        if (health <= 0) {
            System.out.println(name + " has been defeated!");
        } else {
            System.out.println(name + " has " + health + " health remaining.");
        }
    }
}
