public class Player {
    public int maxHp, currentHp, weaponDamage;
    public String weapon;

    Player() {
        this.maxHp = 30;
        this.currentHp = 30;
    }

    public int getMaxHP() {
        return this.maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;

    }

    public void setCurrentHp(int currentHp){
        this.currentHp = currentHp;
    }

    public int getCurrentHp(){
        return this.currentHp;
    }

    public String getWeapon() {
        return this.weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
}
