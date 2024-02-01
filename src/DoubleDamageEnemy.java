import java.util.Random;

public class DoubleDamageEnemy extends Enemy{
    public DoubleDamageEnemy(String name, int health, int damage, int experienceGained) {
        super(name, health, damage, experienceGained);
    }

    @Override
    public void attack(Character opponent){
        Random rand = new Random();
        if(rand.nextDouble() < 0.5){
            opponent.takeDamage(2*damage);
            System.out.println(name + " attacks with double damage!!");
            System.out.println(name + " attacks " + opponent.name + " for " + 2*damage + " damage.");
        }else{
            opponent.takeDamage(damage);
            System.out.println(name + " attacks " + opponent.name + " for " + damage + " damage.");
        }



    }
}
