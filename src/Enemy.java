public class Enemy extends GameCharacter implements DamagableInterface {
    float hitDmg;
    float shotDmg;
    String name;

    public Enemy(int x, int y, int r,
                 float health,
                 float shotDmg, float hitDmg,
                 Projectile shotType, String name) {
        super(x, y, r, "assets/lil.png", health, shotType);
        this.hitDmg = hitDmg;
        this.shotDmg = shotDmg;
        this.name = name;
    }

    public boolean damageActor(Player player) {
        if (player.hurtActor(this, hitDmg)) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public GameCharacter makeGameCharacter(int x, int y) {
        return new Enemy(x, y, super.getRadius(), super.getHealth(), shotDmg, hitDmg, projectileType, "lil");
    }

    public Enemy makeEnemy(int x, int y) {
        return new Enemy(x, y, super.getRadius(), super.getHealth(), shotDmg, hitDmg, projectileType, "lil");
    }
}