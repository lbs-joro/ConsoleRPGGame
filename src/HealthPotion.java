public class HealthPotion extends Consumable{
    int healAmount = 5;
    @Override
    public void use(Player player) {
        System.out.println("Used healthpotion");
        player.health += healAmount;
        System.out.println("Player health: " + player.health);
    }
}
