import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    boolean isRunning = true;
    void run(){
        Player player = new Player("Hero", 30,5);
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
        for (int i = 0; i < 5; i ++){
            Enemy enemy = new Enemy("Goblin", rand.nextInt(5,15),
                                    rand.nextInt(1,5),
                                    rand.nextInt(10,30)
            );
            enemies.add(enemy);
        }

        return enemies;
    }

    void fightSequence(Player player, Enemy enemy){

        System.out.println("You meet an enemy " + enemy.name);
        Scanner scanner = new Scanner(System.in);

        while(player.isAlive() && enemy.isAlive()){
            System.out.println("Choose an option");
            System.out.println("[a] Attack");
            System.out.println("[q] Quit");


            String ans = scanner.nextLine();

            if(ans.equals("a")){
                player.attack(enemy);
                if(enemy.isAlive()){
                    enemy.attack(player);
                }
            }else if (ans.equals("q")){
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
}
