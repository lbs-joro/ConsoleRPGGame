public class Player extends Character{

    int level = 1;
    int experiencePoints = 0;

    int mana;

    public Player(String name, int health, int damage, int mana) {
        super(name, health, damage);
        this.mana = mana;
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

    public void magicAttack(Character opponent){
        if(mana >= 10){
            System.out.println(name + " does magic attack for " + damage*3 + " damage");
            mana -= 10;
            opponent.takeDamage(damage * 3 );
        }else{
            System.out.println("Not enough mana!");
        }

    }
}
