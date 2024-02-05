public class ManaPotion extends Consumable{
    int amount = 5;
    @Override
    public void use(Player player) {
        player.mana += amount;
    }
}
