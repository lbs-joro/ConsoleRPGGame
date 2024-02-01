public class Enemy extends Character{
    int experienceGained;
    public Enemy(String name, int health, int damage, int experienceGained) {
        super(name, health, damage);
        this.experienceGained = experienceGained;
    }
}
