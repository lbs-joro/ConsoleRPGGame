import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    boolean isRunning = true;
    Inventory<Consumable> consumableInventory = new Inventory<>();
    Inventory<Equipment> equipmentInventory = new Inventory<>();
    void run(){
        Player player = new Player("Hero", 30,5, 50);
        HealthPotion hPot = new HealthPotion();
        hPot.name = "Health Potion";
        ManaPotion mPot = new ManaPotion();
        mPot.name = "Mana Potion";

        consumableInventory.add(hPot);
        consumableInventory.add(mPot);

        List<Enemy> enemies = createEnemyList();



        int enemyIndex = 0;
        while (isRunning){
            fightSequence(player, enemies.get(enemyIndex));

            System.out.println("-------");
            System.out.println();


            enemyIndex ++;
            if(enemyIndex == enemies.size()){
                System.out.println("Congratulations, you defeated all the enemies!");
                isRunning = false;
            }
        }
    }

    List<Enemy> createEnemyList(){
        List<Enemy> enemies = new ArrayList<>();
        Random rand = new Random();

        EnemyWithArmor enemyWithArmor = new EnemyWithArmor("Goblin", rand.nextInt(5,15),
                rand.nextInt(1,5),
                rand.nextInt(10,30)
        );

        Enemy normalEnemy = new Enemy("Troll", 16, 4, rand.nextInt(10,30));

        DoubleDamageEnemy doubleDamageEnemy = new DoubleDamageEnemy("Evil Wizard", rand.nextInt(10,20), 6, rand.nextInt(10,30) );

        enemies.add(enemyWithArmor);
        enemies.add(normalEnemy);
        enemies.add(doubleDamageEnemy);

        return enemies;
    }

    void fightSequence(Player player, Enemy enemy){

        System.out.println("You meet an enemy " + enemy.name);
        Scanner scanner = new Scanner(System.in);

        while(player.isAlive() && enemy.isAlive()){
            System.out.println("Choose an option");
            System.out.println("[a] Attack");
            System.out.println("[m] Magic attack");
            System.out.println("[u] Use item");
            System.out.println("[q] Quit");


            String ans = scanner.nextLine();

            if(ans.equals("a")){
                player.attack(enemy);
                if(enemy.isAlive()){
                    enemy.attack(player);
                }
            }else if (ans.equals("m")){
                player.magicAttack(enemy);
                if(enemy.isAlive()){
                    enemy.attack(player);
                }
            }else if (ans.equals("u")){
                useItem(player);
            }
            else if (ans.equals("q")){
                System.out.println("You quit the game");
                isRunning = false;
                return;
            }else {
                System.out.println("Not a valid choice");
            }

        }

        if (player.isAlive()) {
            System.out.println("Congratulations! You defeated the enemy!");
            player.levelUp(enemy.experienceGained);
        } else {
            System.out.println("Game over. You were defeated by the enemy.");
            isRunning = false;
        }
    }

    void useItem(Player player){
        consumableInventory.print();
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();

        Consumable consumable = consumableInventory.getItem(index);
        consumable.use(player);

    }
}
