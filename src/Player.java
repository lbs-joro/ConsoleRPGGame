public class Player extends Character{

    int level = 1;
    int experiencePoints = 0;

    public Player(String name, int health, int damage) {
        super(name, health, damage);
    }

    public void levelUp(int experience) {
        experiencePoints += experience;
        if(experiencePoints > level*20){
            health += 5;
            damage += 2;
            level ++;

            System.out.println("Congratulations! " + name + " leveled up!");
            System.out.println("You are now level " + level);
        }


    }
}
